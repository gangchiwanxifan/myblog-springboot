package myblog.mapper;

import myblog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-26
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     * id获取用户名
     * @param userId
     * @return
     */
    @Select("select nickname from user where user_id = #{userId}")
    String getNickname(Integer userId);

}
