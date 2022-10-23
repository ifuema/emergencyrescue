package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.Login;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Admin {
  //管理员编号
  private Integer aId;
  //管理员账号
  @NotNull(message = "账号不能为空！", groups = {Login.class})
  private Integer aAccount;
  //管理员密码
  @NotBlank(message = "密码不能为空！", groups = {Login.class})
  private String aPassword;


  public Integer getaId() {
    return aId;
  }

  public void setaId(Integer aId) {
    this.aId = aId;
  }


  public Integer getaAccount() {
    return aAccount;
  }

  public void setaAccount(Integer aAccount) {
    this.aAccount = aAccount;
  }


  public String getaPassword() {
    return aPassword;
  }

  public void setaPassword(String aPassword) {
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
