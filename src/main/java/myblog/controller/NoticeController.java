package myblog.controller;


import myblog.entity.Notice;
import myblog.entity.NoticeInfo;
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

}

