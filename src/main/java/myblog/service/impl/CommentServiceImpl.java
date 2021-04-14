package myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Comment;
import myblog.mapper.CommentMapper;
import myblog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getComments(Integer blogId) {
        List<Comment> allComments = commentMapper.selectComment(blogId);
        Map<Integer, Comment> map = new HashMap<>();
        List<Comment> result = new ArrayList<>();
        for (Comment c : allComments) {
            if (c.getParentId() == null) {
                result.add(c);
            }
            map.put(c.getCommentId(), c);
        }
        for (Comment c : allComments) {
            if (c.getParentId() != null) {
                Comment parent = map.get(c.getParentId());
                if (parent.getChild() == null) {
                    parent.setChild(new ArrayList<>());
                }
                parent.getChild().add(c);
            }
        }
        return result;
    }
}