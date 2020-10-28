package com.bllj2.query.controller;

import com.bllj2.query.http.ResponseResult;
import com.bllj2.query.utils.ResponseResultUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 *
 * @author lijuny
 */
@RestController
public class ContractsQueryController {

	@GetMapping("/contracts/findBypage")
	private ResponseResult<?>  contractsFindBypage() {
		return ResponseResultUtils.error("错误");
	}

}
