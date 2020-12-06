package com.bllj2.query.controller;

import java.util.List;

import com.bllj2.query.exception.BaseException;
import com.bllj2.query.http.ResponseResult;
import com.bllj2.query.info.PageResult;
import com.bllj2.query.info.QueryPageArgs;
import com.bllj2.query.info.page.ContractDiscountInfo;
import com.bllj2.query.service.QueryService;
import com.bllj2.query.utils.ResponseResultUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author lijuny
 */
@RestController
@Slf4j
public class DisCountController {

	private final QueryService queryService;

	public DisCountController(QueryService queryService) {
		this.queryService = queryService;
	}

	@GetMapping("/discounts/findBypage")
	private ResponseResult<?> discountsFindByPage(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
	                                              @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize,
	                                              @RequestParam(defaultValue = "0", value = "startTime") Long startTime,
	                                              @RequestParam(required = false, value = "endTime") Long endTime,
	                                              @RequestParam(required = false, value = "contractNumber") String contractNumber) {
		if (endTime == null) {
			endTime = Long.MAX_VALUE;
		}
		QueryPageArgs args = new QueryPageArgs(pageNum, pageSize, startTime, endTime, null, null, contractNumber);
		log.info("/discounts/findBypage,{}", args);
		int total = queryService.queryDisCount(args);
		int totalPage = total % args.getPageSize() == 0 ? total / args.getPageSize() : total/ args.getPageSize() + 1;
		if (totalPage <= args.getPageNum() - 1) {
			throw new BaseException("pageNum大于总页数");
		}
		List<ContractDiscountInfo> result = queryService.queryContractDiscount(args);
		PageResult<ContractDiscountInfo> contractDiscountInfoPageResult = PageResult.create(args, result);
		contractDiscountInfoPageResult.setTotal(total);
		contractDiscountInfoPageResult.setTotalPage(totalPage);
		contractDiscountInfoPageResult.setLastPage(args.getPageNum() == total);
		return ResponseResultUtils.success(contractDiscountInfoPageResult);
	}
}
