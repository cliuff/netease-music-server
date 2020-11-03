package cn.edu.cqut.cat.se.nemu.result;

/**
 * 响应的枚举类型
 */
public enum ResponseMessage {

    SUCCESS("200", "操作成功"),
    FAILURE("999999", "操作失败"),
    PARAM_ERROR("000001", "参数错误"),
    DATA_NULL("00543","无数据"),
    FILE_EMPTY("000400", "文件为空"),
    LIMIT_PICTURE_SIZE("000401", "图片大小不能超过2M"),
    LIMIT_PICTURE_TYPE("000402", "图片类型必须为jpg，png，jpeg");

    private String code;
    private String msg;

    ResponseMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
