package myblog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.*;
import myblog.mapper.BlogMapper;
import myblog.mapper.CommentMapper;
import myblog.service.BlogService;
import myblog.service.HomePageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MyblogApplicationTests {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogService blogService;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private HomePageService homePageService;

    // @Test
    // void contextLoads() {
    //
    //     List<BlogList> blogList = blogMapper.getBlogList(BlogList blog);
    //     List<BlogList> blogList1 = blogMapper.getChannelList(6, false);
    //     blogList1.forEach(System.out::println);
    // }

    @Test
    void getDetail() {
        BlogDetail detail = blogService.getDetail(3);
        System.out.println(detail);

    }

    @Test
    void getComments() {
        List<Comment> comments = commentMapper.selectComment(7);
        comments.forEach(System.out::println);
    }

    @Test
    void getHot() {
        List<Blog> hotList = blogMapper.getHotList();
        hotList.forEach(System.out::println);
    }

    @Test
    void getHomePage() {
        QueryWrapper<HomePage> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 1);
        // Boolean throwEx;
        HomePage one = homePageService.getOne(wrapper);
    }

}
