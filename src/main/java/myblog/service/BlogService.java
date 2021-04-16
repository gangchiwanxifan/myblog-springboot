package myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.Blog;
import myblog.entity.BlogDetail;
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

    /**
     * 获取首页文章列表
     * @return
     */
    List<BlogList> selectBloglist(BlogList blog);

    /**
     * 获取栏目文章列表
     * @param channelId
     * @param sortByViews
     * @return
     */
    List<BlogList> selectListBychannel(Integer channelId, Boolean sortByViews);

    /**
     * 获取文章详情
     * @param blogId
     * @return
     */
    BlogDetail getDetail(Integer blogId);

    /**
     * 获取首页热门列表
     * @return
     */
    List<Blog> getHotList();

    /**
     * 获取用户文章列表
     * @param blog
     * @return
     */
    List<Blog> getListById(Blog blog);

    /**
     * 获取用户收藏列表
     * @param userId
     * @return
     */
    List<BlogList> getFavoriteList(Integer userId);
}
