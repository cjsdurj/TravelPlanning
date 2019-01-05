package edu.nju.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import edu.nju.service.LoginService;

@WebServlet("/LoginController")
public class LoginController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	LoginService loginService;
	
	@Override
	public void init() throws ServletException{
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
		loginService = CtxUtil.getBean(LoginService.class);
	}
	/*
	 * 处理微信小程序getSessionID的要求
	 */
	public void getSessionID(HttpServletRequest request, HttpServletResponse response) {
        String js_code = request.getParameter("js_code");
        String sessionID = loginService.getSessionID(js_code);
        Map<String, String> result = new HashMap<String, String>();;
        result.put("sessionID", sessionID);
        result.put("msg", "后台已收到");
        String json = new Gson().toJson(result);
        respond(json, request, response);
    }
	/*
	 * 返回值给微信小程序
	 */
	private void respond(String answer, HttpServletRequest request, HttpServletResponse response) {
        Writer out;
		try {
			out = response.getWriter();
			out.write(answer);
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
