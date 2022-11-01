package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.Change;
import team.ghjly.emergencyrescue.entity.groups.Register;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Team {
  //救援队编号
  private Integer tId;
  //救援队名称
  @NotBlank(message = "名称不能为空！", groups = {Register.class})
  @Size(max = 32, message = "名称过长！", groups = {Register.class})
  private String tName;
  //救援队人数
  @NotNull(message = "人数不能为空！", groups = {Register.class})
  private Integer tNum;
  //救援队简介
  @NotBlank(message = "简介不能为空！", groups = {Register.class})
  private String tIntroduce;
  //救援队业务范围
  @NotBlank(message = "业务范围不能为空！", groups = {Register.class})
  @Size(max = 255, message = "业务范围过长！", groups = {Register.class})
  private String tScope;
  //救援队图片
  @NotBlank(message = "图片不能为空！", groups = {Register.class})
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
            ", tNum=" + tNum +
            ", tIntroduce='" + tIntroduce + '\'' +
            ", tScope='" + tScope + '\'' +
            ", tImg='" + tImg + '\'' +
            '}';
  }
}
