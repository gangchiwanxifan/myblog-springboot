package myblog.controller;


import com.alibaba.fastjson.JSONObject;
import myblog.entity.Channel;
import myblog.service.ChannelService;
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
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Resource
    ChannelService channelService;

    @RequestMapping("/list")
    public JsonResult<List<Channel>> list() {
        List<Channel> list = channelService.list();
        return JsonResult.ok(list);
    }

    @RequestMapping("/save")
    public JsonResult<Boolean> save(@RequestBody Channel channel) {
        Boolean flag = channelService.save(channel);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/delete")
    public JsonResult<Boolean> delete(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer id=jsonObject.getInteger("id");
        Boolean flag = channelService.removeById(id);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/update")
    public JsonResult<Boolean> update(@RequestBody Channel channel) {
        boolean flag = channelService.updateById(channel);
        return JsonResult.ok(flag);
    }
}

