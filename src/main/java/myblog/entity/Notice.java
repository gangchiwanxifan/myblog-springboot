package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知id
     */
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    /**
     * 通知类型
     */
    private Integer event;

    /**
     * 接受用户id
     */
    private Integer noticeUserId;

    /**
     * 发送用户id
     */
    private Integer noticeSendId;

    /**
     * 是否已读
     */
    private Integer noticeStatus;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 目标博客id
     */
    private Integer noticeBlogId;

    // /**
    //  * 发送用户昵称
    //  */
    // private String nickname;
    //
    // /**
    //  * 发送用户头像
    //  */
    // private String avatar;
    //
    // /**
    //  * 文章标题
    //  */
    // private String blogTitle;

}
