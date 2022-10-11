package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.User;

public interface UserService {
    /**
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    boolean checkUserByUAccountText(Integer uAccount);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    User getUserPrivateByUAccountText(Integer uAccount);

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
    User getUserByUIdText(Integer uId);
}
