package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team.ghjly.emergencyrescue.entity.Admin;

@Mapper
public interface AdminMapper {
    /**
     * 根据账号文本查询管理员隐私信息
     * @param aAccount
     * @return
     */
    @Select("SELECT * FROM admin WHERE a_account = #{aAccount}")
    Admin selectAdminPrivateByUAccountText(Integer aAccount);
}
