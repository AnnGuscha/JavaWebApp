package jstl;

import manager.Role;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Anna on 2/2/2016.
 */
public class MenuTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    private int role;

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            String userName = Role.getRole(role).toString();
            pageContext.getOut().print("Profile");

        } catch (IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }

        return SKIP_BODY;
    }
}
