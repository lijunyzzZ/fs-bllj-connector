package com.bllj2.query.info;

import java.io.File;


import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 *
 * @author lijuny
 */
@Setter
@Getter
@ToString
public class SaveSignPictureArgs {
	@NotNull(message = "合同id不能为空")
	private String contractNumber;
	@NotNull(message = "签字人id不能为空")
	private String signerId;
	@NotNull(message = "签字人姓名不能为空")
	private String signerName;
	@NotNull(message = "签字人日期不能为空")
	private String signDate;
	@NotNull(message = "是否签名字段不能为空")
	private Boolean isContractSign;
	/**
	 * 图片的路径，这个参数不是前段传过来，是{@link com.bllj2.query.service.SaveService}里面生成的。
	 */
	private String pictureUrl;
	private String signPicture;
}
