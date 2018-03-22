/**
 * FileName: SellerService
 * Author:   tbj12
 * Date:     2018/3/10 0010 16:44
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.service;

import cn.tbj.dao.SellerDao;
import cn.tbj.entity.Seller;
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
public class SellerService {
    @Autowired
    private SellerDao sellerDao;
    public List<Seller> getSellers(Integer page,Integer rows) {
        int star = (page-1)*rows;
        return sellerDao.getSellers(star,rows);
    }

}