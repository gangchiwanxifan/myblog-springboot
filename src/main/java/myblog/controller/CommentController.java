package myblog.controller;


import myblog.entity.Comment;
import myblog.service.CommentService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @since 2021-04-12
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/save")
    public JsonResult<Boolean> save(@RequestBody Comment comment) {
        Boolean flag = commentService.save(comment);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/{blogId}")
    public JsonResult<List<Comment>> commentsByBlogId(@PathVariable("blogId") Integer blogId) {
        List<Comment> comments = commentService.getComments(blogId);
        return JsonResult.ok(comments);
    }
}

