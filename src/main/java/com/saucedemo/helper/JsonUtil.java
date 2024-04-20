package com.saucedemo.helper;

import java.io.FileReader;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class JsonUtil {

	public static JSONObject readDataFromJsonFile(String jsonFilePath) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(jsonFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public static String getValue(JSONObject jsonObject, String jsonPath) {
		try {
			return JsonPath.read(jsonObject, jsonPath);
		} catch (ClassCastException exception) {
			throw new ClassCastException("jsonpath" + jsonPath);
		}
	}

	public static JSONObject getJsonObject(JSONObject jsonObject, String jsonPath) {
		try {
			return JsonPath.read(jsonObject, jsonPath);
		} catch (ClassCastException exception) {
			throw new ClassCastException("jsonPath" + jsonPath);
		}
	}
}