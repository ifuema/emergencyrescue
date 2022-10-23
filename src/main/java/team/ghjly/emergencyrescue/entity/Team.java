package team.ghjly.emergencyrescue.entity;

public class Team {
  //救援队编号
  private Integer tId;
  //救援队名称
  private String tName;
  //救援队账号
  private Integer tAccount;
  //救援队密码
  private String tPassword;
  //救援队人数
  private Integer tNum;
  //救援队简介
  private String tIntroduce;
  //救援队业务范围
  private String tScope;
  //救援队图片
  private String tImg;


  public Integer gettId() {
    return tId;
  }

  public void settId(Integer tId) {
    this.tId = tId;
  }


  public String gettName() {
    return tName;
  }

  public void settName(String tName) {
    this.tName = tName;
  }


  public Integer gettAccount() {
    return tAccount;
  }

  public void settAccount(Integer tAccount) {
    this.tAccount = tAccount;
  }


  public String gettPassword() {
    return tPassword;
  }

  public void settPassword(String tPassword) {
    this.tPassword = tPassword;
  }


  public Integer gettNum() {
    return tNum;
  }

  public void settNum(Integer tNum) {
    this.tNum = tNum;
  }


  public String gettIntroduce() {
    return tIntroduce;
  }

  public void settIntroduce(String tIntroduce) {
    this.tIntroduce = tIntroduce;
  }


  public String gettScope() {
    return tScope;
  }

  public void settScope(String tScope) {
    this.tScope = tScope;
  }


  public String gettImg() {
    return tImg;
  }

  public void settImg(String tImg) {
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
