package myblog.service;

import myblog.entity.Favorite;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-14
 */
public interface FavoriteService extends IService<Favorite> {

    /**
     * 是否收藏
     * @param favorite
     * @return
     */
    Favorite check(Favorite favorite);
}
