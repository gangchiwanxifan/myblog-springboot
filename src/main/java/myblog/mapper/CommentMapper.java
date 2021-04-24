package myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import myblog.entity.Comment;
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

    /**
     * 获取评论列表
     * @param page
     * @return
     */
    List<Comment> selectList(Page<?> page);

    /**
     * 获取被举报列表
     * @return
     */
    List<Comment> selectReported(Page<?> page);

    /**
     * 获取子评论id列表
     * @param id
     * @return
     */
    @Select("select comment_id from comment where parent_id = #{id}")
    List<Integer> getChildren(Integer id);

}
