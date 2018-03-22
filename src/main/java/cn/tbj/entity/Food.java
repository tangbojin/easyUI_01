/**
 * FileName: Food
 * Author:   tbj12
 * Date:     2018/3/10 0010 15:10
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
public class Food {
    private Long id;
    private String foodImg;
    private Double foodPrice;
    private String foodName;
    private String priceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public Food(String foodName, Double foodPrice, String foodImg, String priceType) {
        this.foodImg = foodImg;
        this.foodPrice = foodPrice;
        this.foodName = foodName;
        this.priceType = priceType;
    }

    public Food(Long id, String foodName, Double foodPrice, String foodImg, String priceType) {
        this.id = id;
        this.foodImg = foodImg;
        this.foodPrice = foodPrice;
        this.foodName = foodName;
        this.priceType = priceType;
    }

    public Food() {
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodImg='" + foodImg + '\'' +
                ", foodPrice=" + foodPrice +
                ", foodName='" + foodName + '\'' +
                ", priceType='" + priceType + '\'' +
                '}';
    }
}