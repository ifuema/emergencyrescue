package team.ghjly.emergencyrescue.entity;

public enum ResultCode {
    /**
     * 请求成功
     */
    SUCCESS(1001),
    /**
     * 未知错误
     */
    UNKNOWN_FAILED(2001),
    /**
     * 参数格式错误
     */
    FORMAT_FAILED(2002),
    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(2003);


    private int code;


    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
