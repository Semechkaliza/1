package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    /**
     * @param request
     * @return page String
     */
    String execute(HttpServletRequest request);
}