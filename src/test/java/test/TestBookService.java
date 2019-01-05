package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.nju.controller.CtxUtil;
import edu.nju.service.LoginService;


public class TestBookService {

    static LoginService loginService;
    
    static CtxUtil ctxUtil;
    
    @BeforeClass
    public static void before(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
//        loginService=ctx.getBean(LoginService.class);
//        ctxUtil = ctx.getBean(CtxUtil.class);
    }
    
    @Test
    public void testGetAllBooks() {
//        loginService.test();
    	CtxUtil.getBean(LoginService.class);
    }
}