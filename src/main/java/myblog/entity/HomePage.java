package myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HomePage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "page_id", type = IdType.AUTO)
    private Integer pageId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 主页内容
     */
    private String pageContent;


}
