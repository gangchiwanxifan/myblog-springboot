package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Channel;
import myblog.mapper.ChannelMapper;
import myblog.service.ChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements ChannelService {

    @Resource
    private ChannelMapper channelMapper;

    @Override
    public Integer addChannel(Channel channel) {
        QueryWrapper<Channel> wrapper = new QueryWrapper<>();
        wrapper.eq("channelName", channel.getChannelName());
        Channel user2 = channelMapper.selectOne(wrapper);
        if (user2 != null) {
            return 0;
        }
        return channelMapper.insert(channel);
    }
}
