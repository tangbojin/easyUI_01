/**
 * FileName: SellerDao
 * Author:   tbj12
 * Date:     2018/3/10 0010 16:43
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.dao;

import cn.tbj.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/10 0010
 * @since 1.0.0
 */

@Repository
public class SellerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Seller> getSellers(Integer star,Integer rows) {
        List sellers = jdbcTemplate.query("select * from seller limit ?,?", new SellerRowMapper(), star,rows);
        return sellers;
    }
}