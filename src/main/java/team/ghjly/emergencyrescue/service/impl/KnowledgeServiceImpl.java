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
import java.util.Iterator;
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

    /**
     * 根据id文本判断是否已存在小知识
     * @param kId
     * @return
     */
    @Override
    public boolean checkKonwledgeByKId(Integer kId) {
        Integer dataKId = knowledgeMapper.selectKIdByKId(kId);
        if (dataKId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据id删除小知识
     * @param kId
     * @return
     */
    @Override
    public boolean removeKonwledgeByKId(Integer kId) {
        if (knowledgeMapper.deleteKnowledgeByKId(kId) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 新增小知识
     * @param knowledge
     * @return
     */
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

    /**
     * 根据id修改小知识
     * @param knowledge
     * @return
     */
    @Override
    @Transactional
    public boolean modifyKnowledgeByKId(Knowledge knowledge) {
        if (knowledgeMapper.updateKnowledgeByKId(knowledge) >= 1) {
            List<KnowledgeCommodity> dataKnowledgeCommodityList = knowledgeCommodityService.getKnowledgeCommodityListByKId(knowledge.getkId());
            if (!knowledge.getCommodityList().isEmpty()) {
                KnowledgeCommodity knowledgeCommodity = new KnowledgeCommodity();
                knowledgeCommodity.setkId(knowledge.getkId());
                boolean state;
                for (Commodity commodity : knowledge.getCommodityList()) {
                    state = false;
                    Iterator<KnowledgeCommodity> dataKnowledgeCommodityiterator = dataKnowledgeCommodityList.iterator();
                    while (dataKnowledgeCommodityiterator.hasNext()) {
                        KnowledgeCommodity dataKnowledgeCommodity = dataKnowledgeCommodityiterator.next();
                        if (commodity.getcId().equals(dataKnowledgeCommodity.getcId())) {
                            dataKnowledgeCommodityiterator.remove();
                            state = true;
                            break;
                        }
                    }
                    if (!state) {
                        knowledgeCommodity.setcId(commodity.getcId());
                        if (!knowledgeCommodityService.saveKnowledgeCommodity(knowledgeCommodity)) {
                            return false;
                        }
                    }
                }
            }
            for (KnowledgeCommodity dataKnowledgeCommodity : dataKnowledgeCommodityList) {
                if (!knowledgeCommodityService.removeKnowledgeCommodityByCIdAndKId(dataKnowledgeCommodity)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
