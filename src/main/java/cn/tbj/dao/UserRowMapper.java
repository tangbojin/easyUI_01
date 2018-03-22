/**
 * FileName: UserRowMapper
 * Author:   tbj12
 * Date:     2018/3/14 0014 21:23
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.dao;

import cn.tbj.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/14 0014
 * @since 1.0.0
 */
public class UserRowMapper  implements RowMapper{

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String phoneNumber = resultSet.getString("phoneNumber");

        return new User(id,username,password,phoneNumber);
    }
}