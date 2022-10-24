package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.Rescue;

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
            "'已申请', now(), #{pastMedicalHistory}, #{allergyHistory}, #{rDescribe})")
    @Options(useGeneratedKeys = true, keyProperty = "rId", keyColumn = "r_id")
    int insertRescue(Rescue rescue);

    @Select("SELECT * FROM rescue WHERE u_id = #{uId}")
    List<Rescue> selectRescueListByUId(Integer uId);
}
