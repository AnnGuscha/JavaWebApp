package jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by Anna on 2/2/2016.
 */
public class Menu extends TagSupport {
    private static final long serialVersionUID = 1L;

    private int role;

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
//            pageContext.getOut().print( "<jsp:include page=\""+ Role.getRole(role).name().toLowerCase()+"../../Menu.jsp\"/>" );
            pageContext.getOut().print("<h1>Menu</h1>");

        } catch (IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }
}
