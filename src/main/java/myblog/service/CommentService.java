package myblog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import myblog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-12
 */
public interface CommentService extends IService<Comment> {

    /**
     * 获取文章评论
     * @param blogId
     * @return
     */
    List<Comment> getComments(Integer blogId);

    /**
     * 删除评论
     * @param comment
     * @return
     */
    Integer deleteComments(Comment comment);

    /**
     * 获取评论列表
     * @param page
     * @return
     */
    List<Comment> getCommentList(Page<?> page);

    /**
     * 获取被举报列表
     * @param page
     * @return
     */
    List<Comment> getReportedList(Page<?> page);

    /**
     * 根据id删除评论
     * @param commentId
     * @return
     */
    Integer deleteCommentById(Integer commentId);

}
