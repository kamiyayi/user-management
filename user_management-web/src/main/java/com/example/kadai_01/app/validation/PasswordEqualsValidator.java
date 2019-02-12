package com.example.kadai_01.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.kadai_01.app.form.RegisterForm;

@Component
public class PasswordEqualsValidator implements Validator {

	@Override
	public boolean supports(Class<?>clazz) {
		return RegisterForm.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasFieldErrors("password")) {
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
