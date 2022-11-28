package com.newsblock.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsblock.api.model.dto.LoginRequest;
import com.newsblock.api.model.dto.NewUser;
import com.newsblock.api.services.UserService;
import com.newsblock.api.util.CommonResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public CommonResponse register(@RequestBody NewUser userData) {
		CommonResponse commonResponse = new CommonResponse();
		String response = userService.createUser(userData);
		commonResponse.setSuccessResponse(response);
		return commonResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public CommonResponse login(@RequestBody LoginRequest loginRequest) {
		CommonResponse commonResponse = new CommonResponse();
		String response = userService.loginUser(loginRequest);
		commonResponse.setSuccessResponse(response);
		return commonResponse;
	}

}