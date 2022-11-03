package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.KnowledgeCommodity;

import java.util.List;

@Mapper
public interface KnowledgeCommodityMapper {
    /**
     * 插入一条小知识-商品关联信息
     * @param knowledgeCommodity
     * @return
     */
    @Insert("INSERT INTO knowledge_commodity (k_id, c_id) VALUES (#{kId}, #{cId})")
    Integer insertKnowledgeCommodity(KnowledgeCommodity knowledgeCommodity);

    /**
     * 根据小知识id文本查询小知识-商品关联信息
     * @param kId
     * @return
     */
    @Select("SELECT * FROM knowledge_commodity WHERE k_id = #{kId}")
    List<KnowledgeCommodity> selectKnowledgeCommodityListByKId(Integer kId);

    /**
     * 根据小知识id和商品id文本删除商品
     * @param dataKnowledgeCommodity
     * @return
     */
    @Delete("DELETE FROM knowledge_commodity WHERE c_id = #{cId} AND k_id = #{kId}")
    Integer deleteKnowledgeCommodityByCIdAndKId(KnowledgeCommodity dataKnowledgeCommodity);
}
