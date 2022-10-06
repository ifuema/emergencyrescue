package team.ghjly.emergencyrescue.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.Admin;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.entity.groups.Login;
import team.ghjly.emergencyrescue.service.AdminService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;


    /**
     * 登录请求
     * @param admin
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResultVO<?> login(@RequestBody @Validated({Login.class}) Admin admin, HttpServletRequest request) {
        Admin dataAdmin = adminService.getAdminByAccountAndPassword(admin);
        if (dataAdmin == null) {
            return new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号密码错误！");
        } else {
            request.getSession().setAttribute("admin", dataAdmin);
            return new ResultVO<>();
        }
    }
}
