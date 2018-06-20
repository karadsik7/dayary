package com.inc.dayary.service;

import com.inc.dayary.domain.Member;

public interface MemberService {

	public Member findOne(String id);

	public boolean emailDupCheck(String email);

	public String sendCertifyEmail(String email);

	
	
}
