package com.bllj2.query.info;


import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * 保存积分请求参数
 * @author lijuny
 */
@Getter
@Setter
@Data
@ToString
public class SavePointArgs {
	@NotNull(message = "合同id不能为空")
	private String contractNumber;
	@NotNull(message = "门店编号不能为空")
	private String accountNo;
	private String store;
	private String name;
	private String paymentDate;
	private long pointEarned;
}
