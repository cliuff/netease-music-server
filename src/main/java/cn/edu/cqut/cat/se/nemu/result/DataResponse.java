package cn.edu.cqut.cat.se.nemu.result;

import java.util.List;

/**
 * 封装响应的数据
 */
public class DataResponse extends BasicResponse {

    private Object data;
    private Long count;


    public DataResponse() {
    }

    public DataResponse(String code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public DataResponse(Object data, Long count) {
        this.data = data;
        this.count = count;
    }

    public DataResponse(Object data) {
        this.data = data;
    }

    public DataResponse(ResponseMessage message) {
        super(message);
    }

    public DataResponse(ResponseMessage message, Object data) {
        super(message);
        this.data = data;
    }
    public DataResponse(ResponseMessage message, Object data,Long count) {
        super(message);
        this.data = data;
        this.count = count;

    }

    public DataResponse(String code, Object data) {
        super(code);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public DataResponse setDataList(List<?> data) {
        this.data = data;
        this.count = (long) data.size();
        return this;
    }
}
