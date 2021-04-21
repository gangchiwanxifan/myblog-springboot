package myblog.mapper;

import myblog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-12
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 获取文章评论
     * @param blogId
     * @return
     */
    List<Comment> selectComment(Integer blogId);

    /**
     * 获取评论人id
     * @param commentId
     * @return
     */
    @Select("select comment_user_id from comment where comment_id = #{commentId}")
    Integer getAuthorId(Integer commentId);

}
