package team.ghjly.emergencyrescue.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
import team.ghjly.emergencyrescue.entity.User;

public class UserMapperSqlProvider {
    public static String selectUserListPageByUserSql(final User user) {
        return new SQL() {{
            SELECT("u_id, u_name, u_account, u_telephone, u_email").FROM("user");
            if (user.getuAccount() != null) {
                WHERE("u_account = #{user.uAccount}");
            }
            if (user.getuTelephone() != null) {
                WHERE("u_telephone = #{user.uTelephone}");
            }
            if (user.getuName() != null && user.getuName() != "") {
                user.setuName("%" + user.getuName() + "%");
                WHERE("u_name LIKE #{user.uName}");
            }
            if (user.getuEmail() != null && user.getuEmail() != "") {
                WHERE("u_email = #{user.uEmail}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
