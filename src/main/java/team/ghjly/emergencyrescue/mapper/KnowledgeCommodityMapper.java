package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import team.ghjly.emergencyrescue.entity.KnowledgeCommodity;

@Mapper
public interface KnowledgeCommodityMapper {
    @Insert("INSERT INTO knowledge_commodity (k_id, c_id) VALUES (#{kId}, #{cId})")
    Integer insertKnowledgeCommodity(KnowledgeCommodity knowledgeCommodity);
}
