package com.inc.dayary.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inc.dayary.domain.Member;
import com.inc.dayary.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/signup")
	public String signupForm(Model model) {
		model.addAttribute("member", new Member());
		return "member/signup";
	}
	
	@PostMapping("/member/signup")
	public String signup(@ModelAttribute @Valid Member member, BindingResult result, HttpSession session) {
		if(memberService.findOne(member.getId()) != null) {
			result.addError(new FieldError("idError", "id", "중복된 아이디입니다."));
		}
		if(!member.isPasswordValid()) {
			FieldError error = new FieldError
					("passwordError", "passwordConfirm", "패스워드가 일치하지 않습니다.");
			result.addError(error);
		}
		if(!member.getEmail().equals((String)session.getAttribute("email"))) {
			FieldError error = new FieldError("emailNotEqualsError", "email", "인증메일로 가입하세요");
			result.addError(error);
		}
		if(!member.getEmailCode().equals((String)session.getAttribute("emailCode"))) {
			FieldError error = new FieldError("emailCodeError", "emailCode", "코드가 일치하지 않습니다");
			result.addError(error);
		}
		if(result.hasErrors()) {	
			return "member/signup";
		}
		
		memberService.signup(member);
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/member/dupCheck")
	@ResponseBody
	public String dupCheck(@RequestParam String id) {
		Member member = memberService.findOne(id);
		if(member == null) {
			return "not dual";
		}else {
			return "dual";
		}
	}
	
	@PostMapping("/member/emailcertify")
	@ResponseBody
	public String emailcertify(@RequestParam String email, HttpSession session) {
		if(email.length() == 0) {
			return "null";
		}
		if(!EmailValidator(email)) {
			return "incorrect";
		}
		if(memberService.emailDupCheck(email)) {
			return "duplicated";
		}
		String emailCode = null;
		try {
			emailCode = memberService.sendCertifyEmail(email);
		}catch(RuntimeException e) {
			return "error";
		}
		session.setAttribute("email", email);
		session.setAttribute("emailCode", emailCode);
		return "success";
	}
	
	@GetMapping("/member/signin")
	public String signinForm(Model model) {
		model.addAttribute("member", new Member());
		return "member/signin";
	}
	
	@PostMapping("/member/signin")
	public String signin(@ModelAttribute Member member, BindingResult result, HttpServletRequest request) {
		Member savedMember = memberService.findOne(member.getId());
		if(savedMember == null) {
			result.addError(new FieldError("notExistId", "id", "존재하지 않는 ID입니다."));
		}else if(!savedMember.getPassword().equals(member.getPassword())) {
			result.addError(new FieldError("notSamePass", "password", "비밀번호가 일치하지 않습니다."));
		}
		if(result.hasErrors()) {
			return "member/signin";
		}else {
			request.getSession().invalidate();
			request.getSession().setAttribute("member", savedMember);
			return "redirect:/";
		}
	}
	
	@GetMapping("/member/signout")
	public String signout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/signin";
	}
	

	private boolean EmailValidator(String email) {
		return Pattern.compile("([A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z]{2,10})").matcher(email).matches();
	}
	
	
	
	
}
