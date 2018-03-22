/**
 * FileName: FoodRowMapper
 * Author:   tbj12
 * Date:     2018/3/10 0010 15:16
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.dao;

import cn.tbj.entity.Food;
import cn.tbj.entity.Seller;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/10 0010
 * @since 1.0.0
 */
public class SellerRowMapper implements RowMapper{

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String phoneNumber = resultSet.getString("phoneNumber");
        String windowImg = resultSet.getString("windowImg");
        String password = resultSet.getString("password");
        int state = resultSet.getInt("state");
        String sellerName = resultSet.getString("sellerName");
        String windowName = resultSet.getString("windowName");

        return new Seller(id,phoneNumber,windowImg,password,state,sellerName,windowName);
    }
}