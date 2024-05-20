package com.itheima.mapper;

import com.itheima.pojo.Event;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(" select *\n" +
            "        from user\n" +
            "        where username = #{userName}")
    User getOwner(String userName);

    @Select(" SELECT *\n" +
            "        FROM event\n" +
            "        WHERE userId = (\n" +
            "            SELECT id\n" +
            "            FROM user\n" +
            "            WHERE username = #{userName}\n" +
            "        )")
    List<Event> getEvent(String userName);

    @Insert("insert into user(id, username, password) value (#{id},#{username},#{password})")
    void register(User user);

    @Select("SELECT username FROM user WHERE username = #{username}")
    String isUsernameExists(String username);

    @Select(" select *\n" +
            "        from user\n" +
            "        where username = #{username}\n" +
            "          and password = #{password}")
    User login(User user);

    @Insert("insert into user(id, username, password) value (#{id},#{username},#{password})")
    void addUser(User user);

    @Select("select * from user where id=#{id}")
    User getById(Integer id);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void changeUser(User user);
}

