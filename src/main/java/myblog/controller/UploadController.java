package myblog.controller;

import myblog.utils.JsonResult;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author gcwxf
 * Created on 2021/3/30 - 14:18
 */

@RestController
@RequestMapping("/api2")
public class UploadController {
    @RequestMapping("/upload")
    public JsonResult<String> upload(MultipartFile file) throws IOException {
        String headUrl;
        if (file == null) {
            headUrl = null;
        } else{
            // 生成一个唯一标识符给图片命名，避免图片名重复，覆盖原有图片
            String imageName = UUID.randomUUID().toString().replaceAll("-", "");
            // 文件的扩展名
            // img.getOriginalFilename() 是上传图片的原始名字
            String ext = FilenameUtils.getExtension(file.getOriginalFilename());
            // 将文件存到服务器里指定的文件
            String path = "/image/";
            // 存到数据库的路径（绝对路径）
            //image.transferTo(new File(path + imageName + "." + ext));
            //System.out.println(request.getRealPath(path + imageName + "." + ext));

            file.transferTo(new File("E:" + path + imageName + "." + ext));
//			image.transferTo(new File(path));
//             headUrl ="http://120.79.1.207:8080" + path + imageName + "." + ext;
            headUrl = "http://127.0.0.1:9100" + path + imageName + "." + ext;
        }
        return JsonResult.ok(headUrl);
    }
}
