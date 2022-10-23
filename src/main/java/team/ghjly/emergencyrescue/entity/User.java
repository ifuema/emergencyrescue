package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.Login;
import team.ghjly.emergencyrescue.entity.groups.Regist;

import javax.validation.constraints.*;

public class User {
  //用户编号
  private Integer uId;
  //用户昵称
  @NotBlank(message = "昵称不能为空！", groups = {Regist.class})
  @Size(max = 8, message = "昵称过长！", groups = {Regist.class})
  private String uName;
  //用户账号
  @NotNull(message = "账号不能为空！", groups = {Login.class, Regist.class})
  @PositiveOrZero(message = "账号格式不正确！", groups = {Regist.class})
  private Integer uAccount;
  //用户密码
  @NotBlank(message = "密码不能为空！", groups = {Login.class, Regist.class})
  private String uPassword;
  //用户电话
  @NotNull(message = "电话不能为空！", groups = {Regist.class})
  @PositiveOrZero(message = "电话格式不正确！", groups = {Regist.class})
  @DecimalMax(value = "99999999999", message = "电话号码过长！", groups = {Regist.class})
  private Long uTelephone;
  //用户邮箱
  @Email(message = "邮箱格式不正确！", groups = {Regist.class})
  private String uEmail;


  public Integer getuId() {
    return uId;
  }

  public void setuId(Integer uId) {
    this.uId = uId;
  }


  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }


  public Integer getuAccount() {
    return uAccount;
  }

  public void setuAccount(Integer uAccount) {
    this.uAccount = uAccount;
  }


  public String getuPassword() {
    return uPassword;
  }

  public void setuPassword(String uPassword) {
    this.uPassword = uPassword;
  }


  public Long getuTelephone() {
    return uTelephone;
  }

  public void setuTelephone(Long uTelephone) {
    this.uTelephone = uTelephone;
  }


  public String getuEmail() {
    return uEmail;
  }

  public void setuEmail(String uEmail) {
    this.uEmail = uEmail;
  }


  @Override
  public String toString() {
    return "User{" +
            "uId=" + uId +
            ", uName='" + uName + '\'' +
            ", uAccount=" + uAccount +
            ", uPassword='" + uPassword + '\'' +
            ", uTelephone=" + uTelephone +
            ", uEmail='" + uEmail + '\'' +
            '}';
  }
}
