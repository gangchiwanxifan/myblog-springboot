package myblog.controller;


import com.alibaba.fastjson.JSONObject;
import myblog.entity.Blog;
import myblog.entity.BlogDetail;
import myblog.entity.BlogList;
import myblog.service.BlogService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    BlogService blogService;

    @RequestMapping("/save")
    public JsonResult<Boolean> save(@RequestBody Blog blog) {
        Boolean flag = blogService.save(blog);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/draft")
    public JsonResult<List<Blog>> draftList(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer id=jsonObject.getInteger("userId");
        List<Blog> drafts = blogService.selectDraftById(id);
        return  JsonResult.ok(drafts);
    }

    @RequestMapping("/delete")
    public JsonResult<Boolean> delete(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer id=jsonObject.getInteger("blogId");
        Boolean flag = blogService.removeById(id);
        return JsonResult.ok(flag);
    }

    @RequestMapping("test_blog")
    public JsonResult<Blog> get() {
        Blog blog = blogService.getById(3);
        return JsonResult.ok(blog);
    }

    @RequestMapping("/list")
    public JsonResult<List<BlogList>> list() {
        List<BlogList> blogList = blogService.selectBloglist();
        return JsonResult.ok(blogList);
    }

    @RequestMapping("/list_channel")
    public JsonResult<List<BlogList>> listByChannel(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer channelId = jsonObject.getInteger("channelId");
        Boolean sortByViews = jsonObject.getBoolean("sortByViews");
        System.out.println("=====================");
        System.out.println(sortByViews);
        System.out.println("=====================");
        List<BlogList> blogList = blogService.selectListBychannel(channelId, sortByViews);
        return JsonResult.ok(blogList);
    }

    @RequestMapping("/detail")
    public JsonResult<BlogDetail> getDetail(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer blogId = jsonObject.getInteger("blogId");
        BlogDetail detail = blogService.getDetail(blogId);
        return JsonResult.ok(detail);
    }

    @RequestMapping("/hot")
    public JsonResult<List<Blog>> getHot() {
        List<Blog> list = blogService.getHotList();
        return  JsonResult.ok(list);
    }
}

