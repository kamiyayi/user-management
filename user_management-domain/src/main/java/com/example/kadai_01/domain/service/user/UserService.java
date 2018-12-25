package com.example.kadai_01.domain.service.user;

import com.example.kadai_01.domain.model.Account;
import com.example.kadai_01.domain.model.Role;

public interface UserService {
	Account create(Account account);
	
	Role create(Role role);
}
