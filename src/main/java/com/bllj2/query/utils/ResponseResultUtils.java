package com.bllj2.query.utils;

import com.bllj2.query.http.ResponseResult;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 * 创建响应的工具类。
 * @author lijuny
 */
public class ResponseResultUtils {

	public static ResponseResult<String> error(String errorMessage) {
		ResponseResult<String> objectResponseResult = new ResponseResult<>();
		objectResponseResult.setCode(-100);
		objectResponseResult.setSuccess(false);
		objectResponseResult.setResult(errorMessage);
		return objectResponseResult;
	}

	public static <T> ResponseResult<T> success(T result) {
		ResponseResult<T> objectResponseResult = new ResponseResult<>();
		objectResponseResult.setCode(200);
		objectResponseResult.setSuccess(true);
		objectResponseResult.setResult(result);
		return objectResponseResult;
	}

	public static ResponseResult<String> success() {
		ResponseResult<String> objectResponseResult = new ResponseResult<>();
		objectResponseResult.setCode(200);
		objectResponseResult.setSuccess(true);
		objectResponseResult.setResult("保存成功");
		return objectResponseResult;
	}
}
