package team.ghjly.emergencyrescue.mapper;

import org.apache.ibatis.annotations.*;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.mapper.sql.UserMapperSqlProvider;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     *插入一条用户信息
     * @param user
     * @return
     */
    @Insert("INSERT INTO user (u_name, u_account, u_password, u_telephone, u_email) " +
            "VALUES (#{uName}, #{uAccount}, #{uPassword}, #{uTelephone}, #{uEmail})")
    @Options(useGeneratedKeys = true, keyProperty = "uId", keyColumn = "u_id")
    int insertUser(User user);

    /**
     * 根据账号文本查询用户隐私信息
     * @param uAccount
     * @return
     */
    @Select("SELECT * FROM user WHERE u_account = #{uAccount}")
    User selectUserPrivateByUAccount(Integer uAccount);

    /**
     * 根据账号文本查询用户id
     * @param uAccount
     * @return
     */
    @Select("SELECT u_id FROM user WHERE u_account = #{uAccount}")
    Integer selectUIdByAccount(Integer uAccount);

    /**
     * 根据账号密码查询用户id
     * @param user
     * @return
     */
    @Select("SELECT u_id FROM user WHERE u_account = #{uAccount} AND u_password = #{uPassword}")
    Integer selectUIdByAccountAndPassword(User user);

    /**
     * 根据id文本查询用户信息
     * @param uId
     * @return
     */
    @Select("SELECT u_id, u_name, u_account, u_telephone, u_email FROM user WHERE u_id = #{uId}")
    User selectUserByUId(Integer uId);

    @SelectProvider(type = UserMapperSqlProvider.class, method = "selectUserListPageByUserSql")
    List<User> selectUserListPageByUser(int pageSize, Integer startIndex, User user);
}
