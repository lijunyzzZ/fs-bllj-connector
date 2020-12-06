package com.bllj2.query.http;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 接口返回的结果信息
 * @author lijuny
 * @date 2020/10/27
 */
@Getter
@Setter
public class ResponseResult<T> {
	/**
	 * 请求是否成功
	 */
	private boolean success;
	/**
	 * 相应的状态码
	 */
	private int rtcode;
	/**
	 * 响应体的结果
	 */
	private T result;
}
