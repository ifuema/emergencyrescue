package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.Login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Admin {
  //管理员编号
  private Integer aId;
  //管理员账号
  @NotNull(message = "账号不能为空！", groups = {Login.class})
  @PositiveOrZero(message = "账号格式不正确！", groups = {Login.class})
  private Integer aAccount;
  //管理员密码
  @NotBlank(message = "密码不能为空！", groups = {Login.class})
  private String aPassword;


  public Integer getAId() {
    return aId;
  }

  public void setAId(Integer aId) {
    this.aId = aId;
  }


  public Integer getAAccount() {
    return aAccount;
  }

  public void setAAccount(Integer aAccount) {
    this.aAccount = aAccount;
  }


  public String getAPassword() {
    return aPassword;
  }

  public void setAPassword(String aPassword) {
    this.aPassword = aPassword;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "aId=" + aId +
            ", aAccount=" + aAccount +
            ", aPassword='" + aPassword + '\'' +
            '}';
  }
}
