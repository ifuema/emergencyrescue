package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.mapper.RescueMapper;
import team.ghjly.emergencyrescue.service.RescueService;

import javax.annotation.Resource;

@Service
public class RescueServiceImpl implements RescueService {
    @Resource
    RescueMapper rescueMapper;

    /**
     * 新增救援
     * @param rescue
     * @return
     */
    @Override
    public boolean saveRescue(Rescue rescue) {
        if (rescueMapper.insertRescue(rescue) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
