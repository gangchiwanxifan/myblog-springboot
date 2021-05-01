package myblog.service;

import myblog.vo.PayVo;

/**
 * @author gcwxf
 * Created on 2021/4/29 - 15:58
 */
public interface AlipayService {

    /**
     * 阿里支付接口
     * @param payVo
     * @return byte[]
     */
    byte[] alipay(PayVo payVo);
}
