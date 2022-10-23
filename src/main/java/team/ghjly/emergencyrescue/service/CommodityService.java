package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 根据kid文本获取商品列表信息
     * @param kId
     * @return
     */
    List<Commodity> getCommodityListByKId(Integer kId);

    List<Commodity> getCommodityListPageByCommodity(int pageSize, Integer pageNum, Commodity commodity);
}
