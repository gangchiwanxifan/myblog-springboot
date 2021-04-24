package myblog.service.impl;

import myblog.entity.Link;
import myblog.mapper.LinkMapper;
import myblog.service.LinkService;
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
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

}
