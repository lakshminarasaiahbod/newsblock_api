/**
 * 
 */
package com.newsblock.api.services;

import com.newsblock.api.model.dto.LoginRequest;
import com.newsblock.api.model.dto.NewUser;

public interface UserService {

	String createUser(NewUser userData);

	String loginUser(LoginRequest loginRequest);

}
