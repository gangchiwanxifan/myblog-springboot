package myblog.controller;


import com.alibaba.fastjson.JSONObject;
import myblog.entity.Catagory;
import myblog.service.CatagoryService;
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
@RequestMapping("/catagory")
public class CatagoryController {

    @Resource
    private CatagoryService catagoryService;

    @RequestMapping("/list")
    public JsonResult<List<Catagory>> list(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer userId=jsonObject.getInteger("userId");
        return  JsonResult.ok(catagoryService.getListByUserId(userId));
    }

    @RequestMapping("/save")
    public JsonResult<Boolean> save(@RequestBody Catagory catagory) {
        Boolean flag = catagoryService.save(catagory);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/delete")
    public JsonResult<Boolean> delete(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer id=jsonObject.getInteger("id");
        Boolean flag = catagoryService.removeById(id);
        return JsonResult.ok(flag);
    }

    @RequestMapping("/update")
    public JsonResult<Boolean> update(@RequestBody Catagory catagory) {
        boolean flag = catagoryService.updateById(catagory);
        return JsonResult.ok(flag);
    }


}

