package myblog.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author gcwxf
 * Created on 2021/4/29 - 15:53
 */

@Data
@Component
public class AlipayConfig {

    @Value("${alipay.app_id}")
    public  String app_id;

    @Value("${alipay.merchant_private_key}")
    public String merchant_private_key;

    @Value("${alipay.alipay_public_key}")
    public String alipay_public_key;

    @Value("${alipay.notify_url}")
    public  String notify_url;

    @Value("${alipay.return_url}")
    public  String return_url;

    @Value("${alipay.sign_type}")
    public  String sign_type;

    @Value("${alipay.charset}")
    public  String charset;

    @Value("${alipay.gatewayUrl}")
    public String gatewayUrl;

    @Value("${alipay.log_path}")
    public String log_path;

    @Override
    public String toString() {
        return "AlipayConfig{" +
                "app_id='" + app_id + '\'' +
                ", merchant_private_key='" + merchant_private_key + '\'' +
                ", alipay_public_key='" + alipay_public_key + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", return_url='" + return_url + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", charset='" + charset + '\'' +
                ", gatewayUrl='" + gatewayUrl + '\'' +
                ", log_path='" + log_path + '\'' +
                '}';
    }

}
