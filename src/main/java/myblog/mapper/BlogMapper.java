package myblog.mapper;

import myblog.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import myblog.entity.BlogList;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 获取文章列表信息
     * @return
     */
    List<BlogList> getBlogList();

    /**
     * 获取栏目文章列表
     * @param channelId
     * @param sortByViews
     * @return
     */
    List<BlogList> getChannelList(Integer channelId, Boolean sortByViews);

}
