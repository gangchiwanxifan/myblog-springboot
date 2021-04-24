package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "link_id", type = IdType.AUTO)
    private Integer linkId;

    /**
     * 链接名
     */
    private String linkName;

    /**
     * 链接地址
     */
    private String linkUrl;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDeleted;


}
