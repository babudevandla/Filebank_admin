package com.sm.admin.dto;

import java.util.List;

import com.sm.admin.model.Testimonials;

public class TestimonialsDto {
	
	private List<Testimonials> testimonials;
    private byte[] images;
    
    
	public List<Testimonials> getTestimonials() {
		return testimonials;
	}

	public void setTestimonials(List<Testimonials> testimonials) {
		this.testimonials = testimonials;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}
	

}
