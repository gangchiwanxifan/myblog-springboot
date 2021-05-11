package myblog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gcwxf
 * Created on 2021/4/29 - 15:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PayVo {

    private Integer userId;

    private Integer targetId;

    private Integer price;

    private Integer orderType;

    private Integer blogId;

    private String timestamp;

    private Integer orderMethod;
}
