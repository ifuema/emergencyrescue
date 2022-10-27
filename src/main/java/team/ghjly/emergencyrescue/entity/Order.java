package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.Regist;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

public class Order {
  //订单编号
  private Integer oId;
  //订单用户编号
  private Integer uId;
  //订单商品编号
  private Integer cId;
  //下单数量
  private Integer oNum;
  //收件人姓名
  private String oName;
  //下单时间
  private Timestamp oTime;
  //订单状态
  private String oState;
  //收件联系电话
  private Long oTelephone;
  //收件地址
  private String oAddress;
  //订单总价
  private String oPrice;
  //订单号
  @NotBlank(message = "订单号不能为空！", groups = {Regist.class})
  private String oTrade;
  //备注
  private String oRemake;


  public Integer getoId() {
    return oId;
  }

  public void setoId(Integer oId) {
    this.oId = oId;
  }


  public Integer getuId() {
    return uId;
  }

  public void setuId(Integer uId) {
    this.uId = uId;
  }


  public Integer getcId() {
    return cId;
  }

  public void setcId(Integer cId) {
    this.cId = cId;
  }


  public Integer getoNum() {
    return oNum;
  }

  public void setoNum(Integer oNum) {
    this.oNum = oNum;
  }


  public String getoName() {
    return oName;
  }

  public void setoName(String oName) {
    this.oName = oName;
  }


  public Timestamp getoTime() {
    return oTime;
  }

  public void setoTime(Timestamp oTime) {
    this.oTime = oTime;
  }


  public String getoState() {
    return oState;
  }

  public void setoState(String oState) {
    this.oState = oState;
  }


  public Long getoTelephone() {
    return oTelephone;
  }

  public void setoTelephone(Long oTelephone) {
    this.oTelephone = oTelephone;
  }


  public String getoAddress() {
    return oAddress;
  }

  public void setoAddress(String oAddress) {
    this.oAddress = oAddress;
  }


  public String getoPrice() {
    return oPrice;
  }

  public void setoPrice(String oPrice) {
    this.oPrice = oPrice;
  }


  public String getoTrade() {
    return oTrade;
  }

  public void setoTrade(String oTrade) {
    this.oTrade = oTrade;
  }


  public String getoRemake() {
    return oRemake;
  }

  public void setoRemake(String oRemake) {
    this.oRemake = oRemake;
  }


  @Override
  public String toString() {
    return "Order{" +
            "oId=" + oId +
            ", uId=" + uId +
            ", cId=" + cId +
            ", oNum=" + oNum +
            ", oName='" + oName + '\'' +
            ", oTime=" + oTime +
            ", oState='" + oState + '\'' +
            ", oTelephone=" + oTelephone +
            ", oAddress='" + oAddress + '\'' +
            ", oPrice='" + oPrice + '\'' +
            ", oTrade='" + oTrade + '\'' +
            ", oRemake='" + oRemake + '\'' +
            '}';
  }
}
