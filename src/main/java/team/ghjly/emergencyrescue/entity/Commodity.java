package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.AdvancedRegister;
import team.ghjly.emergencyrescue.entity.groups.Register;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Commodity {
  //商品编号
  @NotNull(message = "商品编号不能为空！", groups = {AdvancedRegister.class})
  private Integer cId;
  //商品图片
  @NotBlank(message = "图片不能为空！", groups = {Register.class})
  private String cImg;
  //商品价格
  @NotBlank(message = "商品价格不能为空！", groups = {Register.class})
  @Pattern(regexp = "^[1-9](\\d){0,3}(\\.\\d{1,2})?$", message = "价格格式不正确！（范围：1.00-9999.99）", groups = {Register.class})
  private String cPrice;
  //商品名称
  @NotBlank(message = "商品名不能为空！", groups = {Register.class})
  @Size(max = 32, message = "商品名过长！", groups = {Register.class})
  private String cName;
  //商品简介
  @NotBlank(message = "简介不能为空！", groups = {Register.class})
  private String cIntroduce;
  //商品链接
  @NotBlank(message = "商品链接不能为空！", groups = {Register.class})
  private String cUrl;


  public Integer getcId() {
    return cId;
  }

  public void setcId(Integer cId) {
    this.cId = cId;
  }


  public String getcImg() {
    return cImg;
  }

  public void setcImg(String cImg) {
    this.cImg = cImg;
  }


  public String getcPrice() {
    return cPrice;
  }

  public void setcPrice(String cPrice) {
    this.cPrice = cPrice;
  }


  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }


  public String getcIntroduce() {
    return cIntroduce;
  }

  public void setcIntroduce(String cIntroduce) {
    this.cIntroduce = cIntroduce;
  }


  public String getcUrl() {
    return cUrl;
  }

  public void setcUrl(String cUrl) {
    this.cUrl = cUrl;
  }


  @Override
  public String toString() {
    return "Commodity{" +
            "cId=" + cId +
            ", cImg='" + cImg + '\'' +
            ", cPrice=" + cPrice +
            ", cName='" + cName + '\'' +
            ", cIntroduce='" + cIntroduce + '\'' +
            ", cUrl='" + cUrl + '\'' +
            '}';
  }
}
