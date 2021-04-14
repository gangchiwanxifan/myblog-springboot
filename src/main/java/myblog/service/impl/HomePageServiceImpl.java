package myblog.service.impl;

import myblog.entity.HomePage;
import myblog.mapper.HomePageMapper;
import myblog.service.HomePageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-14
 */
@Service
public class HomePageServiceImpl extends ServiceImpl<HomePageMapper, HomePage> implements HomePageService {

}
