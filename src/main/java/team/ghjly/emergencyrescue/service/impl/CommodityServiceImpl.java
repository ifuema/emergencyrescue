package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.Commodity;
import team.ghjly.emergencyrescue.mapper.CommodityMapper;
import team.ghjly.emergencyrescue.service.CommodityService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    /**
     * 根据kid文本获取商品列表信息
     * @param kId
     * @return
     */
    @Override
    public List<Commodity> getCommodityListByKId(Integer kId) {
        return commodityMapper.selectCommodityListByKId(kId);
    }

    @Override
    public List<Commodity> getCommodityListPageByCommodity(int pageSize, Integer pageNum, Commodity commodity) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return commodityMapper.selectCommodityListPageByCommodity(pageSize, startIndex, commodity);
    }
}
