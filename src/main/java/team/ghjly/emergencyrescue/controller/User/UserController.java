package team.ghjly.emergencyrescue.controller.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.entity.groups.Login;
import team.ghjly.emergencyrescue.entity.groups.Regist;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    private ResultVO<?> success = new ResultVO<>();
    private ResultVO<?> accountNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号不存在！");
    private ResultVO<?> accountExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号已存在！");
    private ResultVO<?> registFailed = new ResultVO<>(ResultCode.FAILED, "注册失败！");
    private ResultVO<?> accountAndPasswordError = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号密码错误！");


    /**
     * 登录请求
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResultVO<?> login(@RequestBody @Validated({Login.class}) User user, HttpServletRequest request) {
        User dataUser = userService.getUserPrivateByUAccountText(user.getUAccount());
        if (dataUser == null) {
            return accountNotExist;
        } else {
            boolean result = false;
            try {
                result = BCrypt.checkpw(user.getUPassword(), dataUser.getUPassword());
            } catch (IllegalArgumentException e) {
            }
            if (result) {
                request.getSession().setAttribute("user", dataUser);
                return success;
            } else {
                return accountAndPasswordError;
            }
        }
    }

    /**
     * 注册请求
     * @param user
     * @return
     */
    @PostMapping("/regist")
    public ResultVO<?> regist(@RequestBody @Validated({Regist.class}) User user) {
        if (userService.checkUserByUAccountText(user.getUAccount())) {
            return accountExist;
        } else {
            user.setUPassword(BCrypt.hashpw(user.getUPassword(), BCrypt.gensalt()));
            if (userService.saveUser(user) >= 1) {
                return success;
            } else {
                return registFailed;
            }
        }
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public ResultVO<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return success;
    }
}
