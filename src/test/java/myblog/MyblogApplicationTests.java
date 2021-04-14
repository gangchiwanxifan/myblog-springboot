package myblog;

import myblog.entity.Blog;
import myblog.entity.BlogDetail;
import myblog.entity.BlogList;
import myblog.entity.Comment;
import myblog.mapper.BlogMapper;
import myblog.mapper.CommentMapper;
import myblog.service.BlogService;
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

    @Test
    void contextLoads() {
        List<BlogList> blogList = blogMapper.getBlogList();
        List<BlogList> blogList1 = blogMapper.getChannelList(6, false);
        blogList1.forEach(System.out::println);
    }

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

}
