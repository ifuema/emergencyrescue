package team.ghjly.emergencyrescue.entity;

public class Commodity {
  //商品编号
  private Integer cId;
  //商品图片
  private String cImg;
  //商品价格
  private String cPrice;
  //商品名称
  private String cName;
  //商品简介
  private String cIntroduce;
  //商品链接
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
