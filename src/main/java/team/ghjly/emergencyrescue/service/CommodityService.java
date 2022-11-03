package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 根据kid文本获取商品列表信息
     * @param kId
     * @return
     */
    List<Commodity> getCommodityListByKnowledgeKId(Integer kId);

    /**
     * 根据过滤商品信息分页获取商品列表
     * @param pageSize
     * @param pageNum
     * @param commodity
     * @return
     */
    List<Commodity> getCommodityListPageByCommodity(int pageSize, Integer pageNum, Commodity commodity);

    /**
     * 根据商品名称文本获取商品id
     * @param cName
     * @return
     */
    Integer getCIdByCName(String cName);

    /**
     * 根据商品名文本判断是否已存在商品
     * @param cName
     * @return
     */
    boolean checkCommodityByCName(String cName);

    /**
     * 新增商品
     * @param commodity
     * @return
     */
    boolean saveCommodity(Commodity commodity);

    /**
     * 根据id文本判断是否已存在商品
     * @param cId
     * @return
     */
    boolean checkCommodityByCId(Integer cId);

    /**
     * 根据id文本删除商品
     * @param cId
     * @return
     */
    boolean removeCommodityByCId(Integer cId);

    /**
     * 根据id文本获取商品信息
     * @param cId
     * @return
     */
    Commodity getCommodityByCId(Integer cId);

    /**
     * 根据id修改商品
     * @param commodity
     * @return
     */
    boolean modifyCommodityByCId(Commodity commodity);

    /**
     * 根据id文本获取商品名
     * @param cId
     * @return
     */
    String getCNameByCId(Integer cId);
}
