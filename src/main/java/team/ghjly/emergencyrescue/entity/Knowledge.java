package team.ghjly.emergencyrescue.entity;

import java.util.List;

public class Knowledge {
  //知识编号
  private Integer kId;
  //知识标题
  private String kTitle;
  //知识内容
  private String kBody;
  //关联商品列表
  private List<Commodity> commodityList;


  public Integer getkId() {
    return kId;
  }

  public void setkId(Integer kId) {
    this.kId = kId;
  }


  public String getkTitle() {
    return kTitle;
  }

  public void setkTitle(String kTitle) {
    this.kTitle = kTitle;
  }


  public String getkBody() {
    return kBody;
  }

  public void setkBody(String kBody) {
    this.kBody = kBody;
  }


  public List<Commodity> getCommodityList() {
    return commodityList;
  }

  public void setCommodityList(List<Commodity> commodityList) {
    this.commodityList = commodityList;
  }


  @Override
  public String toString() {
    return "Knowledge{" +
            "kId=" + kId +
            ", kTitle='" + kTitle + '\'' +
            ", kBody='" + kBody + '\'' +
            ", commodityList=" + commodityList +
            '}';
  }
}
