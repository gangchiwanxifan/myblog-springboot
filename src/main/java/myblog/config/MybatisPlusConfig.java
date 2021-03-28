package myblog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gcwxf
 * Created on 2021/3/28 - 16:14
 */

@MapperScan("myblog.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

}
