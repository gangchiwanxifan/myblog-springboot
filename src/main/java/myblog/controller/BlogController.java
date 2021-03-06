package myblog.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import myblog.entity.Blog;
import myblog.entity.BlogDetail;
import myblog.entity.BlogList;
import myblog.service.BlogService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public JsonResult<List<BlogList>> list() {
        List<BlogList> blogList = blogService.selectBloglist();
        return JsonResult.ok(blogList);
    }

    @RequestMapping("/list_channel")
    public JsonResult<List<BlogList>> listByChannel(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer channelId = jsonObject.getInteger("channelId");
        Boolean sortByViews = jsonObject.getBoolean("sortByViews");
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

    @RequestMapping("/hot/{pageNum}")
    public JsonResult<List<Blog>> getHot(@PathVariable("pageNum") Integer pageNum) {
        Page<Blog> page = new Page<>(pageNum, 5);
        List<Blog> list = blogService.getHotList(page);
        return  JsonResult.ok(list);
    }

    @RequestMapping("/list/user")
    public JsonResult<List<Blog>> getListByUserId(@RequestBody Blog blog) {
        // JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        // Integer userId = jsonObject.getInteger("userId");
        return JsonResult.ok(blogService.getListById(blog));
    }

    @RequestMapping("/list/favorite")
    public JsonResult<List<BlogList>> getFavoriteList(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer userId = jsonObject.getInteger("userId");
        return JsonResult.ok(blogService.getFavoriteList(userId));
    }

    @RequestMapping("/get")
    public JsonResult<Blog> getById(@RequestBody Blog blog) {
        return JsonResult.ok(blogService.getById(blog.getBlogId()));
    }

    @RequestMapping("/update")
    public JsonResult<Boolean> update(@RequestBody Blog blog) {
        return JsonResult.ok(blogService.updateById(blog));
    }

    @RequestMapping("/search")
    public JsonResult<List<BlogList>> search(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        String keyword = jsonObject.getString("keyword");
        return JsonResult.ok(blogService.getSearchList(keyword));
    }

    @RequestMapping("/page/{pageNum}")
    public JsonResult<List<BlogList>> page(@PathVariable("pageNum") Integer pageNum) {
        Page<BlogList> page = new Page<>(pageNum, 6);
        return JsonResult.ok(blogService.selectBloglist(page));
    }

}

