/**
 * FileName: Seller
 * Author:   tbj12
 * Date:     2018/3/10 0010 16:35
 * Description:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.tbj.entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author tbj12
 * @create 2018/3/10 0010
 * @since 1.0.0
 */
public class Seller {
    private int id;
    private String phoneNumber;
    private String windowImg;
    private String password;
    private int state;
    private String sellerName;
    private String windowName;

    public Seller(int id, String phoneNumber, String windowImg, String password, int state, String sellerName, String windowName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.windowImg = windowImg;
        this.password = password;
        this.state = state;
        this.sellerName = sellerName;
        this.windowName = windowName;
    }

    public Seller(String phoneNumber, String windowImg, String sellerName) {
        this.phoneNumber = phoneNumber;
        this.windowImg = windowImg;
        this.sellerName = sellerName;
    }

    public Seller() {
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", windowImg='" + windowImg + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", sellerName='" + sellerName + '\'' +
                ", windowName='" + windowName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWindowImg() {
        return windowImg;
    }

    public void setWindowImg(String windowImg) {
        this.windowImg = windowImg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }
}