package myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.Blog;
import myblog.entity.BlogList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
public interface BlogService extends IService<Blog> {

    /**
     * 草稿箱文章列表查询
     * @param id
     * @return
     */
    List<Blog> selectDraftById(Integer id);

    List<BlogList> selectBloglist();

    List<BlogList> selectListBychannel(Integer channelId, Boolean sortByViews);
}
