package myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.Notice;
import myblog.entity.NoticeInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-21
 */
public interface NoticeService extends IService<Notice> {

    /**
     * 发送通知
     * @param notice
     * @return
     */
    Integer sendNotice(Notice notice);

    /**
     * 获取通知列表
     * @param notice
     * @return
     */
    List<NoticeInfo> getNotice(Notice notice);

}
