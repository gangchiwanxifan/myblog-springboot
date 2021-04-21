package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Follow;
import myblog.entity.FollowList;
import myblog.mapper.FollowMapper;
import myblog.service.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-15
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {

    @Resource
    private FollowMapper followMapper;

    @Override
    public Follow check(Follow follow) {
        QueryWrapper<Follow> wrapper = new QueryWrapper<>();
        wrapper.eq("follow_user_id", follow.getFollowUserId())
                .eq("follow_fan_id", follow.getFollowFanId());
        return followMapper.selectOne(wrapper);
    }

    @Override
    public List<FollowList> getFollowList(Follow follow) {
        return followMapper.selectFollowList(follow);
    }

    @Override
    public List<FollowList> getFanList(Follow follow) {
        return followMapper.selectFanList(follow);
    }
}
