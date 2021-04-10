package myblog;

import myblog.entity.BlogList;
import myblog.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MyblogApplicationTests {

    @Resource
    private BlogMapper blogMapper;

    @Test
    void contextLoads() {
        List<BlogList> blogList = blogMapper.getBlogList();
        List<BlogList> blogList1 = blogMapper.getChannelList(6, false);
        blogList1.forEach(System.out::println);
    }

}
