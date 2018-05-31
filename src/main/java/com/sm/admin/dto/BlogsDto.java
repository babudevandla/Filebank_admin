package com.sm.admin.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BlogsDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer blogs_id;
	private String blog_name;
	private String description;
	private String posted_by;
	private Date created_date;
	private String blog_img;
	private String blog_modified_img;
	private MultipartFile file;
	
	
	public Integer getBlogs_id() {
		return blogs_id;
	}
	public void setBlogs_id(Integer blogs_id) {
		this.blogs_id = blogs_id;
	}
	public String getBlog_name() {
		return blog_name;
	}
	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getBlog_img() {
		return blog_img;
	}
	public void setBlog_img(String blog_img) {
		this.blog_img = blog_img;
	}
	public String getBlog_modified_img() {
		return blog_modified_img;
	}
	public void setBlog_modified_img(String blog_modified_img) {
		this.blog_modified_img = blog_modified_img;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
