package com.rebelapp.pcm.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ExistUserNameValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUserName {
	public String message() default "Already exist username.Please Check Your Email";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
