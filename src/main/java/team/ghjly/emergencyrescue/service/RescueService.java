package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Rescue;

import java.util.List;

public interface RescueService {
    /**
     * 新增救援
     * @param rescue
     * @return
     */
    boolean saveRescue(Rescue rescue);

    /**
     * 根据用户id文本获取救援列表
     * @param uId
     * @return
     */
    List<Rescue> getRescueListByUId(Integer uId);

    List<Rescue> getRescueListPageByRescue(int pageSize, Integer pageNum, Rescue rescue);
}
