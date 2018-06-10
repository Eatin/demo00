package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController{

	@RequestMapping(value = "login")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsp/login");
		return mv;
	}

	@PostMapping("/logincheck")
	public String login(@RequestParam("userName") String userName,
						@RequestParam("password") String password,
						Map<String, Object> map,
						HttpSession session) {
		if (!StringUtils.isEmpty(userName)&&"123".equals(password)){

			session.setAttribute("loginUser", userName);
			return "redirect:manage.html";
		}
		else {
			map.put("msg","用户名或者密码错误");
			return "redirect:login.html";
		}

	}

}
