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

    /**
     * 根据用户id文本获取救援列表
     * @param uId
     * @return
     */
    @Override
    public List<Rescue> getRescueListByUId(Integer uId) {
        return rescueMapper.selectRescueListByUId(uId);
    }

    /**
     * 根据过滤救援信息分页获取救援列表
     * @param pageSize
     * @param pageNum
     * @param rescue
     * @return
     */
    @Override
    public List<Rescue> getRescueListPageByRescue(int pageSize, Integer pageNum, Rescue rescue) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return rescueMapper.selectRescueListPageByRescue(pageSize, startIndex, rescue);
    }
}
