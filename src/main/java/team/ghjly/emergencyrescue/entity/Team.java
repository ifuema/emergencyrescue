package team.ghjly.emergencyrescue.entity;


public class Team {

  private Integer tId;
  private String tName;
  private Integer tAccount;
  private String tPassword;
  private Integer tNum;
  private String tIntroduce;
  private String tScope;
  private String tImg;


  public Integer getTId() {
    return tId;
  }

  public void setTId(Integer tId) {
    this.tId = tId;
  }


  public String getTName() {
    return tName;
  }

  public void setTName(String tName) {
    this.tName = tName;
  }


  public Integer getTAccount() {
    return tAccount;
  }

  public void setTAccount(Integer tAccount) {
    this.tAccount = tAccount;
  }


  public String getTPassword() {
    return tPassword;
  }

  public void setTPassword(String tPassword) {
    this.tPassword = tPassword;
  }


  public Integer getTNum() {
    return tNum;
  }

  public void setTNum(Integer tNum) {
    this.tNum = tNum;
  }


  public String getTIntroduce() {
    return tIntroduce;
  }

  public void setTIntroduce(String tIntroduce) {
    this.tIntroduce = tIntroduce;
  }


  public String getTScope() {
    return tScope;
  }

  public void setTScope(String tScope) {
    this.tScope = tScope;
  }


  public String getTImg() {
    return tImg;
  }

  public void setTImg(String tImg) {
    this.tImg = tImg;
  }

  @Override
  public String toString() {
    return "Team{" +
            "tId=" + tId +
            ", tName='" + tName + '\'' +
            ", tAccount=" + tAccount +
            ", tPassword='" + tPassword + '\'' +
            ", tNum=" + tNum +
            ", tIntroduce='" + tIntroduce + '\'' +
            ", tScope='" + tScope + '\'' +
            ", tImg='" + tImg + '\'' +
            '}';
  }
}
