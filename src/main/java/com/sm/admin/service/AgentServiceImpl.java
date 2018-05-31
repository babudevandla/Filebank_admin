package com.sm.admin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sm.admin.controller.AdminAgentController;
import com.sm.admin.dao.AgentDao;
import com.sm.admin.dto.AgentsDto;
import com.sm.admin.model.Agents;

@Service
@Transactional
public class AgentServiceImpl implements AgentService{

	private static final Logger logger = LoggerFactory.getLogger(AdminAgentController.class);
	
	@Autowired 
	private UploadFilesPathService uploadFilesPathService;
	
	@Autowired
	private AgentDao agentDao;
	
	@Override
	public void saveAgentDetails(AgentsDto agentsDto) {
		
		Agents agents=new Agents();
		agents.setAgentName(agentsDto.getAgent_name());
		agents.setAgentEmail(agentsDto.getAgent_email());
		agents.setMobileNo(agentsDto.getMobile_no());
		agents.setOfficeNo(agentsDto.getOffice_no());
		agents.setDescription(agentsDto.getDescription());
		if(agentsDto.getFile()!=null){
			try {
				if(StringUtils.hasText(agentsDto.getFile().getOriginalFilename()) && agentsDto.getFile().getBytes()!=null)
				{
					MultipartFile file = agentsDto.getFile();
					String filename = file.getOriginalFilename();
					String modifiedFileName = FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
					File filePath = uploadFilesPathService.getProfileImagePath(modifiedFileName);
					try {
						FileUtils.writeByteArrayToFile(filePath, file.getBytes());
					} catch (IOException e) {
						logger.error(e.getMessage());
						
					}
					agents.setAgentModifiedImg(modifiedFileName);
					agents.setAgentOriginalImg(filename);
				}
			}catch(Exception e){
				e.printStackTrace();
				logger.info("error while agent saving:"+e.getMessage());
			}
			agentDao.saveAgentDetails(agents);
		}
		
	}

	@Override
	public List<Agents> getAgentsList() {
		return agentDao.getAgentsList();
	}

	@Override
	public Agents getAgentById(Integer agentId) {
		return agentDao.getAgentById(agentId);
	}

}
