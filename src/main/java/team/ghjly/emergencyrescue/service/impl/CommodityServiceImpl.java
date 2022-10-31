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
    public List<Commodity> getCommodityListByKnowledgeKId(Integer kId) {
        return commodityMapper.selectCommodityListByKnowledgeKId(kId);
    }

    /**
     * 根据过滤商品信息分页获取商品列表
     * @param pageSize
     * @param pageNum
     * @param commodity
     * @return
     */
    @Override
    public List<Commodity> getCommodityListPageByCommodity(int pageSize, Integer pageNum, Commodity commodity) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return commodityMapper.selectCommodityListPageByCommodity(pageSize, startIndex, commodity);
    }

    /**
     * 根据商品名称文本获取商品id
     * @param cName
     * @return
     */
    @Override
    public Integer getCIdByCName(String cName) {
        return commodityMapper.selectCIdByCName(cName);
    }

    @Override
    public boolean checkCommodityByCName(String cName) {
        Integer dataCId = commodityMapper.selectCIdByCName(cName);
        if (dataCId == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean saveCommodity(Commodity commodity) {
        if (commodityMapper.insertCommodity(commodity) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkCommodityByCId(Integer cId) {
        Integer dataCId = commodityMapper.selectCIdByCId(cId);
        if (dataCId == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeCommodityByCId(Integer cId) {
        if (commodityMapper.deleteCommodityByCId(cId) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Commodity getCommodityByCId(Integer cId) {
        return commodityMapper.selectCommodityByCId(cId);
    }
}
