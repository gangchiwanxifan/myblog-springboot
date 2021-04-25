package myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import myblog.entity.Config;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-24
 */
public interface ConfigMapper extends BaseMapper<Config> {

    /**
     * 获取统计信息
     * @return
     */
    Map<String, Integer> getInfo();

}
