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

    List<Rescue> getRescueListByUId(Integer uId);
}
