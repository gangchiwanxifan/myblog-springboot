package myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.Follow;
import myblog.entity.FollowList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-15
 */
public interface FollowService extends IService<Follow> {

    /**
     * 是否关注
     * @param follow
     * @return
     */
    Follow check(Follow follow);

    /**
     * 获取关注列表
     * @param follow
     * @return
     */
    List<FollowList> getFollowList(Follow follow);

    /**
     * 获取粉丝列表
     * @param follow
     * @return
     */
    List<FollowList> getFanList(Follow follow);
}
