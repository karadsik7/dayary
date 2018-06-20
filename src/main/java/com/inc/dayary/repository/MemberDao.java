package com.inc.dayary.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.dayary.domain.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;

	public Member selectOne(String id) {
		return sqlSession.selectOne("member.selectOne", id);
	}

	public Member getfindOneByEmail(String email) {
		return sqlSession.selectOne("member.findOneByEmail", email);
	}
	
	
	
}
