package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.User;

@Mapper
public interface UserMapper {
    /**
     * 根据账号密码查询用户信息
     * @param user
     * @return
     */
    @Select("select u_id,u_name,u_account,u_telephone,u_email from user where u_account=#{uAccount} and u_password=#{uPassword}")
    User selectUserFromAccountAndPassword(User user);
}
