package by.bsu.hr.controller;

import by.bsu.hr.command.ActionCommand;
import by.bsu.hr.command.ActionFactory;
import by.bsu.hr.command.PageConstant;
import by.bsu.hr.filter.EncodingFilter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Locale current=Locale.getDefault();
        System.out.println(Locale.getDefault());
        ResourceBundle rb=ResourceBundle.getBundle("resources.text",current);
        request.setAttribute("login",rb.getString("login"));
        request.setAttribute("password",rb.getString("password"));
        request.setAttribute("registration",rb.getString("registration"));
        request.setAttribute("LogIn",rb.getString("LogIn"));
        request.setAttribute("yes",rb.getString("yes"));
        request.setAttribute("no",rb.getString("no"));
        request.setAttribute("name",rb.getString("name"));
        request.setAttribute("sname",rb.getString("sname"));
        String page;
        if(!(request.getParameter("action")==null)) {
            page=PageConstant.REGISTRATION_PAGE;
        }
        else page=PageConstant.LOGIN_PAGE;
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
}
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
    }
            else {
                page = PageConstant.LOGIN_PAGE;
                response.sendError(404,"page not found");
                //request.getSession().setAttribute("nullPage", "Page not found. Business logic error.");
                //response.sendRedirect(request.getContextPath() + page);
            }
        }
}
