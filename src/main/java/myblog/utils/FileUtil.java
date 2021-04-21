package myblog.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author gcwxf
 * Created on 2021/4/20 - 20:31
 */
@Component
public class FileUtil {

    @Value("${custom.ftp.host}")
    String ftpHost;

    @Value("${custom.ftp.port}")
    Integer ftpPort;

    @Value("${custom.ftp.username}")
    String ftpUsername;

    @Value("${custom.ftp.password}")
    String ftpPassword;

    @Value("${custom.ftp.basepath}")
    String basePath;

    public String upload(InputStream inputStream, String originName) {

        StringBuilder url = new StringBuilder();

        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("utf-8");
        ftp.enterLocalPassiveMode(); // 开启被动模式

        try {
            ftp.connect(ftpHost, ftpPort);
            ftp.login(ftpUsername, ftpPassword);

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

            int reply = ftp.getReplyCode();
            System.out.println("reply:" + reply);

            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String ext = FilenameUtils.getExtension(originName);
            originName = uuid + "." + ext;
            url.append(originName);

            ftp.makeDirectory(basePath);
            ftp.changeWorkingDirectory(basePath);


            ftp.storeFile(originName, inputStream);
            inputStream.close();
            ftp.logout();

        } catch (IOException e) {
            throw new RuntimeException("文件上传失败");
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return url.toString();
    }

}
