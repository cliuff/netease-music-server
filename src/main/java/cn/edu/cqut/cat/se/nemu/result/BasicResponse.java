package cn.edu.cqut.cat.se.nemu.result;

/**
 * 响应的实体对象
 */
public class BasicResponse {

    /**
     * 响应的状态码
     */
    private String code = "0";

    /**
     * 响应的消息
     */
    private String msg = "success";

    public BasicResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BasicResponse() {
    }

    public BasicResponse(ResponseMessage message) {
        this.code = message.getCode();
        this.msg = message.getMsg();
    }

    public BasicResponse(String code) {
        this.code = code;
        this.msg = "";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
