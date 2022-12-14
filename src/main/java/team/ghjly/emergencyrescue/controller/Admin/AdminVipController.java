package team.ghjly.emergencyrescue.controller.Admin;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.ghjly.emergencyrescue.entity.*;
import team.ghjly.emergencyrescue.entity.groups.AdvancedRegister;
import team.ghjly.emergencyrescue.entity.groups.Change;
import team.ghjly.emergencyrescue.entity.groups.Register;
import team.ghjly.emergencyrescue.service.*;
import team.ghjly.emergencyrescue.vo.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/admin/vip")
public class AdminVipController {
    @Resource
    private UserService userService;
    @Resource
    private AdminService adminService;
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
    @Resource
    private KnowledgeService knowledgeService;
    private int pageSize = 5;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private final ResultVO<?> deleteFailed = new ResultVO<>(ResultCode.FAILED, "删除失败！");
    private final ResultVO<?> saveFailed = new ResultVO<>(ResultCode.FAILED, "保存失败！");
    private final ResultVO<?> teamNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "救援队不存在！");
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> essayNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "文章不存在！");
    private final ResultVO<?> adminNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "管理员不存在！");
    private final ResultVO<?> commodityNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "商品不存在！");
    private final ResultVO<?> knowledgeNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "小知识不存在！");
    private final ResultVO<?> rescueNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "救援不存在！");
    private final ResultVO<?> commodityExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "商品已存在！");

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
    public ResultVO<?> addEssay(@RequestBody @Validated({Register.class}) Essay essay) {
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

    @GetMapping
    public ResultVO<?> my(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin sessionAdmin = (Admin) session.getAttribute("admin");
        Admin dataAdmin = adminService.getAdminByAId(sessionAdmin.getaId());
        if (dataAdmin == null) {
            return adminNotExist;
        }
        return new ResultVO<>(dataAdmin);
    }

    @PostMapping("/commodity")
    public ResultVO<?> addCommodity(@RequestBody @Validated({Register.class}) Commodity commodity) {
        if (commodityService.checkCommodityByCName(commodity.getcName())) {
            return commodityExist;
        } else {
            if (commodityService.saveCommodity(commodity)) {
                return new ResultVO<>(commodity.getcId());
            } else {
                return saveFailed;
            }
        }
    }

    @DeleteMapping("/commodity/{cId}")
    public ResultVO<?> deleteCommodity(@PathVariable Integer cId) {
        if (commodityService.checkCommodityByCId(cId)) {
            if (commodityService.removeCommodityByCId(cId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return commodityNotExist;
        }
    }

    @DeleteMapping("/knowledge/{kId}")
    public ResultVO<?> deleteKonwledge(@PathVariable Integer kId) {
        if (knowledgeService.checkKonwledgeByKId(kId)) {
            if (knowledgeService.removeKonwledgeByKId(kId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return knowledgeNotExist;
        }
    }

    @PostMapping("/knowledge")
    public ResultVO<?> addKnowledge(@RequestBody @Validated({AdvancedRegister.class}) Knowledge knowledge) {
        Iterator<Commodity> commodityIterator = knowledge.getCommodityList().iterator();
        boolean removeState;
        boolean judgeState;
        while (commodityIterator.hasNext()) {
            removeState = false;
            judgeState = false;
            Commodity nextCommodity = commodityIterator.next();
            for (Commodity commodity : knowledge.getCommodityList()) {
                if (nextCommodity.getcId().equals(commodity.getcId())) {
                    if (judgeState) {
                        commodityIterator.remove();
                        removeState = true;
                        break;
                    } else {
                        judgeState = true;
                    }
                }
            }
            if (!removeState) {
                if (!commodityService.checkCommodityByCId(nextCommodity.getcId())) {
                    return new ResultVO<>(ResultCode.VALIDATE_FAILED, "编号为 " + nextCommodity.getcId() + " 的商品不存在！");
                }
            }
        }
        if (knowledgeService.saveKnowledge(knowledge)) {
            return new ResultVO<>(knowledge.getkId());
        } else {
            return saveFailed;
        }
    }

    @PutMapping("/team/{tId}")
    public ResultVO<?> changeTeam(@RequestBody @Validated({Register.class}) Team team, @PathVariable Integer tId) {
        if (teamService.checkTeamByTId(tId)) {
            team.settId(tId);
            if (teamService.modifyTeamByTId(team)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return teamNotExist;
        }
    }

    @PutMapping("/commodity/{cId}")
    public ResultVO<?> changeCommodity(@RequestBody @Validated({Register.class}) Commodity commodity, @PathVariable Integer cId) {
        String dataCName = commodityService.getCNameByCId(cId);
        if (dataCName == null) {
            if (!dataCName.equals(commodity.getcName())) {
                if (commodityService.checkCommodityByCName(commodity.getcName())) {
                    return commodityExist;
                }
            }
            commodity.setcId(cId);
            if (commodityService.modifyCommodityByCId(commodity)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return commodityNotExist;
        }
    }

    @PutMapping("/essay/{eId}")
    public ResultVO<?> changeEssay(@RequestBody @Validated({Register.class}) Essay essay, @PathVariable Integer eId) {
        if (essayService.checkEssayByEId(eId)) {
            essay.seteId(eId);
            if (essayService.modifyEssayByEId(essay)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return essayNotExist;
        }
    }

    @PutMapping("/rescue/{rId}")
    public ResultVO<?> changeRescue(@RequestBody @Validated({Register.class, Change.class}) Rescue rescue, @PathVariable Integer rId) {
        if (rescueService.checkRescueByRId(rId)) {
            if (rescue.gettId() != null) {
                if (!teamService.checkTeamByTId(rescue.gettId())) {
                    return teamNotExist;
                }
            }
            rescue.setrId(rId);
            if (rescueService.modifyRescueByRId(rescue)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return rescueNotExist;
        }
    }

    @PutMapping("/knowledge/{kId}")
    public ResultVO<?> addKnowledge(@RequestBody @Validated({AdvancedRegister.class}) Knowledge knowledge, @PathVariable Integer kId) {
        if (knowledgeService.checkKonwledgeByKId(kId)) {
            Iterator<Commodity> commodityIterator = knowledge.getCommodityList().iterator();
            boolean removeState;
            boolean judgeState;
            while (commodityIterator.hasNext()) {
                removeState = false;
                judgeState = false;
                Commodity nextCommodity = commodityIterator.next();
                for (Commodity commodity : knowledge.getCommodityList()) {
                    if (nextCommodity.getcId().equals(commodity.getcId())) {
                        if (judgeState) {
                            commodityIterator.remove();
                            removeState = true;
                            break;
                        } else {
                            judgeState = true;
                        }
                    }
                }
                if (!removeState) {
                    if (!commodityService.checkCommodityByCId(nextCommodity.getcId())) {
                        return new ResultVO<>(ResultCode.VALIDATE_FAILED, "编号为 " + nextCommodity.getcId() + " 的商品不存在！");
                    }
                }
            }
            knowledge.setkId(kId);
            if (knowledgeService.modifyKnowledgeByKId(knowledge)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return knowledgeNotExist;
        }
    }
}
