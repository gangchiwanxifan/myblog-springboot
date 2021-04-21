package myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import myblog.entity.Follow;
import myblog.entity.FollowList;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-15
 */
public interface FollowMapper extends BaseMapper<Follow> {

    /**
     * 获取关注列表
     * @param follow
     * @return
     */
    List<FollowList> selectFollowList(Follow follow);

    /**
     * 获取粉丝列表
     * @param follow
     * @return
     */
    List<FollowList> selectFanList(Follow follow);

}
