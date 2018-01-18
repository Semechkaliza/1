package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String  page= PageConstant.LOGIN_PAGE;
        request.getSession().invalidate();
        return page;
    }
}