package com.bllj2.query.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.UUID;

import com.bllj2.query.exception.BaseException;
import com.bllj2.query.info.SavePointArgs;
import com.bllj2.query.info.SaveSignPictureArgs;
import com.bllj2.query.mapper.SaveMapper;
import com.bllj2.query.service.SaveService;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;

/**
 * @author lijuny
 * @date 2020/11/15
 */
@Service
public class SaveServiceImpl implements SaveService {
	private final SaveMapper mapper;
	private static final Logger logger = LoggerFactory.getLogger(SaveServiceImpl.class);

	@Value("${saveFilePath}")
	private String path;

	public SaveServiceImpl(SaveMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void savePoint(SavePointArgs args) {
		mapper.savePoint(args);
	}

	@Override
	@Transactional //保存是写两个表需要开启事务，不然会有事务一致性的问题
	public void saveSignPicture(SaveSignPictureArgs args) {
		if (args.getIsContractSign()) {
			saveFile(args);
		}
		mapper.updateContract(args);
	}

	private void saveFile(SaveSignPictureArgs args) {
		if (StringUtils.isEmpty(path)) {
			throw new BaseException("请配置文件保存的位置");
		}
		String signPicture = args.getSignPicture();
		if (StringUtils.isEmpty(signPicture)) {
			throw new BaseException("图片为空");
		}
		try {
			String fileType = getFileType(signPicture);
			byte[] bytes = new BASE64Decoder().decodeBuffer(signPicture.substring(signPicture.indexOf("base64,") + 7 ));
			FileUtils.forceMkdir(new File(path));
			File imageFile = new File(path, UUID.randomUUID().toString() + '.' + fileType);
			FileUtils.writeByteArrayToFile(imageFile, bytes);
			args.setPictureUrl(imageFile.getAbsolutePath());
			mapper.savePicture(args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private String getFileType(String s) {
		int extentionStartIndex = s.indexOf('/');
		int extensionEndIndex = s.indexOf(';');
		return s.substring(extentionStartIndex + 1, extensionEndIndex);
	}


}
