package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.Rescue;

public class RescueMapperSqlProvider {
    public static String selectRescueListPageByRescueSql(final Rescue rescue) {
        return new SQL() {{
            SELECT("*").FROM("rescue");
            if (rescue.getrTelephone() != null) {
                WHERE("r_telephone = #{rescue.rTelephone}");
            }
            if (rescue.getrState() != null && rescue.getrState() != "") {
                WHERE("r_state = #{rescue.rState}");
            }
            if (rescue.getrName() != null && rescue.getrName() != "") {
                rescue.setrName("%" + rescue.getrName() + "%");
                WHERE("r_name LIKE #{rescue.rName}");
            }
            if (rescue.getrAddress() != null && rescue.getrAddress() != "") {
                rescue.setrAddress("%" + rescue.getrAddress() + "%");
                WHERE("r_address LIKE #{rescue.rAddress}");
            }
            if (rescue.getrGender() != null && rescue.getrGender() != "") {
                WHERE("r_gender = #{rescue.rGender}");
            }
            if (rescue.gettId() != null) {
                WHERE("t_id = #{rescue.tId}");
            }
            if (rescue.getuId() != null) {
                WHERE("u_id = #{rescue.uId}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
