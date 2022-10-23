package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import team.ghjly.emergencyrescue.entity.Commodity;
import team.ghjly.emergencyrescue.mapper.sql.CommodityMapperSqlProvider;
import team.ghjly.emergencyrescue.mapper.sql.TeamMapperSqlProvider;

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
    List<Commodity> selectCommodityListByKId(Integer kId);

    @SelectProvider(type = CommodityMapperSqlProvider.class, method = "selectCommodityListPageByCommoditySql")
    List<Commodity> selectCommodityListPageByCommodity(int pageSize, Integer startIndex, Commodity commodity);
}
