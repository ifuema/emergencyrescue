package team.ghjly.emergencyrescue.config;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.ghjly.emergencyrescue.entity.ResultCode;
import team.ghjly.emergencyrescue.vo.ResultVO;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<>(ResultCode.FORMAT_FAILED, objectError.getDefaultMessage());
    }
}
