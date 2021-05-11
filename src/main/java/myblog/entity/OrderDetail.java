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
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 用户id
     */
    private Integer orderUserId;

    /**
     * 被打赏用户id
     */
    private Integer orderTargetId;

    /**
     * 支付金额
     */
    private Integer orderPrice;

    /**
     * 支付时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 类型
     */
    private Integer orderType;

    /**
     * 打赏人用户名
     */
    private String orderUserName;

    /**
     * 被打赏用户名
     */
    private String orderTargetName;

    /**
     * 打赏文章
     */
    private Integer orderBlogId;

    /**
     * 打赏文章标题
     */
    private String orderBlogTitle;

    /**
     * 订单核对的时间戳
     */
    private String orderCheckId;

    /**
     * 方式
     */
    private Integer orderMethod;


}
