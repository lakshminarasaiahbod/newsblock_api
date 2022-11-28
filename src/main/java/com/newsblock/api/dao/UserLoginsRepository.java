package com.newsblock.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newsblock.api.model.UserLogins;

@Repository
public interface UserLoginsRepository extends JpaRepository<UserLogins, Integer> {

	@Query("SELECT ul FROM UserLogins ul WHERE isactive = 1 and ul.access_token =:access_token")
	List<UserLogins> findByActiveToken(String access_token);

	@Query("SELECT ul FROM UserLogins ul WHERE isactive = 1 and ul.userid =:userid")
	List<UserLogins> findByUserID(String userid);

	@Query("SELECT ul FROM UserLogins ul WHERE isactive = 1 and ul.email =:email")
	List<UserLogins> findByEmail(String email);

	@Query("SELECT ul FROM UserLogins ul WHERE isactive = 1 and ul.access_token =:token")
	List<UserLogins> findByToken(String token);

}