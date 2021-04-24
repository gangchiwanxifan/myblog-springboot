package myblog.controller;


import myblog.entity.Config;
import myblog.service.ConfigService;
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
 * @since 2021-04-24
 */
@RestController
public class ConfigController {

    @Resource
    private ConfigService configService;

    @RequestMapping("/config")
    private JsonResult<Config> getConfig() {
        return JsonResult.ok(configService.getById(1));
    }

    @RequestMapping("/config/update")
    private JsonResult<Boolean> updateConfig(@RequestBody Config config) {
        return JsonResult.ok(configService.updateById(config));
    }

}

