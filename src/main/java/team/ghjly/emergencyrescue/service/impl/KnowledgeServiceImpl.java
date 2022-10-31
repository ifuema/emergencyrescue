package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.ghjly.emergencyrescue.entity.Commodity;
import team.ghjly.emergencyrescue.entity.Knowledge;
import team.ghjly.emergencyrescue.entity.KnowledgeCommodity;
import team.ghjly.emergencyrescue.mapper.KnowledgeMapper;
import team.ghjly.emergencyrescue.service.CommodityService;
import team.ghjly.emergencyrescue.service.KnowledgeCommodityService;
import team.ghjly.emergencyrescue.service.KnowledgeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Resource
    private KnowledgeMapper knowledgeMapper;
    @Resource
    private CommodityService commodityService;
    @Resource
    private KnowledgeCommodityService knowledgeCommodityService;

    /**
     * 根据过滤小知识信息分页获取小知识列表
     * @param pageSize
     * @param pageNum
     * @param knowledge
     * @return
     */
    @Override
    public List<Knowledge> getKnowledgeListPageByKnowledge(int pageSize, Integer pageNum, Knowledge knowledge) {
        Integer startIndex = (pageNum - 1) * pageSize;
        List<Knowledge> dataKnowledgeList = knowledgeMapper.selectKnowledgeListPageByKnowledge(pageSize, startIndex, knowledge);
        for (Knowledge dataknowledge : dataKnowledgeList) {
            dataknowledge.setCommodityList(commodityService.getCommodityListByKnowledgeKId(dataknowledge.getkId()));
        }
        return dataKnowledgeList;
    }

    @Override
    public boolean checkKonwledgeByKId(Integer kId) {
        Integer dataKId = knowledgeMapper.selectKIdByKId(kId);
        if (dataKId == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeKonwledgeByKId(Integer kId) {
        if (knowledgeMapper.deleteKnowledgeByKId(kId) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean saveKnowledge(Knowledge knowledge) {
        if (knowledgeMapper.insertKnowledge(knowledge) >= 1) {
            if (!knowledge.getCommodityList().isEmpty()) {
                KnowledgeCommodity knowledgeCommodity = new KnowledgeCommodity();
                knowledgeCommodity.setkId(knowledge.getkId());
                for (Commodity commodity : knowledge.getCommodityList()) {
                    knowledgeCommodity.setcId(commodity.getcId());
                    if (!knowledgeCommodityService.saveKnowledgeCommodity(knowledgeCommodity)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
