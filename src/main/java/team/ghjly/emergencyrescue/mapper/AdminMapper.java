package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.Admin;

@Mapper
public interface AdminMapper {
    /**
     * 根据账号和密码查询管理员信息
     * @param admin
     * @return
     */
    @Select("SELECT a_account FROM admin WHERE a_account = #{aAccount} AND a_password = #{aPassword}")
    Admin selectAdminByAccountAndPassword(Admin admin);
}
