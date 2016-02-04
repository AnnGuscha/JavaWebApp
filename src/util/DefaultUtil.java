package util;

import entity.User;
import manager.Role;

import java.io.Serializable;

public class DefaultUtil implements Serializable {
    public static String getDefaultPage(User user) {
        switch (Role.values()[user.getRole()]) {
            case ADMIN:
                return "/admin";
            case PROFESSOR:
                return "/professor";
            case STUDENT:
                return "/student";
            default:
                return "hello.jsp";
        }
    }
}