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
public class Catagory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文集id
     */
    @TableId(value = "catagory_id", type = IdType.AUTO)
    private Integer catagoryId;

    /**
     * 用户id
     */
    private Integer catagoryUserId;

    /**
     * 文集名称
     */
    private String catagoryName;

    /**
     * 文集图片
     */
    private String catagoryAvatar;

    /**
     * 文集描述
     */
    private String catagoryDescription;

    /**
     * 是否删除
     */
    private Integer isDeleted;


}
