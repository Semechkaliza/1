package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    /**
     * @param request from jsp
     * @return page String
     */
    String execute(HttpServletRequest request);
}