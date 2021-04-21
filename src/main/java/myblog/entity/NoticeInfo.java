package myblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gcwxf
 * Created on 2021/4/21 - 22:06
 */
@Data
public class NoticeInfo {

    /**
     * 通知id
     */
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

    /**
     * 发送用户昵称
     */
    private String nickname;

    /**
     * 发送用户头像
     */
    private String avatar;

    /**
     * 文章标题
     */
    private String blogTitle;

}
