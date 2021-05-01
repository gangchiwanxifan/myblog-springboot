package myblog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Notice;
import myblog.entity.OrderDetail;
import myblog.entity.User;
import myblog.mapper.BlogMapper;
import myblog.mapper.OrderDetailMapper;
import myblog.mapper.UserMapper;
import myblog.service.NoticeService;
import myblog.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-29
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private NoticeService noticeService;

    @Override
    public void callBackSave(JSONObject jsonObject) {

        // 用户id
        Integer userId = jsonObject.getInteger("userId");
        // 目标用户id
        Integer targetId = jsonObject.getInteger("targetId");
        // 金额
        Integer price = jsonObject.getInteger("price");
        // 支付类型
        Integer orderType = jsonObject.getInteger("orderType");
        // 文章id
        Integer blogId = jsonObject.getInteger("blogId");
        // 标识时间戳
        String timestamp = jsonObject.getString("timestamp");

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderUserId(userId);
        orderDetail.setOrderUserName(userMapper.getNickname(userId));
        orderDetail.setOrderTargetId(targetId);
        orderDetail.setOrderTargetName(userMapper.getNickname(targetId));
        orderDetail.setOrderPrice(price);
        orderDetail.setOrderType(orderType);
        orderDetail.setOrderBlogId(blogId);
        orderDetail.setOrderBlogTitle(blogMapper.getBlogTitle(blogId));
        orderDetail.setOrderCheckId(timestamp);

        // 交易成功保存记录
        orderDetailMapper.insert(orderDetail);

        // 账户余额更新
        Integer banlance = userMapper.selectById(targetId).getBalance();
        User targetUser = new User();
        targetUser.setUserId(targetId);
        targetUser.setBalance(banlance + price);
        userMapper.updateById(targetUser);

        // 发送通知
        Notice notice = new Notice();
        notice.setEvent(4);
        notice.setNoticeUserId(targetId);
        notice.setNoticeSendId(userId);
        notice.setNoticeBlogId(blogId);
        noticeService.sendNotice(notice);




    }
}
