package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 所属栏目
     */
    private Integer blogChannelId;

    /**
     * 所属文集
     */
    private Integer blogCatagoryId;

    /**
     * 文章内容
     */
    private String blogContent;

    /**
     * 文章标签
     */
    private String blogTags;

    /**
     * 封面图片
     */
    private String blogAvatar;

    /**
     * 是否草稿
     */
    private Integer blogStatus;

    /**
     * 浏览量
     */
    private Integer blogViews;

    /**
     * 文章描述
     */
    private String blogDescription;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDeleted;


}
