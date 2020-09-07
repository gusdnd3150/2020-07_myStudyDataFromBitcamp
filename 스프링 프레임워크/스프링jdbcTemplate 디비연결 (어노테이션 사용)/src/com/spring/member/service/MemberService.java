package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface MemberService {

	List listMembers() throws DataAccessException;

}
