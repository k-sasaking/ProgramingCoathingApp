package com.rebelapp.pcm.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.annotation.Validated;

@Validated
public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirm, Object>{
	
	private String message;
	private String passwordFieldName;
	private String confirmPasswordFieldName;
	
	@Override
	public void initialize(PasswordConfirm confirmPassword) {
		message = confirmPassword.message();
		passwordFieldName = confirmPassword.password();
		confirmPasswordFieldName = confirmPassword.confirmPassword();
	}
	
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		
		BeanWrapper beanwrapper = new BeanWrapperImpl(obj);
		
		Object passwordFiledValue = beanwrapper.getPropertyValue(passwordFieldName);
		Object confirmPasswordFiledValue = beanwrapper.getPropertyValue(confirmPasswordFieldName);
		
		String password = (String)passwordFiledValue;
		String confirmPassword = (String)confirmPasswordFiledValue;
		
		if(password.equals(confirmPassword)) {
			return true;
		}
		
		
		context.disableDefaultConstraintViolation();
	    context.buildConstraintViolationWithTemplate(message)
	             .addPropertyNode(confirmPasswordFieldName).addConstraintViolation();
		
		
		return false;
		
	}
	
}
