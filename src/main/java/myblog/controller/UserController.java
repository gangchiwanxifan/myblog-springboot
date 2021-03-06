package myblog.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.User;
import myblog.service.UserService;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/get_user")
    public JsonResult<User> getUser(@RequestBody String condition){
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        Integer id=jsonObject.getInteger("id");
        User user=userService.selectById(id);
        return JsonResult.ok(user);
    }

    @PostMapping("/login")
    public JsonResult<User> login(@RequestBody User user) {
        return JsonResult.ok(userService.login(user));
    }

    @PostMapping("/register")
    public JsonResult<Integer> register(@RequestBody User user) {
        return JsonResult.ok(userService.register(user));
    }

    @RequestMapping("/update")
    public JsonResult<Boolean> update(@RequestBody User user) { return  JsonResult.ok(userService.updateById(user)); }

    @RequestMapping("/pay")
    public JsonResult<Boolean> pay(@RequestBody User user) {
        User realUser = userService.selectById(user.getUserId());
        realUser.setBalance(realUser.getBalance() + user.getBalance());
        return JsonResult.ok(userService.updateById(realUser));
    }

    @RequestMapping("/reward")
    public JsonResult<Boolean> reward(@RequestBody Map<String, User> map) {
        return JsonResult.ok(userService.reward(map));
    }

    @RequestMapping("/list")
    public JsonResult<List<User>> list() {
        return JsonResult.ok(userService.list());
    }

    @RequestMapping("/search")
    public JsonResult<List<User>> search(@RequestBody String condition) {
        JSONObject jsonObject= (JSONObject) JSONObject.parse(condition);
        String keyword=jsonObject.getString("keyword");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", keyword)
                .or().like("nickname", keyword);
        return JsonResult.ok(userService.list(wrapper));
    }
}

