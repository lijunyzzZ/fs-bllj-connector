package com.bllj2.query.controller;

import java.util.List;

import com.bllj2.query.exception.BaseException;
import com.bllj2.query.http.ResponseResult;
import com.bllj2.query.info.PageResult;
import com.bllj2.query.info.QueryPageArgs;
import com.bllj2.query.info.page.ContractDiscountInfo;
import com.bllj2.query.info.page.ContractResultInfo;
import com.bllj2.query.service.QueryService;
import com.bllj2.query.utils.ResponseResultUtils;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 *
 * @author lijuny
 */
@RestController
@Slf4j
public class ContractsQueryController {
	private final QueryService queryService;

	public ContractsQueryController(QueryService queryService) {
		this.queryService = queryService;
	}

	@GetMapping("/contracts/findBypage")
	private ResponseResult<?>  contractsFindBypage(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
	                                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
	                                               @RequestParam(defaultValue = "0", value = "startTime") Long startTime,
	                                               @RequestParam(required = false, value = "endTime") Long endTime,
	                                               @RequestParam(required = false, value = "accountNo") String accountNo,
	                                               @RequestParam(required = false, value = "poNo") String poNo) {
		if (endTime == null) {
			endTime = Long.MAX_VALUE;
		}
		QueryPageArgs args = new QueryPageArgs(pageNum, pageSize, startTime, endTime, accountNo, poNo, null);
		log.info("/contracts/findBypage,{}", args);
		int total = queryService.queryContractCount(args);
		int totalPage = total % args.getPageSize() == 0 ? total / args.getPageSize() : total / args.getPageSize() + 1;
		if (totalPage < args.getPageNum() - 1 && totalPage != 0) {
			throw new BaseException("pageNum大于总页数");
		}
		List<ContractResultInfo> result = queryService.queryContracts(args);
		PageResult<ContractResultInfo> pageResult = PageResult.create(args, result);
		pageResult.setTotal(total);
		pageResult.setTotalPage(totalPage);
		pageResult.setLastPage(args.getPageNum() >= totalPage);
		return ResponseResultUtils.success(pageResult);
	}

}
