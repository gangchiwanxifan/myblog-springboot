package myblog.utils;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author gcwxf
 * Created on 2021/3/4 - 22:30
 */
public class JsonResult<T> {
    @JSONField
    private int code = 0;
    @JSONField
    private String msg;
    @JSONField
    private T data;

    public JsonResult() {
        this.data = null;
    }

    public static <T> JsonResult<T> ok() {
        return new JsonResult<>();
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> result = ok();
        result.setData(data);
        return result;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public T getData() {
        return data;
    }

    public JsonResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}