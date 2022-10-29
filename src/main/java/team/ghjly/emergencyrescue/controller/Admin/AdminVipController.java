package team.ghjly.emergencyrescue.controller.Admin;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.*;
import team.ghjly.emergencyrescue.entity.groups.Regist;
import team.ghjly.emergencyrescue.service.*;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/vip")
public class AdminVipController {
    @Resource
    private UserService userService;
    @Resource
    private TeamService teamService;
    @Resource
    private RescueService rescueService;
    @Resource
    private OrderService orderService;
    @Resource
    private EssayService essayService;
    @Resource
    private CommodityService commodityService;
    private int pageSize = 5;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private final ResultVO<?> deleteFailed = new ResultVO<>(ResultCode.FAILED, "删除失败！");
    private final ResultVO<?> saveFailed = new ResultVO<>(ResultCode.FAILED, "保存失败！");
    private final ResultVO<?> teamNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "救援队不存在！");
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> essayNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "文章不存在！");

    /**
     * 分页获取用户
     * @param pageNum
     * @param user
     * @return
     */
    @GetMapping("/user/page/{pageNum}")
    public ResultVO<?> userPage(@PathVariable Integer pageNum, User user) {
        List<User> dataUserList = userService.getUserListPageByUser(pageSize, pageNum, user);
        if (dataUserList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataUserList);
        }
    }

    /**
     * 删除救援队
     * @param tId
     * @return
     */
    @DeleteMapping("/team/{tId}")
    public ResultVO<?> deleteTeam(@PathVariable Integer tId) {
        if (teamService.checkTeamByTId(tId)) {
            if (teamService.removeTeamByTId(tId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return teamNotExist;
        }
    }

    /**
     * 分页获取救援申请
     * @param pageNum
     * @param rescue
     * @return
     */
    @GetMapping("/rescue/page/{pageNum}")
    public ResultVO<?> rescuePage(@PathVariable Integer pageNum, Rescue rescue) {
        List<Rescue> dataRescueList = rescueService.getRescueListPageByRescue(pageSize, pageNum, rescue);
        if (dataRescueList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataRescueList);
        }
    }

    /**
     * 分页获取订单
     * @param pageNum
     * @param order
     * @return
     */
    @GetMapping("/order/page/{pageNum}")
    public ResultVO<?> orderPage(@PathVariable Integer pageNum, Order order) {
        List<Order> dataOrderList = orderService.getROrderListPageByOrder(pageSize, pageNum, order);
        if (dataOrderList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataOrderList);
        }
    }

    @DeleteMapping("/user/{uId}")
    public ResultVO<?> deleteUser(@PathVariable Integer uId) {
        if (userService.checkUserByUId(uId)) {
            if (userService.removeUserByUId(uId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return userNotExist;
        }
    }

    @PostMapping("/essay")
    public ResultVO<?> addEssay(@RequestBody @Validated({Regist.class}) Essay essay) {
        if (essayService.saveEssay(essay)) {
            return new ResultVO<>(essay.geteId());
        } else {
            return saveFailed;
        }
    }

    @DeleteMapping("/essay/{eId}")
    public ResultVO<?> deleteEssay(@PathVariable Integer eId) {
        if (essayService.checkEssayByEId(eId)) {
            if (essayService.removeEssayByEId(eId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return essayNotExist;
        }
    }

//    @PostMapping("/commodity")
//    public ResultVO<?> addCommodity(@RequestBody @Validated({Regist.class}) Commodity commodity) {
//        if (CommodityService.saveCommodity(commodity)) {
//            return new ResultVO<>(commodity.getcId());
//        } else {
//            return saveFailed;
//        }
//    }
}
