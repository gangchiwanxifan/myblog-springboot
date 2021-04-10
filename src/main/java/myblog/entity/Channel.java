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
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 栏目id
     */
    @TableId(value = "channel_id", type = IdType.AUTO)
    private Integer channelId;

    /**
     * 栏目名称
     */
    private String channelName;

    /**
     * 栏目封面
     */
    private String channelAvatar;

    /**
     * 栏目描述
     */
    private String channelDescription;

    /**
     * 是否删除
     */
    private Integer isDeleted;


}
