package by.bsu.hr.command;

import by.bsu.hr.logic.LoginLogic;
import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page= LoginLogic.logIn(request);
        return page;
    }
}