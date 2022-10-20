package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.mapper.CommodityMapper;
import team.ghjly.emergencyrescue.service.CommodityService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public List get() {
        return commodityMapper.get();
    }
}
