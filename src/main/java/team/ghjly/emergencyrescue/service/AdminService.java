package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Admin;

public interface AdminService {
    /**
     * 根据账号文本获取管理员隐私信息
     * @param aAccount
     * @return
     */
    Admin getAdminPrivateByAAccount(Integer aAccount);
}
