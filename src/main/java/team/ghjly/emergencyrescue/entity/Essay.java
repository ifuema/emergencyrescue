package team.ghjly.emergencyrescue.entity;

public class Essay {
  //文章编号
  private Integer eId;
  //文章标题
  private String eTitle;
  //文章图片
  private String eImg;
  //文章内容
  private String eBody;
  //文章类型
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
