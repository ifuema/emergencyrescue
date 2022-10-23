package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Rescue;

public interface RescueService {
    /**
     * 新增救援
     * @param rescue
     * @return
     */
    boolean saveRescue(Rescue rescue);
}
