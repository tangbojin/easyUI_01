/**
 * FileName: FoodDao
 * Author:   tbj12
 * Date:     2018/3/10 0010 15:12
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.dao;

import cn.tbj.entity.Food;
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
public class FoodDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Food> getFoodPage(Integer star,Integer rows,String sort,String order) {
        List<Food> foods = jdbcTemplate.query("select * from food order by "+sort+" "+order+" limit ?,?", new FoodRowMapper(), star, rows);
        return foods;
    }

    public Integer getCount() {
        return jdbcTemplate.queryForObject("select count(*) from food", Integer.class);
    }

    public int addFood(Food food) {
        return jdbcTemplate.update("insert into food (foodName,foodPrice,foodImg,priceType) values(?,?,?,?)",new Object[]{food.getFoodName(),food.getFoodPrice(),food.getFoodImg(),food.getPriceType()});
    }

    public int deleteFood(long id) {
        return jdbcTemplate.update("delete from food where id = ?",new Object[]{id});
    }
}