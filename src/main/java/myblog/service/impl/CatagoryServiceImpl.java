package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Catagory;
import myblog.mapper.CatagoryMapper;
import myblog.service.CatagoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
@Service
public class CatagoryServiceImpl extends ServiceImpl<CatagoryMapper, Catagory> implements CatagoryService {

    @Resource
    private CatagoryMapper catagoryMapper;

    @Override
    public List<Catagory> getListByUserId(Integer userId) {
        QueryWrapper<Catagory> wrapper = new QueryWrapper<>();
        wrapper.eq("catagory_user_id", userId);
        return catagoryMapper.selectList(wrapper);
    }

}
