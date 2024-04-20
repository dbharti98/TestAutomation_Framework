package com.saucedemo.helper;

import net.minidev.json.JSONObject;
import org.openqa.selenium.InvalidArgumentException;

public class AppUrlUtility {

	private static final String path = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "src" + System.getProperty("file.separator") + "main" + System.getProperty("file.separator") + "resources"
			+ System.getProperty("file.separator") + "Users.json";

	private static final JSONObject object = JsonUtil.readDataFromJsonFile(path);
	private static final String url = "$.Url.User_URL_";

	private AppUrlUtility() {
	}

	public static String getUrl() {
		try {
			return JsonUtil.getValue(object, url+System.getProperty("user"));
		} catch (Exception e) {
			throw new InvalidArgumentException("URL path is invalid/incorrect");
		}
	}
}