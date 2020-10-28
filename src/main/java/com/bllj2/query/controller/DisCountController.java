package com.bllj2.query.controller;

import com.bllj2.query.http.ResponseResult;
import com.bllj2.query.utils.ResponseResultUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 *
 * @author lijuny
 */
@RestController
public class DisCountController {


	@GetMapping("/discounts/findByPage")
	private ResponseResult<?> discountsFindByPage() {
		return ResponseResultUtils.error("错误");
	}
}
