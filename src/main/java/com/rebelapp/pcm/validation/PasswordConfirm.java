package com.rebelapp.pcm.validation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordConfirmValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConfirm {
	public String message() default "Password doesn't match. Please check your password again";
	Class<?> [] groups() default{};
	Class<? extends Payload> [] payload() default{};
	
	String password();
	
	String confirmPassword();
}
