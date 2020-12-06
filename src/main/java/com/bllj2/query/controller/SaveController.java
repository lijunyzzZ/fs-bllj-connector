package com.bllj2.query.controller;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.bllj2.query.http.ResponseResult;
import com.bllj2.query.info.SavePointArgs;
import com.bllj2.query.info.SaveSignPictureArgs;
import com.bllj2.query.service.SaveService;
import com.bllj2.query.utils.ResponseResultUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author lijuny
 * @date 2020/10/28
 */
@RestController
@Slf4j
public class SaveController {

	private final SaveService saveService;

	public SaveController(SaveService saveService) {
		this.saveService = saveService;
	}

	@PostMapping("/points/save")
	public ResponseResult<?> batchSave(@Valid @RequestBody SavePointArgs args) {
		log.info("/points/save, {}", args );
		saveService.savePoint(args);
		return ResponseResultUtils.success();
	}


	@PostMapping("/signPicture/save")
	public ResponseResult<?> saveSignPicture(@Valid @RequestBody SaveSignPictureArgs args, HttpServletResponse response
	) {
		log.info("/signPicture/save, {}", args );
		saveService.saveSignPicture(args);
		return ResponseResultUtils.success();
	}
}
