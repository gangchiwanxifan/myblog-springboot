package myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.Notice;
import myblog.entity.NoticeInfo;
import myblog.service.NoticeService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @RequestMapping("/list")
    public JsonResult<List<NoticeInfo>> getNotice(@RequestBody Notice notice) {
        return JsonResult.ok(noticeService.getNotice(notice));
    }

    @RequestMapping("/update")
    public JsonResult<Boolean> hasCheck(@RequestBody Notice notice) {
        return JsonResult.ok(noticeService.updateById(notice));
    }

    @GetMapping("/new")
    public JsonResult<Integer> newCount(@RequestParam Integer userId) {
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.eq("notice_status", 0)
                .eq("notice_user_id", userId);
        return JsonResult.ok(noticeService.count(wrapper));

    }

}

