package team.ghjly.emergencyrescue.entity;

import team.ghjly.emergencyrescue.entity.groups.AdvancedRegister;
import team.ghjly.emergencyrescue.entity.groups.Register;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Knowledge {
  //知识编号
  private Integer kId;
  //知识标题
  @NotBlank(message = "标题不能为空！", groups = {AdvancedRegister.class})
  @Size(max = 32, message = "标题过长！", groups = {AdvancedRegister.class})
  private String kTitle;
  //知识内容
  @NotBlank(message = "内容不能为空！", groups = {AdvancedRegister.class})
  private String kBody;
  //关联商品列表
  @Valid
  @NotNull(message = "商品列表应为数组！", groups = {AdvancedRegister.class})
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
