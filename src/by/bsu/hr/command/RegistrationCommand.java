package by.bsu.hr.command;

import by.bsu.hr.logic.RegistrationLogic;
import javax.servlet.http.HttpServletRequest;


public class RegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page= RegistrationLogic.registraton(request);
        return page;
    }
}
