package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.Register;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Essay {
  //文章编号
  private Integer eId;
  //文章标题
  @NotBlank(message = "标题不能为空！", groups = {Register.class})
  @Size(max = 32, message = "标题过长！", groups = {Register.class})
  private String eTitle;
  //文章图片
  @NotBlank(message = "图片不能为空！", groups = {Register.class})
  private String eImg;
  //文章内容
  @NotBlank(message = "内容不能为空！", groups = {Register.class})
  private String eBody;
  //文章类型
  @NotNull(message = "类型不能为空！", groups = {Register.class})
  private Integer eType;


  public Integer geteId() {
    return eId;
  }

  public void seteId(Integer eId) {
    this.eId = eId;
  }


  public String geteTitle() {
    return eTitle;
  }

  public void seteTitle(String eTitle) {
    this.eTitle = eTitle;
  }


  public String geteImg() {
    return eImg;
  }

  public void seteImg(String eImg) {
    this.eImg = eImg;
  }


  public String geteBody() {
    return eBody;
  }

  public void seteBody(String eBody) {
    this.eBody = eBody;
  }


  public Integer geteType() {
    return eType;
  }

  public void seteType(Integer eType) {
    this.eType = eType;
  }


  @Override
  public String toString() {
    return "Essay{" +
            "eId=" + eId +
            ", eTitle='" + eTitle + '\'' +
            ", eImg='" + eImg + '\'' +
            ", eBody='" + eBody + '\'' +
            ", eType=" + eType +
            '}';
  }
}
