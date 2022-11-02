package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.mapper.sql.RescueMapperSqlProvider;

import java.util.List;

@Mapper
public interface RescueMapper {
    /**
     * 插入一条救援信息
     * @param rescue
     * @return
     */
    @Insert("INSERT INTO rescue (u_id, r_name, r_age, r_gender, r_address, r_telephone, " +
            "r_state, r_time, past_medical_history, allergy_history, r_describe) VALUES " +
            "(#{uId}, #{rName}, #{rAge}, #{rGender}, #{rAddress}, #{rTelephone}, " +
            "#{rState}, #{rTime}, #{pastMedicalHistory}, #{allergyHistory}, #{rDescribe})")
    @Options(useGeneratedKeys = true, keyProperty = "rId", keyColumn = "r_id")
    Integer insertRescue(Rescue rescue);

    /**
     * 根据用户id文本查询救援列表
     * @param uId
     * @return
     */
    @Select("SELECT * FROM rescue WHERE u_id = #{uId}")
    List<Rescue> selectRescueListByUId(Integer uId);

    /**
     * 根据过滤救援信息分页查询救援列表
     * @param pageSize
     * @param startIndex
     * @param rescue
     * @return
     */
    @SelectProvider(type = RescueMapperSqlProvider.class, method = "selectRescueListPageByRescueSql")
    List<Rescue> selectRescueListPageByRescue(int pageSize, Integer startIndex, Rescue rescue);

    @Select("SELECT r_id FROM rescue WHERE r_id = #{rId}")
    Integer selectRIdByRId(Integer rId);

    @Update("UPDATE rescue SET r_name = #{rName}, r_age = #{rAge}, r_gender = #{rGender}, " +
            "r_address = #{rAddress}, r_telephone = #{rTelephone}, r_state = #{rState}" +
            "past_medical_history = #{pastMedicalHistory}, allergy_history = #{allergyHistory}, " +
            "r_describe = #{rDescribe} WHERE r_id = #{rId}")
    Integer updateRescueByRId(Rescue rescue);
}
