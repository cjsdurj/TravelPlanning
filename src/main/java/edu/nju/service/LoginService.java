package edu.nju.service;

import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class LoginService {
	
	private String appid = "wxe75e59f2a541f6ae";
    private String secret = "3c8f64110c7252af39240e404fbd83a5";
	
    private StringBuilder session_key = new StringBuilder();
    private StringBuilder openid = new StringBuilder();
    /*
     * 获得第三方的sessionID
     */
	public String getSessionID(String js_code) {
		getSessionKey_openID(js_code);
		
		String session_key = this.session_key.toString();
		String openid = this.openid.toString();
		
		Utils utils = new Utils();
		String sessionID = utils.getRandom();
		
		System.out.println("sessionID: " + sessionID);
		//还要把sessionID和openid+session_key作为键值对，存储在session中
		
		return sessionID;
	}
	/*
	 * 获得session_key,openid
	 */
	private void getSessionKey_openID(String js_code) {
		String openid_session_string = WeChatService.GetOpenID(appid,secret,js_code);
		//将json字符串转换为json对象
        JsonObject openid_session = new JsonParser().parse(openid_session_string).getAsJsonObject();
        //根据json键读取json值
        //session_key
        String session_key = openid_session.get("session_key").getAsString();
        //openid是每个微信用户在该小程序上的唯一标识
        String openid = openid_session.get("openid").getAsString();
        
        System.out.println("session_key: " + session_key);
        System.out.println("openid: " + openid);
        //存储
        this.session_key.delete(0, this.session_key.length());
        this.openid.delete(0, this.openid.length());
        this.session_key.append(session_key);
        this.openid.append(openid);
	}
	
	public void test() {
		System.out.println("测试");
	}
}
