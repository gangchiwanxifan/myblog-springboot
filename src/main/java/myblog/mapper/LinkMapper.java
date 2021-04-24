package myblog.mapper;

import myblog.entity.Link;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-24
 */
public interface LinkMapper extends BaseMapper<Link> {

    /**
     * 添加链接
     * @param link
     * @return
     */
    @Insert("insert into link(link_name, link_url) values (#{linkName}, #{linkUrl})")
    Integer insertLink(Link link);
}
