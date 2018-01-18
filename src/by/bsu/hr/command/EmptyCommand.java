package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
public class EmptyCommand implements ActionCommand {
    @Override public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;
        return page;
    }
}
