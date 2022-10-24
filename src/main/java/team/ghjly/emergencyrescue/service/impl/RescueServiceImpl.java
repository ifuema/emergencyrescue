package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.mapper.RescueMapper;
import team.ghjly.emergencyrescue.service.RescueService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

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
        rescue.setrTime(new Timestamp(System.currentTimeMillis()));
        rescue.setrState("已申请");
        if (rescueMapper.insertRescue(rescue) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Rescue> getRescueListByUId(Integer uId) {
        return rescueMapper.selectRescueListByUId(uId);
    }
}