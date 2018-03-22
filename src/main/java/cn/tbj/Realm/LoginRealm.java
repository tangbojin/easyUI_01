/**
 * FileName: LoginRealm
 * Author:   tbj12
 * Date:     2018/3/18 0018 16:18
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.Realm;

import cn.tbj.dao.UserDao;
import cn.tbj.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/18 0018
 * @since 1.0.0
 */
public class LoginRealm extends AuthenticatingRealm{
    @Autowired
    UserDao userDao;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        User user = userDao.login(principal);
        if (user != null) {
            String password = user.getPassword();
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, password, "LoginRealm");
            System.out.println(info);
            return info;
        } else {
            throw new UnknownAccountException("用户不存在");
        }
    }

    @Override
    public String getName() {
        return "LoginRealm";
    }
}