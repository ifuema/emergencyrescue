package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Essay;

import java.util.List;

public interface EssayService {
    /**
     * 根据过滤文章信息分页获取文章列表
     * @param pageSize
     * @param pageNum
     * @param essay
     * @return
     */
    List<Essay> getEssayListPageByEssay(Integer pageSize, Integer pageNum, Essay essay);

    /**
     * 根据id文本获取文章信息
     * @param eId
     * @return
     */
    Essay getEssayByEId(Integer eId);

    boolean saveEssay(Essay essay);

    boolean checkEssayByEId(Integer eId);

    boolean removeEssayByEId(Integer eId);

    boolean modifyEssayByEId(Essay essay);
}
