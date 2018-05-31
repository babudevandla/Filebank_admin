package com.sm.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.admin.common.CommonController;

@Controller
@RequestMapping("/admin")
public class GeneralManagementController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(GeneralManagementController.class);
	
	//================== Start Testimonials ===========================
	
	/*@RequestMapping(value="/manage-testimonials",method=RequestMethod.GET)
	public String tutorAssessments(Model model){
		logger.info("testimonials page");
		
		List<Testimonials> testimonials=genaralMgntService.getTestimonials();
		
		model.addAttribute("testimonials",testimonials);
		model.addAttribute("generalMgnt", true);
		
		return "admin/manageTestimonial";
	}
	
		@RequestMapping(value="/save-testimonials",method=RequestMethod.POST)
		public String adminSaveTestimonials(TestimonialsDto testimonialsDto,@RequestParam("file") MultipartFile[] file,final RedirectAttributes model,HttpServletRequest request) throws IOException{
			logger.info("admin  Save Testimonials content");
			System.out.println(testimonialsDto.getTestimonials().size());
			for(int i=0;i<testimonialsDto.getTestimonials().size();i++){
				MultipartFile files = file[i];
				Testimonials testimonials=new Testimonials();
				testimonials.setClientName(testimonialsDto.getTestimonials().get(i).getClientName());
				testimonials.setDate(new Date());
				String content =  new String(testimonialsDto.getTestimonials().get(i).getContent().getBytes("ISO-8859-1"),"UTF-8");
				testimonials.setContent(content);
				testimonials.setLocation(testimonialsDto.getTestimonials().get(i).getLocation());
				
					if(files.getBytes() != null && !files.getOriginalFilename().isEmpty()){
						testimonials.setImage(true);
						testimonials.setClientImage(files.getBytes());
					}else{
						testimonials.setImage(false);
						testimonials.setClientImage(files.getBytes());
					}
					genaralMgntService.saveTestionials(testimonials);
			}
		    model.addFlashAttribute("sucess",TESTIMONIAL_SUCCESS);
		    
			return "redirect:/admin/manage-testimonials";	
		}
		
		@RequestMapping(value="/edit-testimonials/{id}")
		public String adminEditTestimonials(@PathVariable Integer id,Model model,HttpServletRequest request){
			logger.info("admin Edit Testimonials");
			Testimonials testimonials=genaralMgntService.editTestimonials(id);
			List<Testimonials> testimonials1=genaralMgntService.getTestimonials();
			
			try {
				FileUtils.writeByteArrayToFile(new File(context.getRealPath("/testmonialImg/"
								+ File.separator + testimonials.getId())),
								testimonials.getClientImage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("clientimage", testimonials.getClientImage());
		    model.addAttribute("testimonials",testimonials1);
		    model.addAttribute("test",testimonials);
		    
			return "admin/editTestimonial";
		}
		
		@RequestMapping(value="/update-testimonials",method=RequestMethod.POST)
		public String adminEditTestimonialsContent(Testimonials testimonials,@ModelAttribute("file") MultipartFile file,Model model,HttpServletRequest request,final RedirectAttributes redirectAttributes) throws IOException{
			logger.info("admin update Testimonials");
			if(file.getBytes() != null && !file.getOriginalFilename().isEmpty()){
				testimonials.setImage(true);
				testimonials.setClientImage(file.getBytes());
			}else{	
				byte[] images=(byte[]) request.getSession().getAttribute("clientimage");
				testimonials.setClientImage(images);
			}
				//testimonials.setDate(convertStringtoDateIndDDMMyyyyhhmmss(testimonials.getTestdate()));
				genaralMgntService.updateTestimonials(testimonials);
				redirectAttributes.addFlashAttribute("message",TESTIMONIAL_UPDATED);
			
			return "redirect:/admin/manage-testimonials";	
		}
		
		@RequestMapping(value="/delete-testimonials",method=RequestMethod.GET)
		public @ResponseBody MessageDto adminDeleteTestimonials(@RequestParam("id") Integer id,Model model,HttpServletRequest request,final RedirectAttributes redirectAttributes){
			logger.info("admin delete Testimonials");
			MessageDto messageDto = new MessageDto();
			Integer result=genaralMgntService.deleteTestimonials(id);
			
			if(result!=null){
				messageDto.setStatus("success");
			}else{
				messageDto.setStatus("failure");
			}
			
			return messageDto;
		}
		
		@RequestMapping("/message-delete-testimonials")
		public String messagedeletetestimonials(@RequestParam("id") Integer id,@RequestParam("message") String message,final RedirectAttributes redirectAttributes){
			if(message!=null){
				if(message.equalsIgnoreCase("success")){
					redirectAttributes.addFlashAttribute("message", TESTIMONIAL_DELETE);
				}else if(message.equalsIgnoreCase("failure")){
					redirectAttributes.addFlashAttribute("failuremessage", TESTIMONIAL_DELETE_FAILURE);
				}
			}
			
			if(!id.equals(0)){
				return "redirect:/admin/edit-testimonials/"+id;
			}else{
				return "redirect:/admin/manage-testimonials";
			}
		}
		
		@RequestMapping(value="/removeTestimonialsAll")
		@ResponseBody
		public String removeTestimonialsAll(Model model,@RequestParam Integer[] ids,HttpServletRequest request,RedirectAttributes attributes){
			logger.info("admin Remove Testimonials page");
			if(ids.length>0){
			for(Integer a : ids){
				genaralMgntService.deleteTestimonials(a);
			}
			return TESTIMONIAL_DELETE_ALL;		
			}
			else{
				return TESTIMONIAL_DELETE_ALL_FAILURE;		
				
				
			}
			
		}
		
	//=============================================================================================================================
		
	
	@RequestMapping("/faq-management")
	public String applicantManagement(Model model)
	{
		logger.info("applicantFAQs");
		model.addAttribute("generalMgnt", true);
		
		List<ManageFAQ> faqs=faqService.getFAQList();
		model.addAttribute("faqs", faqs);
		
		return "admin/faqManagement";
	}
	
	@RequestMapping(value="/save-faqs",method=RequestMethod.POST)
	public String givingAnswer(@ModelAttribute ManageFAQ faq,Model model,final RedirectAttributes redirectAttributes,HttpServletRequest request,Principal principal) throws UnsupportedEncodingException{
		
		faq.setCreatedDate(new Date());
		
		String question =  new String(faq.getQuestion().getBytes("ISO-8859-1"),"UTF-8");
		String answer =  new String(faq.getAnswer().getBytes("ISO-8859-1"),"UTF-8");
		faq.setQuestion(question);
		faq.setAnswer(answer);
		faqService.saveFAQ(faq);
		
		redirectAttributes.addFlashAttribute("message", FAQ_SUCCESS);
		return "redirect:/admin/faq-management";
	}
	
	@RequestMapping(value="/edit-faq/{faqId}")
	public String adminEditFaqManagement(@PathVariable Integer faqId,Model model,HttpServletRequest request){
		logger.info("admin Edit FAQ Management");
		
		
		ManageFAQ faq = faqService.getFAQById(faqId);
		model.addAttribute("faq", faq);
		
		List<ManageFAQ> faqs=faqService.getFAQList();
		model.addAttribute("faqs", faqs);
	    
		return "admin/editFaqManagement";
	}
	
	@RequestMapping(value="/update-faq",method=RequestMethod.POST)
	public String adminUpdateFaq(ManageFAQ manageFAQ,Model model,HttpServletRequest request,final RedirectAttributes redirectAttributes) throws IOException{
		logger.info("admin update FAQ");
		if(manageFAQ.getFaqId()!=null){
			
			String question =  new String(manageFAQ.getQuestion().getBytes("ISO-8859-1"),"UTF-8");
			String answer =  new String(manageFAQ.getAnswer().getBytes("ISO-8859-1"),"UTF-8");
			manageFAQ.setQuestion(question);
			manageFAQ.setAnswer(answer);
			faqService.updateFaq(manageFAQ);
		}
		
			redirectAttributes.addFlashAttribute("message",FAQ_UPDATE);
		
		return "redirect:/admin/faq-management";	
	}
	
	
	@RequestMapping(value="/delete-faq",method=RequestMethod.GET)
	public  @ResponseBody MessageDto adminDeleteFaq(@RequestParam("faqId") Integer faqId,Model model,HttpServletRequest request,final RedirectAttributes redirectAttributes) throws IOException{
		logger.info("admin delete FAQ");
		MessageDto messageDto = new MessageDto();
		Integer result=faqService.deleteFaq(faqId);
		
		if(result!=null){
			messageDto.setStatus("success");
		}else{
			messageDto.setStatus("failure");
		}
		
		return messageDto;
		
	}
	
	@RequestMapping("/message-delete-faq")
	public String messagedeletefaq(@RequestParam("faqId") Integer faqId,@RequestParam("message") String message,final RedirectAttributes redirectAttributes){
		if(message!=null){
			if(message.equalsIgnoreCase("success")){
				redirectAttributes.addFlashAttribute("message", FAQ_DELETE);
			}else if(message.equalsIgnoreCase("failure")){
				redirectAttributes.addFlashAttribute("failuremessage", FAQ_DELETE_FAILURE);
			}
		}
		
		if(!faqId.equals(0)){
			return "redirect:/admin/edit-faq/"+faqId;
		}else{
			return "redirect:/admin/faq-management";
		}
	}*/
	
	//=============================================================================================================================
	
	
	/*@RequestMapping("/manage-messaging-system")
	public String messagingSystem(Model model)
	{
		logger.info("messagingSystem");
		model.addAttribute("generalMgnt", true);
		
		model.addAttribute("pages",genaralMgntService.getAllPageNames());
		
		return "admin/messagingSystem";
	}
	
	@RequestMapping(value="/getStaticPage")
	public @ResponseBody ContentManager getStaticPage(@RequestParam("masterMenuName")String PageName,Model model,HttpServletRequest request){
		
		logger.info("admin manage get Static Page");
		return genaralMgntService.getStaticPage(PageName);
		
	}
	
	@RequestMapping(value="/update-messages",method=RequestMethod.POST)
	public String updateStaticPage(@ModelAttribute ContentManager contentManager,final RedirectAttributes model,HttpServletRequest request){
		
		logger.info("admin manage CMS Static Page Manager");
		genaralMgntService.updateStaticPage(contentManager);
		
		model.addFlashAttribute("message",MESSAGE_UPDATE);
		
		return "redirect:/admin/manage-messaging-system";
		
	}	*/
	
	//================================================================================================================================
	
	/*@RequestMapping("/email-management")
	public String emailManagement(Model model)
	{
		logger.info("emailManagement");
		
		
		List<EmailTemplates> templates = genaralMgntService.getAllEmailTemplates();
		List<EmailTemplateContent> templateContent = genaralMgntService.getAllEmailTemplateContent();
		
		model.addAttribute("templates",templates);
		model.addAttribute("templateContent",templateContent);
		model.addAttribute("generalMgnt", true);
		
		return "admin/emailManagement";
	}
	
	@RequestMapping(value = "/emailTemplateBodySubject",method=RequestMethod.GET)
	public @ResponseBody EmailTemplateContent emailTemplateBodySubject(@RequestParam Integer emailTemplateId, Model model,
			HttpServletRequest request) {
		logger.info("INSIDE==============ADMIN EMAIL SETTINGS SUBJECT BODY METHOD");
		
		EmailTemplateContent emailTemplatesContent = null;
		if(StringUtils.hasText(emailTemplateId.toString())){
			
			emailTemplatesContent = genaralMgntService.getAllSubjectBodyTemplates(emailTemplateId);
		
		}
		
		return emailTemplatesContent;
	}
	
	@RequestMapping(value="/update-email-templateContent", method = RequestMethod.POST)
    public String updateGeneralEmailTemplateContent(@ModelAttribute EmailTemplateContent templateContent,Model model,Principal principal,final RedirectAttributes rAttributes) {
	 
		logger.info("INSIDE==============ADMIN EMAIL SETTINGS UPDATE GENERAL EMAIL TEMPLATE SUBJECT BODY METHOD");
	 
	 if(templateContent==null || templateContent.getId()==null){
		 
		 logger.info("Erro message at else Part");
		 model.addAttribute("errorMessage",EMAILTEMPLATE_FAILURE);
		 
	 }else{
		 
		 logger.info("inside loop");
		 rAttributes.addFlashAttribute("message", EMAILTEMPLATE_SUCCESS);
		 genaralMgntService.updateGeneralEmailTemplateContent(templateContent);
		 model.addAttribute("message",EMAILTEMPLATE_SUCCESS);
	 }
	
		
		 List<EmailTemplates> templates = genaralMgntService.getAllEmailTemplates();
		 List<EmailTemplateContent> templateContent1 = genaralMgntService.getAllEmailTemplateContent();
		 
		model.addAttribute("updatedTemplateContent",templateContent);
		model.addAttribute("templates",templates);
		model.addAttribute("templateContent",templateContent1);
		model.addAttribute("generalMgnt", true);
		
		return "redirect:/admin/email-management";
    }*/
	
	//==================================================================================================================================
	
	/*@RequestMapping("/manage-media")
	public String manageMedia(Model model)
	{
		logger.info("manageMedia");
		model.addAttribute("generalMgnt", true);
		
		List<MediaLibrary> mediaFiles=genaralMgntService.getMediaLibraryList();
		model.addAttribute("mediaFiles", mediaFiles);
		
		return "admin/manageMedia";
	}
	
	@RequestMapping("/upload-multiplefiles")
	public String uploadMultiplefiles(Model model)
	{
		logger.info("upload multiplefiles");
		model.addAttribute("generalMgnt", true);
		
		return "admin/uploadMediaFiles";
	}
	
	@RequestMapping(value="/submit-multiplefiles",method=RequestMethod.POST)
	public String submitbookFolder(@ModelAttribute MediaLibraryDto libraryDto,final RedirectAttributes redirectAttributes){
		
		String redirectURL="";
		if(libraryDto.getFiles().size()>0){
			Integer result =  genaralMgntService.saveMediaLibraryFiles(libraryDto);
			if(result!=null){
				redirectAttributes.addFlashAttribute("message",UPLOADFILES_SUCCESS);
				redirectURL= "redirect:/admin/manage-media";
			}else{
				redirectAttributes.addFlashAttribute("message",UPLOADFILES_FAILURE);
			}
		}else{
			redirectAttributes.addFlashAttribute("message",UPLOADFILES_SIZE);
			redirectURL= "redirect:/admin/upload-multiplefiles";
		}
		return redirectURL;
	}
*/	
}
