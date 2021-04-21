package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Favorite;
import myblog.mapper.FavoriteMapper;
import myblog.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private FavoriteMapper favoriteMapper;

    @Override
    public Favorite check(Favorite favorite) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("favorite_user_id", favorite.getFavoriteUserId())
                .eq("favorite_blog_id", favorite.getFavoriteBlogId());
        return favoriteMapper.selectOne(wrapper);
    }
}
