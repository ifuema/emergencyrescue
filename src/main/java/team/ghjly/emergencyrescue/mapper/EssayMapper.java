package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.Essay;
import team.ghjly.emergencyrescue.mapper.sql.EssayMapperSqlProvider;

import java.util.List;

@Mapper
public interface EssayMapper {
    /**
     * 根据过滤文章信息分页查询文章列表
     * @param pageSize
     * @param startIndex
     * @param essay
     * @return
     */
    @SelectProvider(type = EssayMapperSqlProvider.class, method = "selectEssayListPageByEssaySql")
    List<Essay> selectEssayListPageByEssay(Integer pageSize, Integer startIndex, Essay essay);

    /**
     * 根据id文本查询文章信息
     * @param eId
     * @return
     */
    @Select("SELECT * FROM essay WHERE e_id = #{eId}")
    Essay selectEssayByEId(Integer eId);

    @Insert("INSERT INTO essay (e_title, e_img, e_body, e_type) " +
            "VALUES (#{eTitle}, #{eImg}, #{eBody}, #{eType})")
    @Options(useGeneratedKeys = true, keyProperty = "eId", keyColumn = "e_id")
    Integer insertEssay(Essay essay);

    @Select("SELECT e_id FROM essay WHERE e_id = #{eId}")
    Integer selectEIdByEId(Integer eId);

    @Delete("DELETE FROM essay WHERE e_id = #{eId}")
    Integer deleteEssayByEId(Integer eId);

    @Update("UPDATE essay SET e_title = #{eTitle}, e_img = #{eImg}, " +
            "e_body = #{eBody}, e_type = #{eType} WHERE e_id = #{eId}")
    Integer updateEssayByEId(Essay essay);
}
