package myblog.service.impl;

import myblog.entity.Config;
import myblog.mapper.ConfigMapper;
import myblog.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-24
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
