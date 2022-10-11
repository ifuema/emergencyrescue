package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import team.ghjly.emergencyrescue.entity.Essay;
import team.ghjly.emergencyrescue.mapper.sql.EssayMapperSqlProvider;

import java.util.List;

@Mapper
public interface EssayMapper {
    @SelectProvider(type = EssayMapperSqlProvider.class, method = "selectEssayListPageByEssaySql")
    List<Essay> selectEssayListPageByEssay(Integer pageSize, Integer startIndex, Essay essay);
}
