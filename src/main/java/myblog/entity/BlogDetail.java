package myblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gcwxf
 * Created on 2021/4/11 - 17:31
 */

@Data
public class BlogDetail {

    /**
     * 文章id
     */
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
     * 文章内容
     */
    private String blogContent;

    /**
     * 文章标签
     */
    private String blogTags;

    /**
     * 浏览量
     */
    private Integer blogViews;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 作者用户名
     */
    private String nickname;

    /**
     * 作者头像
     */
    private String avatar;

    /**
     * 作者描述
     */
    private String introduction;

    /**
     * 栏目名称
     */
    private String channelName;

}
