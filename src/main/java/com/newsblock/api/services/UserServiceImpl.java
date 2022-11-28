/**
* 
*/
package com.newsblock.api.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsblock.api.dao.UserLoginsRepository;
import com.newsblock.api.model.UserLogins;
import com.newsblock.api.model.dto.LoginRequest;
import com.newsblock.api.model.dto.NewUser;
import com.newsblock.api.util.md5;
import com.newsblock.api.util.token;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserLoginsRepository userLoginsRepository;

	@Override
	public String createUser(NewUser userData) {

		System.out.println(userData.toString());

		// need to changed not working
		boolean flag = Arrays.stream(NewUser.class.getDeclaredFields()).allMatch(f -> {
			try {
				return (f.get(userData) != null) || f.get(userData) == null;
			} catch (IllegalAccessException e) {
				return false;
			}
		});
		if (flag) {
			return "missing fields";
		} else {

			List<UserLogins> userLoginByUserID = userLoginsRepository.findByUserID(userData.getUserid());
			if (userLoginByUserID.size() > 0) {
				return "user id already exists";
			}
			List<UserLogins> userLoginByEmail = userLoginsRepository.findByEmail(userData.getEmail());
			if (userLoginByEmail.size() > 0) {
				return "email id already exists";
			}

			UserLogins newLogin = new UserLogins();
			newLogin.fromDTO(userData);
			userLoginsRepository.save(newLogin);
			return "user created";

		}

	}

	@Override
	public String loginUser(LoginRequest loginRequest) {

		if (loginRequest.getUserid() != null || loginRequest.getEmail() != null) {

			if (loginRequest.getPassword() != null) {
				List<UserLogins> userLoginID = userLoginsRepository.findByUserID(loginRequest.getUserid());
				if (userLoginID.size() > 0) {
					if (userLoginID.get(0).getPassword().equals(md5.getMd5(loginRequest.getPassword()))) {
						userLoginID.get(0).setAccess_token(token.generateNewToken());
						userLoginsRepository.save(userLoginID.get(0));
						return userLoginID.get(0).getAccess_token();
					}
				}
				List<UserLogins> userLoginEmail = userLoginsRepository.findByEmail(loginRequest.getEmail());
				if (userLoginEmail.size() > 0) {
					if (userLoginEmail.get(0).getPassword().equals(md5.getMd5(loginRequest.getPassword()))) {
						userLoginEmail.get(0).setAccess_token(token.generateNewToken());
						userLoginsRepository.save(userLoginEmail.get(0));
						return userLoginEmail.get(0).getAccess_token();
					}
				}
				return "invalid credentials";

			} else {
				return "password missing";
			}

		} else {

			return "user id/email missing";
		}

	}

}
