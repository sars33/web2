package servlets;

import util.PageGenerator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class NewServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("value");
        Map<String, Object> pageVariables = createPageVariablesMap(request);
        //String value = request.getParameter("value") ;
        //int newValue = Integer.parseInt(request.getParameter("value") ) ;
        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=utf-8");

        if (param == null) {
            response.getWriter().println(0);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        } else {
            try {
                int newValue = Integer.parseInt(request.getParameter("value")  ) ;
                response.getWriter().println(newValue * 2);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (NumberFormatException e) {

                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            }

        }
    }
    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());

        return pageVariables;
    }
}
