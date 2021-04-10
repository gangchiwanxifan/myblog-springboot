package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author gcwxf
 * Created on 2021/4/10 - 19:03
 */
@Data
public class BlogList {
    /**
     * 文章id
     */
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Integer blogId;

    /**
     * 文章标题
     */
    private String blogTitle;

    /**
     * 文章作者
     */
    private Integer blogAuthorId;

    /**
     * 作者名称
     */
    private String nickname;

    /**
     * 文章标签
     */
    private String blogTags;

    /**
     * 封面图片
     */
    private String blogAvatar;

    /**
     * 文章描述
     */
    private String blogDescription;

    /**
     * 点赞数量
     */
    private Integer favoriteCount;

    /**
     * 评论数量
     */
    private Integer commentCount;

}
