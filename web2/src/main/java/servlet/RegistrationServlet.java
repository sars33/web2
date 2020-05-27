package servlet;

import model.User;
import service.UserService;
import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RegistrationServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        resp.getWriter().println(PageGenerator.getInstance().getPage("register.html", pageVariables));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

   // @Override
  //  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Map<String, Object> pageVariables = new HashMap<>();
       // resp.getWriter().println(PageGenerator.getInstance().getPage("register.html", pageVariables));
      //  resp.setStatus(HttpServletResponse.SC_OK);
  //  }




}
