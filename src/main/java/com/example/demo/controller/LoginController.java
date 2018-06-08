package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class LoginController{

	@RequestMapping(value = "login")
	public String loginPage(){
		return "jsp/login";
	}

	@PostMapping("/logincheck")
	public String login(@RequestParam("userName") String userName,
						@RequestParam("password") String password,
						Map<String,Object> map){
		if (!StringUtils.isEmpty(userName)&&"123".equals(password)){
				return "redirect:/manage.html";
		}
		else {
			map.put("msg","用户名或者密码错误");
			return "jsp/login";
		}

	}

}
