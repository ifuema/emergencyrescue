package team.ghjly.emergencyrescue.vo;

import team.ghjly.emergencyrescue.entity.ResultCode;

public class ResultVO<T> {
    // 状态码
    private int code;
    // 响应信息
    private String msg;
    // 响应的具体数据
    private T data;


    public ResultVO() {
        this(ResultCode.SUCCESS, "请求成功", null);
    }

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, "请求成功", data);
    }

    public ResultVO(ResultCode code, String msg) {
        this(code, msg, null);
    }

    public ResultVO(ResultCode code, String msg, T data) {
        this.code = code.getCode();
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
