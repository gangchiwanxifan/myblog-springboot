package myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import myblog.entity.HomePage;
import myblog.entity.User;
import myblog.service.HomePageService;
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
@RequestMapping("/homepage")
public class HomePageController {

    @Resource
    private HomePageService homePageService;

    @RequestMapping("/get")
    public JsonResult<HomePage> get(@RequestBody User user) {
        System.out.println("===========");
        System.out.println(user);
        Integer userId = user.getUserId();
        QueryWrapper<HomePage> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        HomePage one = homePageService.getOne(wrapper);
        if (one != null) {
            return JsonResult.ok(one);
        } else {
            HomePage homePage = new HomePage();
            homePage.setUserId(userId);
            homePageService.save(homePage);
            return JsonResult.ok(homePage);
        }
    }

    @RequestMapping("/update")
    public JsonResult<Boolean> update(@RequestBody HomePage homePage) {
        QueryWrapper<HomePage> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", homePage.getUserId());
        return JsonResult.ok(homePageService.update(homePage, wrapper));
    }

}

