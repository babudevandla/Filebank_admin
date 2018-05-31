
$(function(){
	
 $("#signup-form").validate({
	errorClass:'inputError',
	validClass:'InputSuccess',
	rules: {
		firstname:{
			required:true
		},
		mobile_no:{
			required:true
		},
		email:{
			required:true,
			email:true
		},
		password:{
			required:true,
			minlength:8
		},
		confirmPass:{
			required:true,
			minlength:8,
			equalTo:'#password'
		},
		city:{
			required:true
		},
		state:{
			required:true
		},
		country:{
			required:true
		},
		zipcode:{
			required:true
		}
	},
	messages: {			
		firstname: {
			required: "Please enter firstname."
		},
		mobile_no:{
			required: "Please enter mobile number.",
			number : "Please enter the numbers only",
			minlength : "Should have 12 digits",
			maxlength : "Cann't exceed more than 12"
		},
		email: {
			required: "Please enter email address.",
			email : "Please enter a valid email address."
		},
		password: {
			required: "Please enter password.",
				minlength:"Password should minimum 8 characters."
		},
		confirmPass: {
			required: "Please enter confirm password.",
			minlength:"Password should minimum 8 characters.",
			equalTo: "Please enter password & confirm password must be same."
		},
		country : {
			required: "Please enter country."
		},
		city : {
			required: "Please enter city."
		},
		state : {
			required: "Please enter state."
		},
		zipcode : {
			required: "Please enter zipcode."
		}
	},
	submitHandler: function(form) {
		form.submit();
		
		}
	
	});
 
 // Login form validation
 $("#login_form").validate({
		errorClass:'inputError',
		validClass:'InputSuccess',
		rules: {
			mobile_no:{
				required:true
			},
			password:{
				required:true,
				minlength:8
			},
		},
		messages: {			
			mobile_no: {
				required: "Please enter mobile number."
			},
			password: {
				required: "Please enter password.",
				minlength:"Password should minimum 8 characters."
			},
		},
		submitHandler: function(form) {
			form.submit();
			
		}
		
	});
 
 //Dynamic access code validation 
 $("#dac_update").validate({
		errorClass:'inputError',
		validClass:'InputSuccess',
		rules: {
			dynamic_access_code:{
				required:true
			}
		},
		messages: {			
			dynamic_access_code: {
				required: "Please enter dynamic access code."
			}
		},
		submitHandler: function(form) {
			form.submit();
			
		}
		
	});
 
 
 
});