package com.sm.admin.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sm.admin.dao.BlogDao;
import com.sm.admin.dto.BlogsDto;
import com.sm.admin.model.Blogs;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{

   private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired 
	private UploadFilesPathService uploadFilesPathService;
	
	@Autowired
	private BlogDao blogDao;
	
	@Override
	public void saveBlogDetails(BlogsDto blogs) {

		Blogs blogs1=new Blogs();
		if(blogs.getFile()!=null){
			try {
				if(StringUtils.hasText(blogs.getFile().getOriginalFilename()) && blogs.getFile().getBytes()!=null)
				{
					MultipartFile file = blogs.getFile();
					String filename = file.getOriginalFilename();
					String modifiedFileName = FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
					File filePath = uploadFilesPathService.getProfileImagePath(modifiedFileName);
					try {
						FileUtils.writeByteArrayToFile(filePath, file.getBytes());
					} catch (IOException e) {
						logger.error(e.getMessage());
						
					}
					blogs1.setBlog_img(filename);
					blogs1.setBlog_modified_img(modifiedFileName);
				}
			}catch(Exception e){
				e.printStackTrace();
				logger.info("error while agent saving:"+e.getMessage());
			}
			blogs1.setBlog_name(blogs.getBlog_name());
			blogs1.setDescription(blogs.getDescription());
			blogDao.saveBlogDetails(blogs1);
		}
	}

}
