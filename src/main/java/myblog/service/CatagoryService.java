package myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.Catagory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-03-30
 */
public interface CatagoryService extends IService<Catagory> {

    /**
     * 获取用户文集
     * @param userId
     * @return
     */
    List<Catagory> getListByUserId(Integer userId);

}
