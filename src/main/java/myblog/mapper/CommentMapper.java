package myblog.mapper;

import myblog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
