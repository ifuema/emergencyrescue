package team.ghjly.emergencyrescue.entity;


import java.math.BigDecimal;

public class Commodity {

  private Integer cId;
  private Integer cNum;
  private String cImg;
  private BigDecimal cPrice;
  private String cName;
  private String cIntroduce;


  public Integer getCId() {
    return cId;
  }

  public void setCId(Integer cId) {
    this.cId = cId;
  }


  public Integer getCNum() {
    return cNum;
  }

  public void setCNum(Integer cNum) {
    this.cNum = cNum;
  }


  public String getCImg() {
    return cImg;
  }

  public void setCImg(String cImg) {
    this.cImg = cImg;
  }


  public BigDecimal getCPrice() {
    return cPrice;
  }

  public void setCPrice(BigDecimal cPrice) {
    this.cPrice = cPrice;
  }


  public String getCName() {
    return cName;
  }

  public void setCName(String cName) {
    this.cName = cName;
  }


  public String getCIntroduce() {
    return cIntroduce;
  }

  public void setCIntroduce(String cIntroduce) {
    this.cIntroduce = cIntroduce;
  }

}
