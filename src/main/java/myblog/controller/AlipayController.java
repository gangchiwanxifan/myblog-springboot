package myblog.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import myblog.service.AlipayService;
import myblog.service.OrderDetailService;
import myblog.vo.PayVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author gcwxf
 * Created on 2021/4/29 - 16:05
 */

@Log4j2
@Controller
public class AlipayController {

    @Resource
    private AlipayService alipayService;

    @Resource
    private OrderDetailService orderDetailService;

    @RequestMapping("/alipay/pay")
    @ResponseBody
    public byte[] alipay(@RequestBody PayVo payVo){
        return alipayService.alipay(payVo);
    }


    /**
     * 支付回调的地址
     */
    @ResponseBody
    @RequestMapping("/alipay/notifyUrl")
    public String notifyUrl(HttpServletRequest request) throws Exception {
        boolean result = alipayCallback(request);
        if (result) {
            return "success";
        } else {
            return "fail";
        }
    }


    private boolean alipayCallback(HttpServletRequest request) throws UnsupportedEncodingException {
        // 1:获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, new String(valueStr.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        }
        //2：计算得出通知验证结果
        log.info("1：---->获取支付宝回传的参数---------------------------------->" + params);
        // 返回公共参数
        String tradeno = params.get("trade_no");
        //支付返回的请求参数body
        String bodyJson = params.get("body");
        log.info("3---->:【支付宝】交易的参数信息是：{}，流水号是：{}", bodyJson, tradeno);
        try {
            JSONObject bodyJsonObject = JSONObject.parseObject(bodyJson);
            System.out.println("==================");
            System.out.println(bodyJsonObject);
            // 支付成功，保存的订单交易明细
            Integer orderType = bodyJsonObject.getInteger("orderType");
            if (orderType == 0) {
                orderDetailService.callBackSave(bodyJsonObject);
            } else if(orderType == 1) {
                orderDetailService.callBackReCharge(bodyJsonObject);
            }


        } catch (Exception ex) {
            log.info("支付宝支付出现了异常.....");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
