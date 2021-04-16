package myblog.service.impl;

import myblog.entity.Favorite;
import myblog.mapper.FavoriteMapper;
import myblog.service.FavoriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-14
 */
@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {

}
