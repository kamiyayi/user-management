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
		return "user/registerForm";
	}

	@RequestMapping(value="register", method=RequestMethod.POST, params="confirm")
	public String confirmForm(@Validated RegisterForm registerForm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return registerRedo(registerForm,model);		
		}
		return "user/registerConfirm";
	}
	@RequestMapping(value="register", method=RequestMethod.POST, params="redo")
	public String registerRedo(@Validated RegisterForm registerForm, Model model) {
		return "user/registerForm";
	}

	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerConfirm(@Validated RegisterForm registerForm,Model model,RedirectAttributes redirectAttributes){

		Account account = beanMapper.map(registerForm,Account.class); 
		Role role = beanMapper.map(registerForm,Role.class);

		try{
			Account createdAccount = userService.create(account);
			Role createdRole = userService.create(role);
			redirectAttributes.addFlashAttribute(createdAccount);
			redirectAttributes.addFlashAttribute(createdRole);	
			
		}catch(BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return registerRedo(registerForm,model);
		}
		return "redirect:/user/register?finish";
	}

	@RequestMapping(value="register", method=RequestMethod.GET, params="finish")
	public String registerFinish(Account createdAccount, Account createdRole) {
		return "user/registerFinish";
	}
}