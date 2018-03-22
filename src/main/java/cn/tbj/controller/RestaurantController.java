/**
 * FileName: MyRestaurant
 * Author:   tbj12
 * Date:     2018/3/10 0010 12:49
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.controller;

import cn.tbj.entity.Food;
import cn.tbj.entity.Seller;
import cn.tbj.entity.User;
import cn.tbj.service.FoodService;
import cn.tbj.service.SellerService;
import cn.tbj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/10 0010
 * @since 1.0.0
 */
@Controller
public class RestaurantController {
    @Autowired
    FoodService foodService;
    @Autowired
    SellerService sellerService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String username, @RequestParam String password){
        ModelAndView mav = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            mav.setViewName("/homepage.jsp");
        } else {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                subject.login(token);
                mav.setViewName("/homepage.jsp");
            } catch (IncorrectCredentialsException e) {
                mav.setViewName("/login.jsp");
                mav.addObject("error", "密码错误");
            } catch (AuthenticationException e) {
                mav.setViewName("/login.jsp");
                mav.addObject("error", "账户不存在");
            }
        }
        mav.addObject("username", username);
        mav.addObject("password", password);
        return mav;

    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(@RequestParam String username,@RequestParam String password,@RequestParam String phoneNumber) {
        ModelAndView mav = new ModelAndView();
        Integer registerState = userService.register(username,password,phoneNumber);
        if(registerState ==1){
            mav.setViewName("/login.jsp");
        }else {
            mav.addObject("username",username);
            mav.addObject("password", password);
            mav.addObject("phoneNumber", phoneNumber);
            mav.addObject("msg", "error");
            mav.setViewName("/register.jsp");
        }
        return mav;
    }


    @RequestMapping(value = "/food")
    @ResponseBody
    public Map<String,Object> showAllFood(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "4") Integer rows,@RequestParam(defaultValue = "id") String sort,@RequestParam(defaultValue = "asc") String order){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Food> foods = foodService.getFoodPage(page,rows,order,sort);
        Integer count = foodService.getCount();
        map.put("rows", foods);
        map.put("total", count);
        return map;
    }

    @RequestMapping(value = "/addFood")
    public ModelAndView addFood(@RequestParam String foodName,@RequestParam double foodPrice,@RequestParam String foodImg,@RequestParam String priceType) {
        ModelAndView mav = new ModelAndView();
        Food food = new Food(foodName, foodPrice, foodImg, priceType);
        int a = foodService.addFood(food);
        if(a ==1){
            mav.addObject("msg", "success");
            mav.setViewName("/food.jsp");
        }
        return mav;
    }

    @RequestMapping(value = "/deleteFood")
    @ResponseBody
    public  int delectFood(@RequestBody Food food) {     //@RequestBody将json串转为java对象；@ResponseBody将java对象转化为json串
        System.out.println("选中商品编号为："+food.getId());
        int temp = foodService.deleteFood(food.getId());
        if(temp > 0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        return temp;
    }

    @RequestMapping("/seller")
    @ResponseBody
    public Map<String,Object> showSeller(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "3") Integer rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Seller> sellers = sellerService.getSellers(page,rows);
        System.out.println(sellers);
        map.put("rows", sellers);
        map.put("total", 2);
        return  map;
    }
}