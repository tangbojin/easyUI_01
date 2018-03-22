/**
 * FileName: UserDao
 * Author:   tbj12
 * Date:     2018/3/14 0014 21:23
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.dao;

import cn.tbj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/14 0014
 * @since 1.0.0
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User login(String username) {
        User user = (User) jdbcTemplate.queryForObject("select * from user where username = ?", new UserRowMapper(),username);
        return user;
    }

    public Integer register(String username,String password,String phoneNumber) {
        List queryUser = jdbcTemplate.query("select * from user where username = ?", new UserRowMapper(), username);
        System.out.println("现有用户……"+queryUser);
        int i = 0;
        if (queryUser.size() == 0) {
            i = jdbcTemplate.update("insert into user(username,password,phoneNumber) values(?,?,?)", new Object[]{username,password,phoneNumber});
            System.out.println("已插入数据库……"+i);
        }else{
            System.out.println("用户已存在");
        }
        return i;
    }

}