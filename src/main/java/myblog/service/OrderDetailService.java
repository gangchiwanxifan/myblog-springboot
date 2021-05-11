package myblog.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import myblog.entity.OrderDetail;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gcwxf
 * @since 2021-04-29
 */
public interface OrderDetailService extends IService<OrderDetail> {

    /**
     * 收到支付宝回调信息后保存打赏信息
     * @param jsonObject
     */
    void callBackSave(JSONObject jsonObject);

    /**
     * 收到支付宝回调信息后保存充值信息
     * @param jsonObject
     */
    void callBackReCharge(JSONObject jsonObject);

}
