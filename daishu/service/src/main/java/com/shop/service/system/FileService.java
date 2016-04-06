package com.shop.service.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.system.File;
import com.shop.data.mapper.system.FileMapper;
import com.shop.service.AbstractService;

@Service
public class FileService extends AbstractService<File> {

	@Autowired
	private FileMapper fileMapper;

	public FileService() {
		super(File.class);
	}
	
	public String insert(CommonsMultipartFile multipartFile, String dir) {
		try {
			String fileId = UUID.randomUUID().toString();
			fileId = fileId.replace("-", "");
			
			
			FileOutputStream os = new FileOutputStream(dir + "/" + fileId);
			FileInputStream in = (FileInputStream) multipartFile.getInputStream();
			int b = 0;
            while ((b=in.read()) != -1) {
                os.write(b);
            }
            os.flush();
            os.close();
            in.close();
            
			File file = new File();
			file.setId(fileId);
			file.setName(multipartFile.getOriginalFilename());
			file.setContentType(multipartFile.getContentType());
			file.setCreateTime(new Date());
			super.insert(file);
			return fileId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AbstractMapper getAbstractMapper() {
		return this.fileMapper;
	}

}
