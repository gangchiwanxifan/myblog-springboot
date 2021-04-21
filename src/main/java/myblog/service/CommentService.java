package myblog.service;

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
     * 获取文章评论并将其转化为树形结构
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

}
