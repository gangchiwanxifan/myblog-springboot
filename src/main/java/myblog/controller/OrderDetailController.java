package myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.OrderDetail;
import myblog.mapper.UserMapper;
import myblog.service.OrderDetailService;
import myblog.utils.JsonResult;
import myblog.vo.PayVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-29
 */
@RestController
@RequestMapping("/order")
public class OrderDetailController {

    @Resource
    private OrderDetailService orderDetailService;

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/save")
    public JsonResult<Boolean> save(@RequestBody OrderDetail orderDetail) {
        orderDetail.setOrderUserName(userMapper.getNickname(orderDetail.getOrderUserId()));
        orderDetail.setOrderTargetName(userMapper.getNickname(orderDetail.getOrderTargetId()));
        return JsonResult.ok(orderDetailService.save(orderDetail));
    }

    @GetMapping("/list")
    public JsonResult<List<OrderDetail>> list(@RequestParam Integer userId) {
        QueryWrapper<OrderDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("order_user_id", userId).or().eq("order_target_id", userId)
                .orderByDesc("create_time");
        return JsonResult.ok(orderDetailService.list(wrapper));
    }

    @PostMapping("/callback")
    public JsonResult<Integer> listenerCallBack(@RequestBody PayVo payVo) {
        QueryWrapper<OrderDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("order_user_id", payVo.getUserId())
                .eq("order_check_id", payVo.getTimestamp());
        int count = orderDetailService.count(wrapper);
        return JsonResult.ok(count);
    }
}

