package com.bllj2.query.mapper;

import com.bllj2.query.info.SavePointArgs;
import com.bllj2.query.info.SaveSignPictureArgs;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author lijuny
 * @date 2020/11/3
 */
@Repository
@Mapper
public interface SaveMapper {
	void savePoint(SavePointArgs args);

	void savePicture(SaveSignPictureArgs args);

	void updateContract(SaveSignPictureArgs args);
}
