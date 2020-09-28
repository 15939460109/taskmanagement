package com.czg.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    //设计一个方法，获取指定名称的cookie
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        //找寻userId的cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }
        }
        return null;
    }
}
