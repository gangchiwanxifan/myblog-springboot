package myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.Favorite;
import myblog.entity.Notice;
import myblog.service.FavoriteService;
import myblog.service.NoticeService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;

    @Resource
    private NoticeService noticeService;

    @RequestMapping("/add")
    public JsonResult<Boolean> add(@RequestBody Favorite favorite) {
        Favorite one = favoriteService.check(favorite);
        if (one != null) {
            return JsonResult.ok(favoriteService.updateById(one));
        } else {
            Notice notice = new Notice();
            notice.setEvent(1);
            notice.setNoticeBlogId(favorite.getFavoriteBlogId());
            notice.setNoticeSendId(favorite.getFavoriteUserId());
            noticeService.sendNotice(notice);
            return JsonResult.ok(favoriteService.save(favorite));
        }
    }

    @RequestMapping("/cancel")
    public JsonResult<Boolean> cancel(@RequestBody Favorite favorite) {
        QueryWrapper<Favorite> wrapper = new QueryWrapper<>();
        wrapper.eq("favorite_user_id", favorite.getFavoriteUserId())
                .eq("favorite_blog_id", favorite.getFavoriteBlogId());
        return JsonResult.ok(favoriteService.remove(wrapper));
    }

    @RequestMapping("/check")
    public JsonResult<Boolean> exist(@RequestBody Favorite favorite) {
        Favorite one = favoriteService.check(favorite);
        if (one != null) {
            return JsonResult.ok(true);
        } else {
            return JsonResult.ok(false);
        }
    }
}

