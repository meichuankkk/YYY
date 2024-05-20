package com.itheima.mapper;

import com.itheima.pojo.Event;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EventMapper {

      @Select(" SELECT *\n" +
              "        FROM user\n" +
              "        WHERE id = (\n" +
              "            SELECT userId\n" +
              "            FROM event\n" +
              "            WHERE eventName = #{eventName}\n" +
              "        )")
      User getOwner(String eventName);

      @Select(" select *\n" +
              "        from event\n" +
              "        where eventName = #{eventName}")
      Event getEvent(String eventName);
}
