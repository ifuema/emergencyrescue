package team.ghjly.emergencyrescue.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
     * @return
     */
    @PostMapping("/login")
    public ResultVO<String> login(@RequestBody @Validated({Login.class}) User user, HttpServletRequest request) {
        User dataUser = userService.login(user);
        if (dataUser == null) {
            return new ResultVO<>("账号密码错误！");
        } else {
            request.getSession().setAttribute("user", dataUser);
            return new ResultVO<>();
        }
    }
}
