package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 所属文章id
     */
    private Integer commentBlogId;

    /**
     * 评论人id
     */
    private Integer commentUserId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 父级评论id
     */
    private Integer parentId;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDeleted;

    /*添加字段*/

    /**
     * 评论人名称
     */
    private String nickname;

    /**
     * 评论人头像
     */
    private String avatar;

    /**
     * 子评论
     */
    private List<Comment> child;


}
