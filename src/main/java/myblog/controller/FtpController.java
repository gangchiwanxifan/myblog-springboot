package myblog.controller;

import myblog.utils.FileUtil;
import myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;


/**
 * @author gcwxf
 * Created on 2021/4/20 - 20:30
 */

@RestController
@RequestMapping("/common")
public class FtpController {

    @Resource
    FileUtil fileUtil;

    @PostMapping("/upload")
    public JsonResult<String> upload(MultipartFile file) throws IOException {
        String url = fileUtil.upload(file.getInputStream(), file.getOriginalFilename());
        return JsonResult.ok(url);
    }
}
