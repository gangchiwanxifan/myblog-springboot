package myblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import myblog.entity.Notice;
import myblog.entity.NoticeInfo;
import myblog.mapper.BlogMapper;
import myblog.mapper.CommentMapper;
import myblog.mapper.NoticeMapper;
import myblog.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-21
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Integer sendNotice(Notice notice) {
        int flag = 0;
        switch (notice.getEvent()){
            case 0 :
                QueryWrapper<Notice> wrapper0 = new QueryWrapper<>();
                wrapper0.eq("notice_user_id", notice.getNoticeUserId())
                        .eq("notice_send_id", notice.getNoticeSendId())
                        .eq("event", 0);
                Notice one0 = noticeMapper.selectOne(wrapper0);
                if (one0 != null) {
                    one0.setNoticeStatus(0);
                    flag = noticeMapper.updateById(one0);
                } else {
                    flag = noticeMapper.insert(notice);
                }
                break;
            case 1 :
                QueryWrapper<Notice> wrapper1 = new QueryWrapper<>();
                Integer authorId = blogMapper.getAuthorId(notice.getNoticeBlogId());
                notice.setNoticeUserId(authorId);
                wrapper1.eq("notice_user_id", notice.getNoticeUserId())
                        .eq("notice_send_id", notice.getNoticeSendId())
                        .eq("notice_blog_id", notice.getNoticeBlogId())
                        .eq("event", 1);
                Notice one1 = noticeMapper.selectOne(wrapper1);
                if (one1 != null) {
                    one1.setNoticeStatus(0);
                    flag = noticeMapper.updateById(one1);
                } else {
                    flag = noticeMapper.insert(notice);
                }
                break;
            case 2 :
                QueryWrapper<Notice> wrapper2 = new QueryWrapper<>();
                notice.setNoticeUserId(blogMapper.getAuthorId(notice.getNoticeBlogId()));
                wrapper2.eq("notice_user_id", notice.getNoticeUserId())
                        .eq("notice_send_id", notice.getNoticeSendId())
                        .eq("notice_blog_id", notice.getNoticeBlogId())
                        .eq("event", 2);
                Notice one2 = noticeMapper.selectOne(wrapper2);
                if (one2 != null) {
                    one2.setNoticeStatus(0);
                    flag = noticeMapper.updateById(one2);
                } else {
                    flag = noticeMapper.insert(notice);
                }
                break;
            case 3 :
                QueryWrapper<Notice> wrapper3 = new QueryWrapper<>();
                notice.setNoticeUserId(commentMapper.getAuthorId(notice.getNoticeUserId()));
                wrapper3.eq("notice_user_id", notice.getNoticeUserId())
                        .eq("notice_send_id", notice.getNoticeSendId())
                        .eq("notice_blog_id", notice.getNoticeBlogId())
                        .eq("event", 3);
                Notice one3 = noticeMapper.selectOne(wrapper3);
                if (one3 != null) {
                    one3.setNoticeStatus(0);
                    flag = noticeMapper.updateById(one3);
                } else {
                    flag = noticeMapper.insert(notice);
                }
                break;
            case 4 :
                QueryWrapper<Notice> wrapper4 = new QueryWrapper<>();
                wrapper4.eq("notice_user_id", notice.getNoticeUserId())
                        .eq("notice_send_id", notice.getNoticeSendId())
                        .eq("notice_blog_id", notice.getNoticeBlogId())
                        .eq("event", 4);
                Notice one4 = noticeMapper.selectOne(wrapper4);
                if (one4 != null) {
                    one4.setNoticeStatus(0);
                    flag = noticeMapper.updateById(one4);
                } else {
                    flag = noticeMapper.insert(notice);
                }
                break;
            default:
                break;
        }
        return flag;
    }

    @Override
    public List<NoticeInfo> getNotice(Notice notice) {
        List<NoticeInfo> noticeList = noticeMapper.getNoticeList(notice);
        for (NoticeInfo item : noticeList) {
            if (item.getEvent() != 0) {
                item.setBlogTitle(blogMapper.getBlogTitle(item.getNoticeBlogId()));
            }
        }
        return noticeList;
    }
}
