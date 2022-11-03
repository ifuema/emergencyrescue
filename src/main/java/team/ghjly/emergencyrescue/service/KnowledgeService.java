package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {
    /**
     * 根据过滤小知识信息分页获取小知识列表
     * @param pageSize
     * @param pageNum
     * @param knowledge
     * @return
     */
    List<Knowledge> getKnowledgeListPageByKnowledge(int pageSize, Integer pageNum, Knowledge knowledge);

    /**
     * 根据id文本判断是否已存在小知识
     * @param kId
     * @return
     */
    boolean checkKonwledgeByKId(Integer kId);

    /**
     * 根据id删除小知识
     * @param kId
     * @return
     */
    boolean removeKonwledgeByKId(Integer kId);

    /**
     * 新增小知识
     * @param knowledge
     * @return
     */
    boolean saveKnowledge(Knowledge knowledge);

    /**
     * 根据id修改小知识
     * @param knowledge
     * @return
     */
    boolean modifyKnowledgeByKId(Knowledge knowledge);
}
