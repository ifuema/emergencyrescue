package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.KnowledgeCommodity;

import java.util.List;

public interface KnowledgeCommodityService {
    /**
     * 新增小知识-商品关联信息
     * @param knowledgeCommodity
     * @return
     */
    boolean saveKnowledgeCommodity(KnowledgeCommodity knowledgeCommodity);

    /**
     * 根据id获取小知识-商品关联信息列表
     * @param kId
     * @return
     */
    List<KnowledgeCommodity> getKnowledgeCommodityListByKId(Integer kId);

    /**
     * 根据商品id和小知识id文本删除小知识-商品关联信息
     * @param dataKnowledgeCommodity
     * @return
     */
    boolean removeKnowledgeCommodityByCIdAndKId(KnowledgeCommodity dataKnowledgeCommodity);
}
