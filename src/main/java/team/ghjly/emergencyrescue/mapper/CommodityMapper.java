package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.Commodity;
import team.ghjly.emergencyrescue.entity.Order;
import team.ghjly.emergencyrescue.mapper.sql.CommodityMapperSqlProvider;

import java.util.List;

@Mapper
public interface CommodityMapper {
    /**
     * 根据kid文本查询商品列表信息
     * @param kId
     * @return
     */
    @Select("SELECT commodity.* FROM commodity JOIN knowledge_commodity " +
            "ON commodity.c_id = knowledge_commodity.c_id JOIN knowledge " +
            "ON knowledge.k_id = knowledge_commodity.k_id WHERE knowledge.k_id = #{kId}")
    List<Commodity> selectCommodityListByKnowledgeKId(Integer kId);

    /**
     * 根据过滤商品信息分页查询商品列表
     * @param pageSize
     * @param startIndex
     * @param commodity
     * @return
     */
    @SelectProvider(type = CommodityMapperSqlProvider.class, method = "selectCommodityListPageByCommoditySql")
    List<Commodity> selectCommodityListPageByCommodity(int pageSize, Integer startIndex, Commodity commodity);

    @Select("SELECT c_id FROM commodity WHERE c_name = #{cName}")
    Integer selectCIdByCName(String cName);
}
