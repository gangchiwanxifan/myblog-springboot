package myblog.controller;


import myblog.entity.Config;
import myblog.mapper.ConfigMapper;
import myblog.service.ConfigService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

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
    @Resource
    private ConfigMapper configMapper;

    @RequestMapping("/config")
    private JsonResult<Config> getConfig() {
        return JsonResult.ok(configService.getById(1));
    }

    @RequestMapping("/config/update")
    private JsonResult<Boolean> updateConfig(@RequestBody Config config) {
        return JsonResult.ok(configService.updateById(config));
    }
    @RequestMapping("/config/info")
    private JsonResult<Map<String, Integer>> getInfo() {
        return JsonResult.ok(configMapper.getInfo());
    }


}

