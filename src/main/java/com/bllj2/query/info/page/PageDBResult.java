package com.bllj2.query.info.page;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author lijuny
 * @date 2020/11/6
 */
@Getter
@Setter
public class PageDBResult {

	/**
	 * 主表
	 */
	private String contractId;
	private String contractType;
	private String contractNumber;
	private String outletNo;
	private String outletName;
	private String outletType;
	private boolean prcContract;
	private long startDate;
	private long endDate;
	private String signerId;
	private String signerName;
	private long signDate;
	private BigDecimal completeDisCount;
	private BigDecimal discountTargetRate;
	private BigDecimal extraDiscount;
	private long activitySession;
	private String contractVersion;
	private String contractState;
	private String poNo;
	private String targetBase;
	private long createTime;
	private long lastModifiedTime;
	/**
	 * 合同明细
	 */
	private String contractDetailId; //赋一个初始值，这样就知道数据库里面查出来的值里面有没有对应的 contractDetailId，没有就不需要返回到query里面detail的list
	private String subBrandNo;
	private String subBrandName;
	private BigDecimal targetVolume;
	private BigDecimal targetValue;
	private boolean keySubbranch;
	private long detailCreateTime;
	private long detailLastModifiedTime;

	/**
	 * 覆盖门店
	 */
	private String contractStoreId;
	private String storeOutletName;
	private String storeOutletNo;
	private long storeCreateTime;
	private long storeLastModifiedTime;

	/**
	 * 实现一个比较器，为了给查询出来的结果排序
	 */

	public static Comparator<PageDBResult> pageDBResultComparator = (o1, o2) -> {
		String contractId1 = o1.getContractId();
		String contractId2 = o2.getContractId();
		if (!Objects.equals(contractId1,contractId2)) {
			return contractId1.compareTo(contractId2);
		}
		String contractDetailId1 = o1.getContractDetailId();
		String contractDetailId2 = o2.getContractDetailId();
		if (!Objects.equals(contractDetailId1,contractDetailId2)) {
            return contractDetailId1.compareTo(contractDetailId2);
		}
		return o1.getContractStoreId().compareTo(o2.getContractStoreId());
	};

}
