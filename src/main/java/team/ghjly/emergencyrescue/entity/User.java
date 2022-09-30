package team.ghjly.emergencyrescue.entity;


import team.ghjly.emergencyrescue.entity.groups.Login;

import javax.validation.constraints.*;

public class User {
  //用户编号
  private Integer uId;
  //用户昵称
  private String uName;
  //用户账号
  @NotNull(message = "账号不能为空！", groups = {Login.class})
  @PositiveOrZero(message = "账号格式不正确！", groups = {Login.class})
  private Integer uAccount;
  //用户密码
  @NotBlank(message = "密码不能为空！", groups = {Login.class})
  private String uPassword;
  //用户电话
  private Integer uTelephone;
  //用户邮箱
  private String uEmail;


  public Integer getUId() {
    return uId;
  }

  public void setUId(Integer uId) {
    this.uId = uId;
  }


  public String getUName() {
    return uName;
  }

  public void setUName(String uName) {
    this.uName = uName;
  }


  public Integer getUAccount() {
    return uAccount;
  }

  public void setUAccount(Integer uAccount) {
    this.uAccount = uAccount;
  }


  public String getUPassword() {
    return uPassword;
  }

  public void setUPassword(String uPassword) {
    this.uPassword = uPassword;
  }


  public Integer getUTelephone() {
    return uTelephone;
  }

  public void setUTelephone(Integer uTelephone) {
    this.uTelephone = uTelephone;
  }


  public String getUEmail() {
    return uEmail;
  }

  public void setUEmail(String uEmail) {
    this.uEmail = uEmail;
  }

}
