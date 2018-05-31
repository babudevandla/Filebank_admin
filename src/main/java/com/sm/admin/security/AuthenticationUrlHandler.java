package com.sm.admin.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.sm.admin.common.CommonController;
import com.sm.admin.model.Users;
import com.sm.admin.service.UserService;

/**
 * 
 * @author chaitra
 * EMPID:J11189
 * Used for authenticating the user and redirecting him to correspoding home page based on his authority
 */
@Service
public class AuthenticationUrlHandler   implements AuthenticationSuccessHandler {

	private final Logger LOGGER = Logger.getLogger(this.getClass());

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	public UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {

		System.out.println("User Info");
		
		String targetUrl=null;
		
		  Users currentUser = null;
			if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){				
				currentUser = userService.findUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
				request.getSession().setAttribute("currentUser", currentUser);
				LOGGER.info("LoggedUser Email:"+currentUser.getEmail());
			}
			else{
		        //TODO.if session expairs need to send sesssion expired page
			}

			//for setting target url(getting specific user dash board)
			if(currentUser!=null){
				
				//check if ROLE_CUSTOMER then redirect to ROLE_CUSTOMER dashboard
				if(currentUser.getUserRole().equalsIgnoreCase("ROLE_CUSTOMER")){
					targetUrl="/customer/dashboard";
				}
				
				//check if ROLE_APPLICANT then redirect to ROLE_CONTRACTOR dashboard
				else if(currentUser.getUserRole().equalsIgnoreCase("ROLE_AGENT")){
					targetUrl="/agent/dashboard";
				}
				//if not sutable to any role
				else{
					//TODO.send or redirect to tell him,your not good user
					targetUrl="/accessDenied";
				}
			}

			if (response.isCommitted()) {
				LOGGER.debug("Response has already been committed. Unable to redirect to "+ targetUrl);
				return;
			}
	     
		redirectStrategy.sendRedirect(request, response, targetUrl);
		clearAuthenticationAttributes(request);
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
	

}
