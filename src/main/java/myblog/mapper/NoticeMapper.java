package myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import myblog.entity.Notice;
import myblog.entity.NoticeInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-21
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 获取消息列表
     * @param notice
     * @return
     */
    @Select("select notice.*, nickname, avatar from notice, user where notice_send_id = user_id and notice_user_id = #{noticeUserId} and notice_status = #{noticeStatus} order by create_time desc")
    List<NoticeInfo> getNoticeList(Notice notice);
}
