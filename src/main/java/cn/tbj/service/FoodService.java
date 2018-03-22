/**
 * FileName: Foodservice
 * Author:   tbj12
 * Date:     2018/3/10 0010 16:08
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.service;

import cn.tbj.dao.FoodDao;
import cn.tbj.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/10 0010
 * @since 1.0.0
 */
@Service
public class FoodService {
    @Autowired
    private FoodDao foodDao;

    public List<Food> getFoodPage(Integer page, Integer rows,String order,String sort) {
        int star = (page - 1) * rows;
        return foodDao.getFoodPage(star,rows,sort,order);
    }

    public Integer getCount() {
        return foodDao.getCount();
    }

    public int addFood(Food food){return foodDao.addFood(food);}

    public int deleteFood(long id) {
        return foodDao.deleteFood(id);
    }

}
