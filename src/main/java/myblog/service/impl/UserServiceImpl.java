package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Notice;
import myblog.entity.User;
import myblog.mapper.UserMapper;
import myblog.service.NoticeService;
import myblog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private NoticeService noticeService;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer login(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername());
        userQueryWrapper.eq("password", user.getPassword());
        User user1 = userMapper.selectOne(userQueryWrapper);
        return user1 != null ? user1.getUserId() : 0;
    }

    @Override
    public Integer register(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User user2 = userMapper.selectOne(wrapper);
        if (user2!=null){
            return 0;
        }
        return userMapper.insert(user);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public Boolean reward(Map<String, User> map) {
        User user = userMapper.selectById(map.get("user").getUserId());
        User author = userMapper.selectById(map.get("author").getUserId());
        Integer money = map.get("user").getBalance();
        Integer blogId = map.get("fakeUser").getUserId();
        Notice notice = new Notice();
        notice.setEvent(4);
        notice.setNoticeUserId(author.getUserId());
        notice.setNoticeSendId(user.getUserId());
        notice.setNoticeBlogId(blogId);
        if (user.getBalance() >= money) {
            noticeService.sendNotice(notice);
            user.setBalance(user.getBalance() - money);
            author.setBalance(author.getBalance() + money);
            userMapper.updateById(user);
            userMapper.updateById(author);
            return true;
        } else {
            return false;
        }
    }



}
