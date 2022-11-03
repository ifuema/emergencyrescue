package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.KnowledgeCommodity;
import team.ghjly.emergencyrescue.mapper.KnowledgeCommodityMapper;
import team.ghjly.emergencyrescue.service.KnowledgeCommodityService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KnowledgeCommodityServiceImpl implements KnowledgeCommodityService {
    @Resource
    KnowledgeCommodityMapper knowledgeCommodityMapper;

    /**
     * 新增小知识-商品关联信息
     * @param knowledgeCommodity
     * @return
     */
    @Override
    public boolean saveKnowledgeCommodity(KnowledgeCommodity knowledgeCommodity) {
        if (knowledgeCommodityMapper.insertKnowledgeCommodity(knowledgeCommodity) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id获取小知识-商品关联信息列表
     * @param kId
     * @return
     */
    @Override
    public List<KnowledgeCommodity> getKnowledgeCommodityListByKId(Integer kId) {
        return knowledgeCommodityMapper.selectKnowledgeCommodityListByKId(kId);
    }

    /**
     * 根据商品id和小知识id文本删除小知识-商品关联信息
     * @param dataKnowledgeCommodity
     * @return
     */
    @Override
    public boolean removeKnowledgeCommodityByCIdAndKId(KnowledgeCommodity dataKnowledgeCommodity) {
        if (knowledgeCommodityMapper.deleteKnowledgeCommodityByCIdAndKId(dataKnowledgeCommodity) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
