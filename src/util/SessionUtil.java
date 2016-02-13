package util;

import manager.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return null;
        } else
            return session;
    }

    public static int getUserId(HttpServletRequest request) {
        return Integer.parseInt(getSession(request).getAttribute("userId").toString());
    }

    public static Locale getLocale(HttpServletRequest request) {
        return (Locale) getSession(request).getValue("locale");
    }
}
