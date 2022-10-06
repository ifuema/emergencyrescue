package team.ghjly.emergencyrescue.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.entity.groups.Login;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    @Resource
    private UserService userService;


    @GetMapping("/test")
    public ResultVO test(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("user"));
        return new ResultVO();
    }

    @PostMapping("/login1")
    public User login(@RequestBody @Validated({Login.class}) User user, HttpServletRequest request) {
        User dataUser = userService.getUserByAccountAndPassword(user);
        return dataUser;
    }
}
