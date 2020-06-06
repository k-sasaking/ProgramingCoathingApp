package com.rebelapp.pcm.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rebelapp.pcm.entity.User;
import com.rebelapp.pcm.service.AccountService;

public class ExistUserNameValidator implements ConstraintValidator<ExistUserName, String>{
	@Autowired
    AccountService accountService;

	@Override
    public void initialize(ExistUserName existUsername) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Optional<User> user = accountService.getUser(value);

        if(user.isPresent())
            return false;

        return true;
    }
}
