package team.ghjly.emergencyrescue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import team.ghjly.emergencyrescue.entity.groups.Regist;

import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.locks.StampedLock;

public class Rescue {
  //救援编号
  private Integer rId;
  //申请救援队编号
  private Integer tId;
  //申请救援用户编号
  private Integer uId;
  //救助人姓名
  @NotBlank(message = "姓名不能为空！", groups = {Regist.class})
  @Size(max = 8, message = "姓名过长！", groups = {Regist.class})
  private String rName;
  //救助人年龄
  @NotNull(message = "年龄不能为空！", groups = {Regist.class})
  @PositiveOrZero(message = "年龄格式不正确！", groups = {Regist.class})
  private Integer rAge;
  //救助人性别
  @NotNull(message = "性别不能为空！", groups = {Regist.class})
  @Pattern(regexp = "^[男女]$", message = "性别只能为男或女！", groups = {Regist.class})
  private String rGender;
  //救助人地址
  @NotBlank(message = "地址不能为空！", groups = {Regist.class})
  @Size(max = 255, message = "地址过长！", groups = {Regist.class})
  private String rAddress;
  //救助人联系电话
  @NotNull(message = "电话不能为空！", groups = {Regist.class})
  @PositiveOrZero(message = "电话格式不正确！", groups = {Regist.class})
  @DecimalMax(value = "99999999999", message = "电话号码过长！", groups = {Regist.class})
  private Long rTelephone;
  //救助状态
  private String rState;
  //申请救援时间
  private Timestamp rTime;
  //救助人既往病史
  @Size(max = 255, message = "既往病史过长！", groups = {Regist.class})
  private String pastMedicalHistory;
  //救助人过敏史
  @Size(max = 255, message = "过敏史过长！", groups = {Regist.class})
  private String allergyHistory;
  //救援描述
  @NotNull(message = "描述不能为空！", groups = {Regist.class})
  private String rDescribe;


  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }


  public Integer gettId() {
    return tId;
  }

  public void settId(Integer tId) {
    this.tId = tId;
  }


  public Integer getuId() {
    return uId;
  }

  public void setuId(Integer uId) {
    this.uId = uId;
  }


  public String getrName() {
    return rName;
  }

  public void setrName(String rName) {
    this.rName = rName;
  }


  public Integer getrAge() {
    return rAge;
  }

  public void setrAge(Integer rAge) {
    this.rAge = rAge;
  }


  public String getrGender() {
    return rGender;
  }

  public void setrGender(String rGender) {
    this.rGender = rGender;
  }


  public String getrAddress() {
    return rAddress;
  }

  public void setrAddress(String rAddress) {
    this.rAddress = rAddress;
  }


  public Long getrTelephone() {
    return rTelephone;
  }

  public void setrTelephone(Long rTelephone) {
    this.rTelephone = rTelephone;
  }


  public String getrState() {
    return rState;
  }

  public void setrState(String rState) {
    this.rState = rState;
  }


  public Timestamp getrTime() {
    return rTime;
  }

  public void setrTime(Timestamp rTime) {
    this.rTime = rTime;
  }


  public String getPastMedicalHistory() {
    return pastMedicalHistory;
  }

  public void setPastMedicalHistory(String pastMedicalHistory) {
    this.pastMedicalHistory = pastMedicalHistory;
  }


  public String getAllergyHistory() {
    return allergyHistory;
  }

  public void setAllergyHistory(String allergyHistory) {
    this.allergyHistory = allergyHistory;
  }


  public String getrDescribe() {
    return rDescribe;
  }

  public void setrDescribe(String rDescribe) {
    this.rDescribe = rDescribe;
  }


  @Override
  public String toString() {
    return "Rescue{" +
            ", rId=" + rId +
            ", tId=" + tId +
            ", uId=" + uId +
            ", rName='" + rName + '\'' +
            ", rAge=" + rAge +
            ", rGender=" + rGender +
            ", rAddress='" + rAddress + '\'' +
            ", rTelephone=" + rTelephone +
            ", rState='" + rState + '\'' +
            ", rTime=" + rTime +
            ", pastMedicalHistory='" + pastMedicalHistory + '\'' +
            ", allergyHistory='" + allergyHistory + '\'' +
            ", rDescribe='" + rDescribe + '\'' +
            '}';
  }
}
