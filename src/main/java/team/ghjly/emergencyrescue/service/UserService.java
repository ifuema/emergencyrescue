package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.User;

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
     * 根据账号密码判断是否已存在用户
     * @param user
     * @return
     */
    boolean checkUserByUAccountAndUPassword(User user);

    /**
     * 根据id文本获取用户信息
     * @param uId
     * @return
     */
    User getUserByUId(Integer uId);
}
