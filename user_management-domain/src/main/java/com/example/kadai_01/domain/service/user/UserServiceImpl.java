package com.example.kadai_01.domain.service.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.kadai_01.domain.model.Account;
import com.example.kadai_01.domain.model.Role;
import com.example.kadai_01.domain.repository.user.register.AccountRepository;
import com.example.kadai_01.domain.repository.user.register.RoleRepository;

//TERASOLUNAでは設定漏れを防ぐために、クラスレベルに@Transactionalを付与することを推奨
@Transactional

//Serviceクラスは状態を保持しない、Singletonスコープのbeanとしてコンテナに登録する。
@Service
public class UserServiceImpl implements UserService{
	

    @Inject
    AccountRepository accountRepository;
    
    @Inject
    RoleRepository roleRepository;
    
    public Account create(Account account) {
    	accountRepository.createAccount(account);
    	return account;
    }

	public Role create(Role role) {
		roleRepository.createRole(role);
		return role;
	}
}