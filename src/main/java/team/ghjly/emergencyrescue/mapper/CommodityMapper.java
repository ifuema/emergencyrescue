package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.Commodity;
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

    /**
     * 根据商品名称文本查询商品id
     * @param cName
     * @return
     */
    @Select("SELECT c_id FROM commodity WHERE c_name = #{cName}")
    Integer selectCIdByCName(String cName);

    /**
     * 插入一条商品信息
     * @param commodity
     * @return
     */
    @Insert("INSERT INTO commodity (c_img, c_price, c_name, c_introduce, c_url) " +
            "VALUES (#{cImg}, #{cPrice}, #{cName}, #{cIntroduce}, #{cUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "cId", keyColumn = "c_id")
    Integer insertCommodity(Commodity commodity);

    /**
     * 根据id文本查询商品id
     * @param cId
     * @return
     */
    @Select("SELECT c_id FROM commodity WHERE c_id = #{cId}")
    Integer selectCIdByCId(Integer cId);

    /**
     * 根据id文本删除商品
     * @param cId
     * @return
     */
    @Delete("DELETE FROM commodity WHERE c_id = #{cId}")
    Integer deleteCommodityByCId(Integer cId);

    /**
     * 根据id文本查询商品信息
     * @param cId
     * @return
     */
    @Select("SELECT * FROM commodity WHERE c_id = #{cId}")
    Commodity selectCommodityByCId(Integer cId);

    /**
     * 根据id文本修改订单
     * @param commodity
     * @return
     */
    @Update("UPDATE commodity SET c_name = #{cName}, c_url = #{cUrl}, c_introduce = #{cIntroduce}, " +
            "c_price = #{cPrice}, c_img = #{cImg} WHERE c_id = #{cId}")
    Integer updateCommodityByCId(Commodity commodity);

    /**
     * 根据id文本查询商品名称
     * @param cId
     * @return
     */
    @Select("SELECT c_name FROM commodity WHERE c_id = #{cId}")
    String selectCNameByCId(Integer cId);
}
