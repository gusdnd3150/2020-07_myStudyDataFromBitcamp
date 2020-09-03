package com.spring.ex03;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Override
	public void listMembers() {
		System.out.println("MemberDAOImpl.listMembers 호출");
	}
}
