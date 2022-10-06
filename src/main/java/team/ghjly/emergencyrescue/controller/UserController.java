package team.ghjly.emergencyrescue.controller;

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


    /**
     * 登录请求
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResultVO<?> login(@RequestBody @Validated({Login.class}) User user, HttpServletRequest request) {
        User dataUser = userService.getUserByAccountAndPassword(user);
        if (dataUser == null) {
            return new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号密码错误！");
        } else {
            request.getSession().setAttribute("user", dataUser);
            return new ResultVO<>();
        }
    }

    /**
     * 注册请求
     * @param user
     * @return
     */
    @PostMapping("/regist")
    public ResultVO<?> regist(@RequestBody @Validated({Regist.class}) User user) {
        if (userService.hasUser(user)) {
            return new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号已存在！");
        } else {
            if (userService.saveUser(user) >= 1) {
                return new ResultVO<>();
            } else {
                return new ResultVO<>(ResultCode.UNKNOWN_FAILED, "注册失败！");
            }
        }
    }
}
