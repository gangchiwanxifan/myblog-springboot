package myblog.controller;


import myblog.entity.Link;
import myblog.service.LinkService;
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
 * @since 2021-04-24
 */
@RestController
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping("/link")
    public JsonResult<List<Link>> list() {
        return JsonResult.ok(linkService.list());
    }

    @RequestMapping("/link/save")
    public JsonResult<Boolean> saveLink(@RequestBody Link link) {
        return JsonResult.ok(linkService.save(link));
    }
    @RequestMapping("/link/update")
    public JsonResult<Boolean> update(@RequestBody Link link) {
        return JsonResult.ok(linkService.updateById(link));
    }

    @RequestMapping("/link/delete")
    public JsonResult<Boolean> delete(@RequestBody Link link) {
        return JsonResult.ok(linkService.removeById(link.getLinkId()));
    }

}

