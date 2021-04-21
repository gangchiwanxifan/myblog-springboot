package myblog.controller;


import myblog.entity.Comment;
import myblog.entity.Notice;
import myblog.service.CommentService;
import myblog.service.NoticeService;
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

    @Resource
    private NoticeService noticeService;


    @RequestMapping("/save")
    public JsonResult<Boolean> save(@RequestBody Comment comment) {
        Notice notice = new Notice();
        if (comment.getParentId() != null) {
            notice.setEvent(3);
            notice.setNoticeSendId(comment.getCommentUserId());
            notice.setNoticeBlogId(comment.getCommentBlogId());
            notice.setNoticeUserId(comment.getParentId());
        } else {
            notice.setEvent(2);
            notice.setNoticeSendId(comment.getCommentUserId());
            notice.setNoticeBlogId(comment.getCommentBlogId());
        }
        noticeService.sendNotice(notice);
        Boolean flag = commentService.save(comment);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/{blogId}")
    public JsonResult<List<Comment>> commentsByBlogId(@PathVariable("blogId") Integer blogId) {
        List<Comment> comments = commentService.getComments(blogId);
        return JsonResult.ok(comments);
    }

    @RequestMapping("/delete")
    public JsonResult<Integer> delete(@RequestBody Comment comment) {
        return JsonResult.ok(commentService.deleteComments(comment));
    }
}

