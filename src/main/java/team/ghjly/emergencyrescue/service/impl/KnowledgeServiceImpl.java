package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Knowledge;
import team.ghjly.emergencyrescue.mapper.KnowledgeMapper;
import team.ghjly.emergencyrescue.service.CommodityService;
import team.ghjly.emergencyrescue.service.KnowledgeService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Resource
    private KnowledgeMapper knowledgeMapper;
    @Resource
    private CommodityService commodityService;

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
            dataknowledge.setCommodityList(commodityService.getCommodityListByKId(dataknowledge.getkId()));
        }
        return dataKnowledgeList;
    }
}
