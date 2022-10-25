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

    /**
     * 根据过滤商品信息分页获取商品列表
     * @param pageSize
     * @param pageNum
     * @param commodity
     * @return
     */
    List<Commodity> getCommodityListPageByCommodity(int pageSize, Integer pageNum, Commodity commodity);
}
