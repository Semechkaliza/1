package by.bsu.hr.controller;

import by.bsu.hr.command.ActionCommand;
import by.bsu.hr.command.ActionFactory;
import by.bsu.hr.command.PageConstant;
import by.bsu.hr.command.ResourseBundle;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.BE;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.EN;
import static by.bsu.hr.command.ResourseBundle.ResourceBundleEnum.RU;


@WebServlet("/")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourseBundle.ResourceBundleEnum lang;
        switch(Locale.getDefault().toString()){
            case "ru_RU": lang=RU;
                        break;
            case "be_BY": lang=BE;
                        break;
            default:    lang=EN;
                        break;
        }
        request.setAttribute("login",lang.getMessage("login"));
        request.setAttribute("password",lang.getMessage("password"));
        request.setAttribute("registration",lang.getMessage("registration"));
        request.setAttribute("LogIn",lang.getMessage("LogIn"));
        request.setAttribute("yes",lang.getMessage("yes"));
        request.setAttribute("no",lang.getMessage("no"));
        request.setAttribute("name",lang.getMessage("name"));
        request.setAttribute("sname",lang.getMessage("sname"));
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
