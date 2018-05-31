package com.sm.admin.service;

import java.io.File;
import java.io.FileInputStream;


public interface UploadFilesPathService {
	
	public File getProfileImagePath(String modifiedFileName);
	public File getLevedBookPdfsPath(String modifiedFileName);
	public File getAssessmentSessionath(String modifiedFileName);
	public File getCriminalFilePath(String modifiedProfileName);
	public File getEducationalFilePath(String modifiedProfileName);
	public File getEmployeeFilePath(String modifiedProfileName);
	public File getSignatureFilePath(String firstname);
	public File getMediaFilesPath(String modifiedFileName);
	public File getNewSessionAssessmentPath(String modifiedFileName);
	public File getPreSessionAssessmentPath(String modifiedFileName);
	public File getPostSessionAssessmentPath(String modifiedFileName);
	public File getTutoringMaterialPath(String modifiedFileName);
	public File getStudentGoalsPath(String modifiedFileName);
	public File getStudentLessonPlansPath(String modifiedFileName);
	public FileInputStream downloadNewSessionAssessmentPath(String assessmentPdf);
	public FileInputStream downloadPreSessionAssessmentPath(String assessmentPdf);
	public FileInputStream downloadPostSessionAssessmentPath(String assessmentPdf);
	public FileInputStream downloadTutoringMaterialPath(String assessmentPdf);
	public FileInputStream downloadStudentGoalsPath(String assessmentPdf);
	public FileInputStream downloadStudentLessonPlansPath(String assessmentPdf);
	public FileInputStream downloadLeveledBookPath(String assessmentPdf);
	public FileInputStream downloadCriminalDoc(String criminalDoc);
	public FileInputStream downloadEducationDoc(String educationDoc);
	public FileInputStream downloadEmployeeDoc(String employeeDoc);
	public File getTutorFormsPath(String modifiedFileName);
	public FileInputStream downloadTutorFormsPath(String modifiedBookName);
	public File getTestGuidePath(String modifiedFileName);
}
