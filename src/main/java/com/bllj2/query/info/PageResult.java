package com.bllj2.query.info;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 分页查询的结果
 * @author lijuny
 */
@Getter
@Setter
public class PageResult<T> {
	/**
	 * 页码
	 */
	private int pageNum;
	/**
	 * 每页条数
	 */
	private int pageSize;
	/**
	 * 总共条数
	 */
	private int total;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 是否为最后一页
	 */
	private boolean isLastPage;
	/**
	 * 数据
	 */
	private List<T> data;

	public static <V> PageResult<V> create(QueryPageArgs args, List<V> data ){
		PageResult<V> vPageResult = new PageResult<>();
		vPageResult.setPageNum(args.getPageNum());
		vPageResult.setPageSize(args.getPageSize());
		vPageResult.setData(data);
		return vPageResult;
	}
}
