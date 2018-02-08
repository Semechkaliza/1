package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Pattern Factory to make all commands
 */
public class ActionFactory {
    /**
     * @param request
     * @return Command
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + ": command not found or wrong! ");
        } return current;
    }
}