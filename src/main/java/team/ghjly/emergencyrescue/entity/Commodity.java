package team.ghjly.emergencyrescue.entity;

public class Commodity {
  //商品编号
  private Integer cId;
  //库存数量
  private Integer cNum;
  //商品图片
  private String cImg;
  //商品价格
  private String cPrice;
  //商品名称
  private String cName;
  //商品简介
  private String cIntroduce;


  public Integer getcId() {
    return cId;
  }

  public void setcId(Integer cId) {
    this.cId = cId;
  }


  public Integer getcNum() {
    return cNum;
  }

  public void setcNum(Integer cNum) {
    this.cNum = cNum;
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


  @Override
  public String toString() {
    return "Commodity{" +
            "cId=" + cId +
            ", cNum=" + cNum +
            ", cImg='" + cImg + '\'' +
            ", cPrice='" + cPrice + '\'' +
            ", cName='" + cName + '\'' +
            ", cIntroduce='" + cIntroduce + '\'' +
            '}';
  }
}
