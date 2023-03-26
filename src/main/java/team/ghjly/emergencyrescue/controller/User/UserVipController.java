package team.ghjly.emergencyrescue.controller.User;

import com.fasterxml.jackson.databind.JsonNode;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.Order;
import team.ghjly.emergencyrescue.entity.Rescue;
import team.ghjly.emergencyrescue.service.CommodityService;
import team.ghjly.emergencyrescue.service.OrderService;
import team.ghjly.emergencyrescue.util.HttpRequestUtil;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.entity.User;
import team.ghjly.emergencyrescue.entity.groups.Register;
import team.ghjly.emergencyrescue.service.RescueService;
import team.ghjly.emergencyrescue.service.UserService;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/vip")
public class UserVipController {
    @Resource
    private UserService userService;
    @Resource
    private RescueService rescueService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private OrderService orderService;
    @Resource
    private HttpRequestUtil httpRequestUtil;
    @Value("${afd.user_id}")
    private String afdUserId;
    @Value("${afd.token}")
    private String afdToken;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> accountExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号已存在！");
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> applyFailed = new ResultVO<>(ResultCode.FAILED, "申请失败！");
    private final ResultVO<?> orderRegisterFailed = new ResultVO<>(ResultCode.FAILED, "订单注册失败！请联系管理员！");
    private final ResultVO<?> tradeNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "不存在该订单！请核对订单号！");
    private final ResultVO<?> commodityNotExist = new ResultVO<>(ResultCode.FAILED, "商品缺失！请联系管理员！");
    private final ResultVO<?> commodityFailed = new ResultVO<>(ResultCode.FAILED, "获取商品参数错误！请联系管理员！");
    private final ResultVO<?> systemFailed = new ResultVO<>(ResultCode.FAILED, "系统错误！请联系管理员！");
    private final ResultVO<?> tradeExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "该订单号已被注册！请不要重复添加！");
    private final ResultVO<?> saveFailed = new ResultVO<>(ResultCode.FAILED, "保存失败！");

    /**
     * 获取已登录用户信息
     * @param request
     * @return
     */
    @GetMapping
    public ResultVO<?> my(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        User dataUser = userService.getUserByUId(sessionUser.getuId());
        if (dataUser == null) {
            return userNotExist;
        }
        return new ResultVO<>(dataUser);
    }

    /**
     * 申请救援
     * @param rescue
     * @param request
     * @return
     */
    @PostMapping("/rescue")
    public ResultVO<?> requestRescue(@RequestBody @Validated({Register.class}) Rescue rescue, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        rescue.setuId(sessionUser.getuId());
        if (rescueService.saveRescue(rescue)) {
            return new ResultVO<>(rescue.getrId());
        } else {
            return applyFailed;
        }
    }

    /**
     * 获取已登录用户救援信息列表
     * @param request
     * @return
     */
    @GetMapping("/rescue")
    public ResultVO<List<Rescue>> myRescue(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        List<Rescue> dataRescueList = rescueService.getRescueListByUId(sessionUser.getuId());
        return new ResultVO<>(dataRescueList);
    }

    /**
     * 获取已登录用户订单信息列表
     * @param request
     * @return
     */
    @GetMapping("/order")
    public ResultVO<List<Order>> myOrder(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        List<Order> dataOrderList = orderService.getOrderListByUId(sessionUser.getuId());
        return new ResultVO<>(dataOrderList);
    }

    /**
     * 修改已登录用户信息
     * @param user
     * @param request
     * @return
     */
    @PutMapping("/session")
    public ResultVO<?> changeUser(@RequestBody @Validated({Register.class}) User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (!sessionUser.getuAccount().equals(user.getuAccount())){
            if (userService.checkUserByUAccount(user.getuAccount())) {
                return accountExist;
            }
        }
        user.setuId(sessionUser.getuId());
        user.setuPassword(BCrypt.hashpw(user.getuPassword(), BCrypt.gensalt()));
        if (userService.modifyUserByUId(user)) {
            session.setAttribute("user", user);
            return success;
        } else {
            return saveFailed;
        }
    }

    /**
     * 订单注册
     * @param order
     * @param request
     * @return
     */
    @PostMapping("/order")
    public ResultVO<?> buy(@RequestBody @Validated({Register.class}) Order order, HttpServletRequest request) {
        if (!orderService.checkOrderByOTrade(order.getoTrade())) {
            HttpSession session = request.getSession();
            User sessionUser = (User) session.getAttribute("user");
            Order dataOrder = null;
            String url = "https://afdian.net/api/open/query-order";
            int page = 1;
            String params = "{\"page\":" + page + "}";
            String ts = String.valueOf(System.currentTimeMillis());
            ts = ts.substring(0, ts.length() - 3);
            Map<String, String> map = new HashMap<>();
            map.put("user_id", afdUserId);
            map.put("params", params);
            map.put("ts", ts);
            map.put("sign", DigestUtils.md5DigestAsHex((afdToken + "params" + params + "ts" + ts + "user_id" + afdUserId).getBytes()));
            JsonNode dataJsonNode = httpRequestUtil.getRequest(url, map);
            if (dataJsonNode != null) {
                if ("200".equals(dataJsonNode.path("ec").asText())) {
                    Iterator<JsonNode> dataOrdersJsonNode = dataJsonNode.path("data").path("list").elements();
                    while (dataOrdersJsonNode.hasNext()) {
                        JsonNode dataOrderJsonNode = dataOrdersJsonNode.next();
                        if (order.getoTrade().equals(dataOrderJsonNode.path("out_trade_no").asText())) {
                            if ("2".equals(dataOrderJsonNode.path("status").asText())) {
                                if (dataOrderJsonNode.path("sku_detail").size() == 1) {
                                    JsonNode dataDetailJsonNode = dataOrderJsonNode.path("sku_detail").path(0);
                                    Integer dataCId = commodityService.getCIdByCName(dataDetailJsonNode.path("name").asText());
                                    if (dataCId != null) {
                                        dataOrder = new Order();
                                        dataOrder.setcId(dataCId);
                                        dataOrder.setuId(sessionUser.getuId());
                                        dataOrder.setoTrade(dataOrderJsonNode.path("out_trade_no").asText());
                                        dataOrder.setoNum(Integer.parseInt(dataDetailJsonNode.path("count").asText()));
                                        try {
                                            dataOrder.setoTelephone(Long.parseLong(dataOrderJsonNode.path("address_phone").asText()));
                                        } catch (NumberFormatException e) {
                                        }
                                        dataOrder.setoName(dataOrderJsonNode.path("address_person").asText());
                                        dataOrder.setoAddress(dataOrderJsonNode.path("address_address").asText());
                                        dataOrder.setoPrice(dataOrderJsonNode.path("total_amount").asText());
                                        dataOrder.setoRemake(dataOrderJsonNode.path("remark").asText());
                                    } else {
                                        return commodityNotExist;
                                    }
                                } else {
                                    return commodityFailed;
                                }
                            }
                            break;
                        }
                    }
                    if (dataOrder != null) {
                        if (orderService.saveOrder(dataOrder)) {
                            return new ResultVO<>(dataOrder.getoId());
                        } else {
                            return orderRegisterFailed;
                        }
                    } else {
                        return tradeNotExist;
                    }
                } else {
                    return systemFailed;
                }
            } else {
                return systemFailed;
            }
        } else {
            return tradeExist;
        }
    }
}
