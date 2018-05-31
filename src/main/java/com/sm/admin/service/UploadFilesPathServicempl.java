package com.sm.admin.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UploadFilesPathServicempl implements UploadFilesPathService{
	
	private static Logger logger = Logger.getLogger(UploadFilesPathServicempl.class);
	
	@Autowired private ServletContext context;
	
	@Override
	public File getProfileImagePath(String modifiedFileName) {
		try{
			boolean exists = (new File(context.getRealPath("/agentImg/"))).exists();
			if (!exists) {
				new File(context.getRealPath("/agentImg/")).mkdir();
			}
			String modifiedFilePath =context.getRealPath("/agentImg/"+File.separator+modifiedFileName);
			File file = new File(modifiedFilePath);
			
			return file;
		}catch(Exception e){
			logger.equals(e.getMessage());
		}
		
		return null;
		
	}
	
	
	@Override
	public File getLevedBookPdfsPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/leveledBook/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/leveledBook/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/leveledBook/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}
	
	@Override
	public File getAssessmentSessionath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/assessmentSessions/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/assessmentSessions/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/assessmentSessions/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}

	@Override
	public File getCriminalFilePath(String modifiedProfileName) {
		boolean exists = (new File(context.getRealPath("/criminalfiles/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/criminalfiles/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/criminalfiles/"+File.separator+modifiedProfileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getEducationalFilePath(String modifiedProfileName) {
		boolean exists = (new File(context.getRealPath("/educationalfiles/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/educationalfiles/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/educationalfiles/"+File.separator+modifiedProfileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getEmployeeFilePath(String modifiedProfileName) {
		boolean exists = (new File(context.getRealPath("/employeefiles/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/employeefiles/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/employeefiles/"+File.separator+modifiedProfileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getSignatureFilePath(String firstname) {
		boolean exists = (new File(context.getRealPath("/signatures/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/signatures/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/signatures/"+File.separator+firstname);
		File file = new File(modifiedFilePath);
		
		return file;
	}

	@Override
	public File getMediaFilesPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/mediaFiles/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/mediaFiles/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/mediaFiles/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getNewSessionAssessmentPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/newsession/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/newsession/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/newsession/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getPreSessionAssessmentPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/presession/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/presession/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/presession/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getPostSessionAssessmentPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/postsession/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/postsession/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/postsession/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getTutoringMaterialPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/tutoringMaterials/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/tutoringMaterials/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/tutoringMaterials/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getStudentGoalsPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/studentgoals/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/studentgoals/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/studentgoals/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public File getStudentLessonPlansPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/lessonplans/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/lessonplans/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/lessonplans/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public FileInputStream downloadNewSessionAssessmentPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/newsession/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}
	
	@Override
	public FileInputStream downloadPreSessionAssessmentPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/presession/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}
	
	@Override
	public FileInputStream downloadPostSessionAssessmentPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/postsession/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}
	
	@Override
	public FileInputStream downloadTutoringMaterialPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/tutoringMaterials/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}
	
	@Override
	public FileInputStream downloadLeveledBookPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/leveledBook/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}
	
	@Override
	public FileInputStream downloadStudentGoalsPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/studentgoals/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}
	@Override
	public FileInputStream downloadStudentLessonPlansPath(String assessmentPdf) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/lessonplans/"+File.separator+assessmentPdf));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}


	@Override
	public FileInputStream downloadCriminalDoc(String criminalDoc) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/criminalfiles/"+File.separator+criminalDoc));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}


	@Override
	public FileInputStream downloadEducationDoc(String educationDoc) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/educationalfiles/"+File.separator+educationDoc));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}


	@Override
	public FileInputStream downloadEmployeeDoc(String employeeDoc) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/employeefiles/"+File.separator+employeeDoc));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}


	@Override
	public File getTutorFormsPath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/forms/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/forms/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/forms/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	@Override
	public FileInputStream downloadTutorFormsPath(String modifiedBookName) {
		FileInputStream file =null;
		try {
			file = new FileInputStream(context.getRealPath("/forms/"+File.separator+modifiedBookName));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return file;
	}


	@Override
	public File getTestGuidePath(String modifiedFileName) {
		boolean exists = (new File(context.getRealPath("/testGuide/"))).exists();
		if (!exists) {
			new File(context.getRealPath("/testGuide/")).mkdir();
		}
		String modifiedFilePath =context.getRealPath("/testGuide/"+File.separator+modifiedFileName);
		File file = new File(modifiedFilePath);
		
		return file;
	}


	
}
