package team.ghjly.emergencyrescue.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.Commodity;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.entity.groups.Login;
import team.ghjly.emergencyrescue.entity.groups.Regist;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
//@Validated
public class TestController {
    @Resource
    private UserService userService;


//    @GetMapping("/a")
//    public Integer test( @PositiveOrZero(message = "电话格式不正确！")  Integer integer) {
//        return integer;
//    }
//
//    @PostMapping("/login1")
//    public Rescue login(@RequestBody Rescue rescue) {
//        return rescue;
////        BigDecimal cPrice = commodity.getCPrice();
////        cPrice.setScale(2,BigDecimal.ROUND_DOWN);
////        System.out.println(cPrice);
////        return commodity;
//    }

//public static void main(String[] args) {
////    System.out.println(System.currentTimeMillis());
////    Double a = 50.1;
////    Double b = 40.2;
////    Double c = a+ b;
////    System.out.println(c);
////    System.out.println(new BigDecimal("1.20").add(new BigDecimal("2")));
//    System.out.println(System.currentTimeMillis());
//}
}
