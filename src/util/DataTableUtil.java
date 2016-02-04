package util;

import dto.JQueryDataTableParamModel;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class DataTableUtil implements Serializable {
    public DataTableUtil() {
    }

    public static JQueryDataTableParamModel getRequestParam(HttpServletRequest request) {
        JQueryDataTableParamModel param = new JQueryDataTableParamModel();
        param.sEcho = request.getParameter("sEcho");
        param.iColumns = Integer.parseInt(request.getParameter("iColumns"));
        param.iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
        param.iDisplayStart = Integer.parseInt(request.getParameter("iDisplayStart"));
        param.iSortingCols = Integer.parseInt(request.getParameter("iSortingCols"));
        param.sSearch = request.getParameter("sSearch");
        param.sColumns = request.getParameter("sColumns");
        return param;
    }
}