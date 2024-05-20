package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源方法前运行，如果是true，就放行；如果是false就拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求url
        String url=request.getRequestURL().toString();
        log.info("请求的路径：{}",url);

        //2.判断url是否包含login或者register，如果包含，就放行
        if(url.contains("login") || url.contains("register")){
            log.info("放行");
            return true;
        }

        //3.获取请求头中的令牌
        String jwt=request.getHeader("token");

        //4.判断令牌是否存在，如果不存在，就返回错误结果，让用户先登录
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            Result error =Result.error("Not Login!");
            //转换json到阿里巴巴的fastJson
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //5.解析jwt令牌，如果解析失败，返回错误结果
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e) {//jwt令牌解析失败、
            e.printStackTrace();
            log.info("令牌解析失败，那就是未登录！");
            Result error =Result.error("Not Login!");
            //转换json到阿里巴巴的fastJson
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //6.令牌正确，放行
        log.info("验证通过！");
        return true;

    }

    @Override//目标资源方法后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//视图渲染结束后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
