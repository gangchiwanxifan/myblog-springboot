package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gcwxf
 * Created on 2021/4/18 - 15:42
 */
@Data
public class FollowList {

    /**
     * 主键id
     */
    @TableId(value = "follow_id", type = IdType.AUTO)
    private Integer followId;

    /**
     * 被关注的id
     */
    private Integer followUserId;

    /**
     * 关注人id
     */
    private Integer followFanId;

    /**
     * 关注时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 头像
     */
    private String avatar;


    /**
     * 昵称
     */
    private String nickname;

    /**
     * 简介
     */
    private String introduction;

}
