package team.ghjly.emergencyrescue.vo;

public enum ResultCode {
    //请求成功
    SUCCESS(1001),
    //未知错误
    FAILED(2001),
    //参数格式校验失败
    FORMAT_FAILED(2002),
    //参数值校验失败
    VALIDATE_FAILED(2003),
    //无访问权限
    PERMISSION_REGECT(3001);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
