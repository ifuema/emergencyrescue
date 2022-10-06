package team.ghjly.emergencyrescue.service;

import team.ghjly.emergencyrescue.entity.Admin;

public interface AdminService {
    /**
     * 根据账号和密码获取管理员信息
     * @param admin
     * @return
     */
    Admin getAdminByAccountAndPassword(Admin admin);
}
