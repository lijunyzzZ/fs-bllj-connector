package com.bllj2.query.info;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 * 保存积分请求参数
 * @author lijuny
 */
@Getter
@Setter
public class SaveIntegralsArgs {
	private String contractNumber;
	private String month;
	private String totalAccount;
}
