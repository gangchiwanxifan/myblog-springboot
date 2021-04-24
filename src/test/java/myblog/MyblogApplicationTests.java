package myblog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import myblog.entity.*;
import myblog.mapper.BlogMapper;
import myblog.mapper.CommentMapper;
import myblog.mapper.NoticeMapper;
import myblog.service.BlogService;
import myblog.service.FavoriteService;
import myblog.service.HomePageService;
import myblog.service.NoticeService;
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

    @Resource
    private FavoriteService favoriteService;

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private NoticeService noticeService;

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
    void getHomePage() {
        QueryWrapper<HomePage> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 1);
        // Boolean throwEx;
        HomePage one = homePageService.getOne(wrapper);
    }

    @Test
    void testFavorite() {
        Favorite favorite = new Favorite();
        favorite.setFavoriteUserId(5);
        favorite.setFavoriteBlogId(5);
        System.out.println(favorite);
        Favorite one = favoriteService.check(favorite);
        System.out.println(one);

    }

    @Test
    void testgetid() {
        System.out.println(blogMapper.getAuthorId(11));
    }

    @Test
    void getnoticelist() {
        Notice notice = new Notice();
        notice.setNoticeStatus(0);
        notice.setNoticeUserId(1);
        List<NoticeInfo> noticeList = noticeService.getNotice(notice);
        System.out.println(noticeList);
    }

    @Test
    void testPage() {
        Page<BlogList> page = new Page<>(4,3);
        List<BlogList> list = blogService.selectBloglist(page);
        list.forEach(System.out::println);

    }

    @Test
    void delcom() {
        // QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        // wrapper.eq("parent_id", 43);
        // List<Comment> comments = commentMapper.selectList(wrapper);
        List<Integer> children = commentMapper.getChildren(44);
        System.out.println(children);
        System.out.println(children.isEmpty());
    }
}
