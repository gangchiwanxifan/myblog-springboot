package myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import myblog.entity.Blog;
import myblog.entity.BlogDetail;
import myblog.entity.BlogList;
import org.apache.ibatis.annotations.Select;

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
     * 分页获取文章列表信息
     * @param page
     * @return
     */
    List<BlogList> getBlogList(Page<?> page);

    /**
     * 获取栏目文章列表
     * @param channelId
     * @param sortByViews
     * @return
     */
    List<BlogList> getChannelList(Integer channelId, Boolean sortByViews);

    /**
     * 获取文章详情
     * @param blogId
     * @return
     */
    BlogDetail getBlogDetail(Integer blogId);

    /**
     * 获取首页热门文章
     * @return
     */
    List<Blog> getHotList();

    /**
     * 获取指定用户文章列表
     * @param  blog
     * @return
     */
    List<Blog> getListById(Blog blog);

    /**
     * 获取用户收藏文章
     * @param userId
     * @return
     */
    List<BlogList> getFavoriteById(Integer userId);

    /**
     * 获取文章作者id
     * @param blogId
     * @return
     */
    @Select("select blog_author_id from blog where blog_id = #{blogId}")
    Integer getAuthorId(Integer blogId);

    /**
     * 获取文章标题
     * @param blogId
     * @return
     */
    @Select("select blog_title from blog where blog_id = #{blogId}")
    String getBlogTitle(Integer blogId);

    /**
     * 搜索文章
     * @param keyword
     * @return
     */
    List<BlogList> searchBlog(String keyword);

}
