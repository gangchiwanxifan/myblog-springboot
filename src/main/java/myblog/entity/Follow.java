package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2021-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private Integer followFollowId;

    /**
     * 关注时间
     */
    private LocalDateTime createTime;


}
