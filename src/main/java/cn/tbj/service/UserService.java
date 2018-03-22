/**
 * FileName: UserService
 * Author:   tbj12
 * Date:     2018/3/14 0014 21:22
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.service;

import cn.tbj.dao.UserDao;
import cn.tbj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/14 0014
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User login(String username) {
        return userDao.login(username);
    }

    public Integer register(String username,String password,String phoneNumber) {
        return userDao.register(username,password,phoneNumber);
    }

}