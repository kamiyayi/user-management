package com.example.kadai_01.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.kadai_01.app.form.RegisterForm;

@Component
public class PasswordEqualsValidator implements Validator {

	
	//This validator validate RegisterForm instances. Return true or false.
	@Override
	public boolean supports(Class<?>clazz) { //
		return RegisterForm.class.isAssignableFrom(clazz); 
	}
	
	//Validate the supplied target object which mostly return true. The error instance can be used to report any resulting validation error.
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasFieldErrors("password")) {          //Single Validation Check of password.
			return;
		}
		RegisterForm registerForm = (RegisterForm) target;
		String password = registerForm.getPassword();
		String confirmPassword = registerForm.getConfirmPassword();

		if(!password.equals(confirmPassword)) {          
			errors.rejectValue("password", "PasswordEqualsValidators.registerForm.password","Password and Confirm Password must be same");
		}
	}

}
