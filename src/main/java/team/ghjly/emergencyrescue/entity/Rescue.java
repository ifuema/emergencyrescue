package team.ghjly.emergencyrescue.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import team.ghjly.emergencyrescue.entity.groups.Login;
import team.ghjly.emergencyrescue.entity.groups.Regist;

import javax.annotation.Resource;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Rescue {
  private Integer rId;
  private Integer tId;
  private Integer uId;
  @NotBlank(message = "姓名不能为空！", groups = {Regist.class})
  @Size(max = 8, message = "姓名过长！", groups = {Regist.class})
  private String rName;
  @NotNull(message = "年龄不能为空！", groups = {Regist.class})
  @PositiveOrZero(message = "年龄格式不正确！", groups = {Regist.class})
  private Integer rAge;
  @NotNull(message = "性别不能为空！", groups = {Regist.class})
  @Pattern(regexp = "^[男女]$", message = "性别只能为男或女！", groups = {Regist.class})
  private String rGender;
  @NotBlank(message = "地址不能为空！", groups = {Regist.class})
  @Size(max = 255, message = "地址过长！", groups = {Regist.class})
  private String rAddress;
  @NotNull(message = "电话不能为空！", groups = {Regist.class})
  @PositiveOrZero(message = "电话格式不正确！", groups = {Regist.class})
  @DecimalMax(value = "99999999999", message = "电话号码过长！", groups = {Regist.class})
  private Long rTelephone;
  private String rState;
  private LocalDateTime rTime;
  @Size(max = 255, message = "既往病史过长！", groups = {Regist.class})
  private String pastMedicalHistory;
  @Size(max = 255, message = "过敏史过长！", groups = {Regist.class})
  private String allergyHistory;
  @NotNull(message = "描述不能为空！", groups = {Regist.class})
  private String rDescribe;


  public Integer getRId() {
    return rId;
  }

  public void setRId(Integer rId) {
    this.rId = rId;
  }


  public Integer getTId() {
    return tId;
  }

  public void setTId(Integer tId) {
    this.tId = tId;
  }


  public Integer getUId() {
    return uId;
  }

  public void setUId(Integer uId) {
    this.uId = uId;
  }


  public String getRName() {
    return rName;
  }

  public void setRName(String rName) {
    this.rName = rName;
  }


  public Integer getRAge() {
    return rAge;
  }

  public void setRAge(Integer rAge) {
    this.rAge = rAge;
  }


  public String getRGender() {
    return rGender;
  }

  public void setRGender(String rGender) {
    this.rGender = rGender;
  }


  public String getRAddress() {
    return rAddress;
  }

  public void setRAddress(String rAddress) {
    this.rAddress = rAddress;
  }


  public Long getRTelephone() {
    return rTelephone;
  }

  public void setRTelephone(Long rTelephone) {
    this.rTelephone = rTelephone;
  }


  public String getRState() {
    return rState;
  }

  public void setRState(String rState) {
    this.rState = rState;
  }


  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public LocalDateTime getRTime() {
    return rTime;
  }

  public void setRTime(LocalDateTime rTime) {
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


  public String getRDescribe() {
    return rDescribe;
  }

  public void setRDescribe(String rDescribe) {
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
