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
            String path = Role.getRole(role).name().toLowerCase() + "/Menu.jsp";
//            pageContext.getOut().print( "<jsp:include page=\""+ Role.getRole(role).name().toLowerCase()+"../../Menu.jsp\"/>" );
            pageContext.getOut().print("<jsp:include page=\"" + path + "\"/>");

        } catch (IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }

        return SKIP_BODY;
    }
}
