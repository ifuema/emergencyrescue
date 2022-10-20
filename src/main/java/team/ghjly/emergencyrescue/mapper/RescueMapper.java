package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import team.ghjly.emergencyrescue.entity.Rescue;

@Mapper
public interface RescueMapper {
    @Insert("INSERT INTO rescue (u_id, r_name, r_age, r_gender, r_address, r_telephone, r_state, r_time, past_medical_history, allergy_history, r_describe) VALUES (#{uId}, #{rName}, #{rAge}, #{rGender}, #{rAddress}, #{rTelephone}, '已申请', now(), #{pastMedicalHistory}, #{allergyHistory}, #{rDescribe})")
    @Options(useGeneratedKeys = true, keyProperty = "rId", keyColumn = "r_id")
    int insertRescue(Rescue rescue);
}
