package com.bllj2.query.service;

import com.bllj2.query.info.SavePointArgs;
import com.bllj2.query.info.SaveSignPictureArgs;

/**
 *
 *
 * @author lijuny
 * @date 2020/11/15
 */
public interface SaveService {
	/**
	 * 保存积分
	 * @param args
	 */
	void savePoint(SavePointArgs args);

	/**
	 * 保存图片
	 * @param args
	 */
	void saveSignPicture(SaveSignPictureArgs args);
}
