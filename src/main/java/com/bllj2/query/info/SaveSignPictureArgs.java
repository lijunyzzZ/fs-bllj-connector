package com.bllj2.query.info;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>succez</p>
 *
 * @author lijuny
 */
@Setter
@Getter
public class SaveSignPictureArgs {
	private String contractNumber;
	private String signerId;
	private Boolean isContractSign;
	private File file;
}
