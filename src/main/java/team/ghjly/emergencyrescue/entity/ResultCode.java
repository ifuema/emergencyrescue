package team.ghjly.emergencyrescue.entity;

public enum ResultCode {
    /**
     * 请求成功
     */
    SUCCESS(1001),
    /**
     * 参数格式错误
     */
    FORMAT_FAILED(2001),
    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(3001);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
