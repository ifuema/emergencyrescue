package team.ghjly.emergencyrescue.controller.Admin;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.Admin;
import team.ghjly.emergencyrescue.vo.ResultCode;
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
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> accountNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号不存在！");
    private final ResultVO<?> accountOrPasswordError = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号或密码错误！");

    /**
     * 登录请求
     * @param admin
     * @param request
     * @return
     */
    @PostMapping("/session")
    public ResultVO<?> login(@RequestBody @Validated({Login.class}) Admin admin, HttpServletRequest request) {
        Admin dataAdmin = adminService.getAdminPrivateByAAccount(admin.getaAccount());
        if (dataAdmin == null) {
            return accountNotExist;
        } else {
            boolean result = false;
            try {
                result = BCrypt.checkpw(admin.getaPassword(), dataAdmin.getaPassword());
            } catch (IllegalArgumentException e) {
            }
            if (result) {
                request.getSession().setAttribute("admin", dataAdmin);
                return success;
            } else {
                return accountOrPasswordError;
            }
        }
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @DeleteMapping("/session")
    public ResultVO<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("admin");
        return success;
    }
}
