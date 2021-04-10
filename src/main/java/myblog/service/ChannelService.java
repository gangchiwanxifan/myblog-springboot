package myblog.service;

import myblog.entity.Channel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
public interface ChannelService extends IService<Channel> {

    /**
     * 添加栏目
     * @param channel channel
     * @return channel.id
     */
    Integer addChannel(Channel channel);

}
