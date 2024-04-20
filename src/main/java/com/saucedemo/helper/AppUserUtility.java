package com.saucedemo.helper;

import net.minidev.json.JSONObject;

public class AppUserUtility {
    static String jsonFilePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
            + System.getProperty("file.separator") + "main" + System.getProperty("file.separator") + "resources"
            + System.getProperty("file.separator") + "Users.json";
    static JSONObject jsonObject = JsonUtil.readDataFromJsonFile(jsonFilePath);

    public static String getUserName(Users user) {
        return (String) JsonUtil.getJsonObject(jsonObject, user.getUser()).get("username");
    }

    public static String getPassword(Users user) {
        return (String) JsonUtil.getJsonObject(jsonObject, user.getUser()).get("password");
    }

    public enum Users {
        USER_1("$.Users.User_1"),
        USER_2("$.Users.User_2");

        private String user;

        Users(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }
}
