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

    /**
     * 新增文章
     * @param essay
     * @return
     */
    boolean saveEssay(Essay essay);

    /**
     * 根据id文本判断是否已存在文章
     * @param eId
     * @return
     */
    boolean checkEssayByEId(Integer eId);

    /**
     * 根据id文本删除文章
     * @param eId
     * @return
     */
    boolean removeEssayByEId(Integer eId);

    /**
     * 根据id修改文章
     * @param essay
     * @return
     */
    boolean modifyEssayByEId(Essay essay);
}
