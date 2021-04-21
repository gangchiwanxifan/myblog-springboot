package myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.User;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-26
 */
public interface UserService extends IService<User> {

    /**
     * 查询用户
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 登录
     * @param user
     * @return
     */
    Integer login(User user);

    /**
     * 注册
     * @param user
     * @return 1|0
     */
    Integer register(User user);

    /**
     * 打赏
     * @param map
     * @return
     */
    Boolean reward(Map<String, User> map);



}
