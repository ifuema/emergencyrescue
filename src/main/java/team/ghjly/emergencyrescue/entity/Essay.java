package team.ghjly.emergencyrescue.entity;


public class Essay {

  private Integer eId;
  private String eTitle;
  private String eImg;
  private String eBody;
  private Integer eType;


  public Integer getEId() {
    return eId;
  }

  public void setEId(Integer eId) {
    this.eId = eId;
  }


  public String getETitle() {
    return eTitle;
  }

  public void setETitle(String eTitle) {
    this.eTitle = eTitle;
  }


  public String getEImg() {
    return eImg;
  }

  public void setEImg(String eImg) {
    this.eImg = eImg;
  }


  public String getEBody() {
    return eBody;
  }

  public void setEBody(String eBody) {
    this.eBody = eBody;
  }


  public Integer getEType() {
    return eType;
  }

  public void setEType(Integer eType) {
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
