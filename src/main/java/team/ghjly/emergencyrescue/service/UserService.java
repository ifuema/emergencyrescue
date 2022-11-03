package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    boolean checkUserByUAccount(Integer uAccount);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean saveUser(User user);

    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    User getUserPrivateByUAccount(Integer uAccount);

    /**
     * 根据账号密码获取用户id
     * @param user
     * @return
     */
    Integer getUIdByUAccountAndUPassword(User user);

    /**
     * 根据id文本获取用户信息
     * @param uId
     * @return
     */
    User getUserByUId(Integer uId);

    /**
     * 根据过滤用户信息分页获取用户列表
     * @param pageSize
     * @param pageNum
     * @param user
     * @return
     */
    List<User> getUserListPageByUser(int pageSize, Integer pageNum, User user);

    /**
     * 根据id删除用户
     * @param uId
     * @return
     */
    boolean removeUserByUId(Integer uId);

    /**
     * 根据id文本判断是否已存在用户
     * @param uId
     * @return
     */
    boolean checkUserByUId(Integer uId);

    /**
     * 根据id修改用户
     * @param user
     * @return
     */
    boolean modifyUserByUId(User user);
}
