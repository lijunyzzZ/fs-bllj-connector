package com.bllj2.query.http;

import java.util.List;
import java.util.stream.Collectors;

import com.bllj2.query.exception.BaseException;
import com.bllj2.query.utils.ResponseResultUtils;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局的异常处理，用来校验参数抛异常的时候将异常规范成需要的信息
 *
 * @author lijuny
 * @date 2020/11/15
 */
@RestControllerAdvice("com.bllj2.query")
public class GlobalExceptionController {
	@ResponseStatus(HttpStatus.BAD_REQUEST) //设置状态码为 400
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseResult<String> paramExceptionHandler(MethodArgumentNotValidException e) {
		BindingResult exceptions = e.getBindingResult();
		if (exceptions.hasErrors()) {
			List<ObjectError> errors = exceptions.getAllErrors();
			if (!errors.isEmpty()) {
				return ResponseResultUtils.error(errors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(",")));
			}
		}
		return ResponseResultUtils.error("请求参数错误");
	}

	@ExceptionHandler(Throwable.class)
	public ResponseResult<String> globalExceptionHandler(Throwable throwable) {
		return ResponseResultUtils.error(throwable.getMessage());
	}

	@ExceptionHandler(BaseException.class)
	public ResponseResult<String> globalExceptionHandler(BaseException e) {
		return ResponseResultUtils.error(e.getMessage());
	}
}
