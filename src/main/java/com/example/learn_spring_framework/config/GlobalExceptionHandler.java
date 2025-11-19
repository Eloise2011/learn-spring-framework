package com.example.learn_spring_framework.config;

import com.example.learn_spring_framework.restful.dao.CustomizedErrorDetails;
import com.example.learn_spring_framework.restful.exception.NoUserFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Joshua.H.Brooks
 * @description 全局异常处理 根据项目开发进程 逐步丰富该代码
 * @date 2025-11-18 10:58
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<CustomizedErrorDetails> handleNoUserFoundException(Exception ex, WebRequest webRequest){
        System.out.println("Customizing error details before it's thrown ...");
        CustomizedErrorDetails customizedErrorDetails = new CustomizedErrorDetails(ex.getMessage(), LocalDateTime.now(), webRequest.getDescription(true));
        return new ResponseEntity<>(customizedErrorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        log.error("发生未处理异常: {}", request.getDescription(false), ex);

        // 返回统一的错误响应
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("error", ex.getClass().getSimpleName());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 处理特定的异常类型
    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleBadRequest(Exception ex) {
        log.warn("业务逻辑异常: {}", ex.getMessage());
        // 返回具体的错误信息
        return ResponseEntity.badRequest().body(Map.of(
                "error", "请求参数错误",
                "message", ex.getMessage()
        ));
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        System.out.println("Customizing error details before it's thrown ...");
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String errorString = IntStream.range(0, fieldErrors.size())
                .mapToObj(i -> {
                    FieldError error = fieldErrors.get(i);
                    return String.format("error %d: %s - %s", i + 1, error.getField(), error.getDefaultMessage());
                }).collect(Collectors.joining("<br/>"));
        CustomizedErrorDetails customizedErrorDetails = new CustomizedErrorDetails(errorString, LocalDateTime.now(), request.getDescription(true));
        return new ResponseEntity<Object>(customizedErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
