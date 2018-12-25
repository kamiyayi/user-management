package com.example.kadai_01.app.user;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.kadai_01.domain.model.Account;
import com.example.kadai_01.domain.model.Role;
import com.example.kadai_01.domain.service.user.UserService;
import com.example.kadai_01.app.form.RegisterForm;

@Controller
@Component
@RequestMapping(value = "user")
public class UserController {
	
	@Inject
	UserService userService;

	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public RegisterForm setUpForm() {
		RegisterForm registerForm = new RegisterForm();
		return registerForm;
	}

	@RequestMapping(value="register", method = RequestMethod.GET, params="form")
	public String registerForm(RegisterForm registerForm,Model model) {
		return "user/register/registerForm";
	}

	@RequestMapping(value="register", method=RequestMethod.POST, params="confirm")
	public String confirmForm(@Validated RegisterForm registerForm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return registerRedo(registerForm,model);		
		}
		return "user/register/registerConfirm";
	}
	@RequestMapping(value="register", method=RequestMethod.POST, params="redo")
	public String registerRedo(@Validated RegisterForm registerForm, Model model) {
		return "user/register/registerForm";
	}

    @RequestMapping(value="register", method=RequestMethod.POST, params="finish")
	public String registerFinish(@Validated RegisterForm registerForm,Model model,RedirectAttributes attributes){
		
		Account account = beanMapper.map(registerForm,Account.class); 
		Role role = beanMapper.map(registerForm,Role.class);
		
		try {
			userService.create(account);
			userService.create(role);
			
		}catch(BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return registerRedo(registerForm,model);
		}	
		attributes.addFlashAttribute(ResultMessages.success().add(
				ResultMessage.fromText("Succeed")));
		System.out.print("succeed");
		return "redirect:/user/register/register?finish";
	}
}