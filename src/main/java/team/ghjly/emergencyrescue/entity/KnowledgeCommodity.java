package team.ghjly.emergencyrescue.entity;

public class KnowledgeCommodity {
  private Integer kId;
  private Integer cId;


  public Integer getkId() {
    return kId;
  }

  public void setkId(Integer kId) {
    this.kId = kId;
  }


  public Integer getcId() {
    return cId;
  }

  public void setcId(Integer cId) {
    this.cId = cId;
  }


  @Override
  public String toString() {
    return "KnowledgeCommodity{" +
            "kId=" + kId +
            ", cId=" + cId +
            '}';
  }
}
