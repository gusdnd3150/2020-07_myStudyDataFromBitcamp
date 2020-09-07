package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;           //필드에 오토와이얼을 넣어도 되고 set에서도 적용가능
    
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMembers();
		return membersList;
	}

}