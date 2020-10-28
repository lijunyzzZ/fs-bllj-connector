package com.bllj2.query.controller;

import java.util.List;

import com.bllj2.query.http.ResponseResult;
import com.bllj2.query.info.SaveSignPictureArgs;
import com.bllj2.query.utils.ResponseResultUtils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 *
 * @author lijuny
 * @date 2020/10/28
 */
@RestController
public class SaveController {
	@PostMapping("/signPicture/save")
	public ResponseResult<?> saveSignPicture(SaveSignPictureArgs args) {
		return ResponseResultUtils.success();
	}

	@PostMapping("/integrals/batchSave")
	public ResponseResult<?> batchSave(@RequestPart("file") List<MultipartFile> uploadFiles,
	                                   @RequestParam("isContractSign") Boolean isContractSign,
	                                   @RequestParam("signerId") String signerId,
	                                   @RequestParam("contractNumber") String contractNumber
	) {

		return ResponseResultUtils.success();
	}
}
