package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.Blog;
import myblog.entity.BlogList;
import myblog.mapper.BlogMapper;
import myblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public List<BlogList> selectListBychannel(Integer channelId, Boolean sortByViews) {
        return blogMapper.getChannelList(channelId,sortByViews);
    }
}
