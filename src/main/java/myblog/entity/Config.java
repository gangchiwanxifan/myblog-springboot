package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "config_id", type = IdType.AUTO)
    private Integer configId;

    /**
     * 轮播图1
     */
    private String swiper1;

    /**
     * 轮播图2
     */
    private String swiper2;

    /**
     * 公告
     */
    private String notice;

    /**
     * 底部copyright
     */
    private String copyright;

    /**
     * 备案号
     */
    private String record;


}
