package team.ghjly.emergencyrescue.service.impl;

import org.springframework.stereotype.Service;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.mapper.UserMapper;
import team.ghjly.emergencyrescue.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    @Override
    public boolean checkUserByUAccount(Integer uAccount) {
        Integer dataUId = userMapper.selectUIdByUAccount(uAccount);
        if (dataUId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        if (userMapper.insertUser(user) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    @Override
    public User getUserPrivateByUAccount(Integer uAccount) {
        return userMapper.selectUserPrivateByUAccount(uAccount);
    }

    /**
     * 根据账号密码判断是否已存在用户
     * @param user
     * @return
     */
    @Override
    public boolean checkUserByUAccountAndUPassword(User user) {
        Integer dataUId = userMapper.selectUIdByUAccountAndUPassword(user);
        if (dataUId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据id文本获取用户信息
     * @param uId
     * @return
     */
    @Override
    public User getUserByUId(Integer uId) {
        return userMapper.selectUserByUId(uId);
    }

    /**
     * 根据过滤用户信息分页获取用户列表
     * @param pageSize
     * @param pageNum
     * @param user
     * @return
     */
    @Override
    public List<User> getUserListPageByUser(int pageSize, Integer pageNum, User user) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return userMapper.selectUserListPageByUser(pageSize, startIndex, user);
    }

    @Override
    public boolean removeUserByUId(Integer uId) {
        if (userMapper.deleteUserByUId(uId) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkUserByUId(Integer uId) {
        Integer dataTId = userMapper.selectUIdByUId(uId);
        if (dataTId == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean modifyUserByUId(User user) {
        if (userMapper.updateUserByUId(user) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
