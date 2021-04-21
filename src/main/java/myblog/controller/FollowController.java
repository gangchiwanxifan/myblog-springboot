package myblog.controller;


import myblog.entity.Follow;
import myblog.entity.FollowList;
import myblog.entity.Notice;
import myblog.service.FollowService;
import myblog.service.NoticeService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-15
 */
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Resource
    private FollowService followService;

    @Resource
    private NoticeService noticeService;

    @RequestMapping("/check")
    public JsonResult<Boolean> check(@RequestBody Follow follow) {
        Follow check = followService.check(follow);
        if (check!= null) {
            return JsonResult.ok(true);
        } else {
            return JsonResult.ok(false);
        }
    }

    @RequestMapping("/add")
    public JsonResult<Boolean> add(@RequestBody Follow follow) {
        Follow check = followService.check(follow);
        if (check!= null) {
            return JsonResult.ok(followService.updateById(check));
        } else {
            Notice notice = new Notice();
            notice.setEvent(0);
            notice.setNoticeUserId(follow.getFollowUserId());
            notice.setNoticeSendId(follow.getFollowFanId());
            noticeService.sendNotice(notice);
            return JsonResult.ok(followService.save(follow));
        }
    }

    @RequestMapping("/cancel")
    public JsonResult<Boolean> cancel(@RequestBody Follow follow) {
        Follow check = followService.check(follow);
        return JsonResult.ok(followService.removeById(check.getFollowId()));
    }

    @RequestMapping("/follows")
    public JsonResult<List<FollowList>> followList(@RequestBody Follow follow) {
        return JsonResult.ok(followService.getFollowList(follow));
    }

    @RequestMapping("/fans")
    public JsonResult<List<FollowList>> fanList(@RequestBody Follow follow) {
        return JsonResult.ok(followService.getFanList(follow));
    }
}

