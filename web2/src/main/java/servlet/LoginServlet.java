package servlet;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariableMap(req);
        pageVariables.put("value", "");
        resp.getWriter().println(PageGenerator.getInstance().getPage("authPage.html", pageVariables));
        resp.setContentType("text/html;charset=utf-8");
        // PrintWriter writer = resp.getWriter();
        //  User user = new User();
        //  user.setEmail(req.getParameter("email"));
        // user.setPassword(req.getParameter("password"));
        // userService.addUser(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //from request get the User (email and password.
        Map<String, Object> pageVariables = createPageVariableMap(req);
        pageVariables.put("value", "");
        resp.getWriter().println(PageGenerator.getInstance().getPage("authPage.html", pageVariables));
        resp.setContentType("text/html;charset=utf-8");

    }

    private static Map<String, Object> createPageVariableMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL()).toString();
        return pageVariables;
    }


}