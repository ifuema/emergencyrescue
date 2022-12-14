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
    Integer insertUser(User user);

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
    Integer selectUIdByUAccount(Integer uAccount);

    /**
     * 根据账号密码查询用户id
     * @param user
     * @return
     */
    @Select("SELECT u_id FROM user WHERE u_account = #{uAccount} AND u_password = #{uPassword}")
    Integer selectUIdByUAccountAndUPassword(User user);

    /**
     * 根据id文本查询用户信息
     * @param uId
     * @return
     */
    @Select("SELECT u_id, u_name, u_account, u_telephone, u_email FROM user WHERE u_id = #{uId}")
    User selectUserByUId(Integer uId);

    /**
     * 根据过滤用户信息分页查询用户列表
     * @param pageSize
     * @param startIndex
     * @param user
     * @return
     */
    @SelectProvider(type = UserMapperSqlProvider.class, method = "selectUserListPageByUserSql")
    List<User> selectUserListPageByUser(int pageSize, Integer startIndex, User user);

    /**
     * 根据id文本删除用户
     * @param uId
     * @return
     */
    @Delete("DELETE FROM user WHERE u_id = #{uId}")
    Integer deleteUserByUId(Integer uId);

    /**
     * 根据id文本查询用户id
     * @param uId
     * @return
     */
    @Select("SELECT u_id FROM user WHERE u_id = #{uId}")
    Integer selectUIdByUId(Integer uId);

    /**
     * 根据id文本修改用户
     * @param user
     * @return
     */
    @Update("UPDATE user SET u_name = #{uName}, u_account = #{uAccount}, u_password = #{uPassword}, " +
            "u_telephone = #{uTelephone}, u_email = #{uEmail} WHERE u_id = #{uId}")
    Integer updateUserByUId(User user);
}
