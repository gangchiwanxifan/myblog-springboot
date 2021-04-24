package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Blog;
import myblog.entity.BlogDetail;
import myblog.entity.BlogList;
import myblog.mapper.BlogMapper;
import myblog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> selectDraftById(Integer id) {
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_status", 1)
               .eq("blog_author_id", id);
        return blogMapper.selectList(wrapper);
    }

    @Override
    public List<BlogList> selectBloglist() {
        return blogMapper.getBlogList();
    }

    @Override
    public List<BlogList> selectBloglist(Page<?> page) {
        return blogMapper.getBlogList(page);
    }

    @Override
    public List<BlogList> selectListBychannel(Integer channelId, Boolean sortByViews) {
        return blogMapper.getChannelList(channelId,sortByViews);
    }

    @Override
    public BlogDetail getDetail(Integer blogId) {
        Blog blog = blogMapper.selectById(blogId);
        // 增加浏览量
        blog.setBlogViews(blog.getBlogViews() + 1);
        blogMapper.updateById(blog);
        return blogMapper.getBlogDetail(blogId);
    }

    @Override
    public List<Blog> getHotList(Page<?> page) {
        return blogMapper.getHotList(page);
    }

    @Override
    public List<Blog> getListById(Blog blog) {
        return blogMapper.getListById(blog);
    }

    @Override
    public List<BlogList> getFavoriteList(Integer userId) {
        return blogMapper.getFavoriteById(userId);
    }

    @Override
    public List<BlogList> getSearchList(String keyword) {
        return blogMapper.searchBlog(keyword);
    }
}
