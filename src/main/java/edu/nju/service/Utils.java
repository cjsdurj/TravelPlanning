package edu.nju.service;

import java.util.UUID;

public class Utils {
	//生成随机数，作为sessionid
	public String getRandom() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
