package cn.shop.mall.admin.config;

import cn.shop.mall.common.exception.BizException;
import cn.shop.mall.common.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseVO bizExceptionHandler(HttpServletRequest req, BizException e) {
        logger.error(e.getMsg(), e);
        return ResponseVO.FAIL(e.getCode(), e.getMsg());
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseVO.ERROR();
    }
}