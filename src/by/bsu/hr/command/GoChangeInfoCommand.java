package by.bsu.hr.command;

import by.bsu.hr.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command to go to change info page
 */
public class GoChangeInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        User user= (User) session.getAttribute("user");
        request.setAttribute("lang",session.getAttribute("locale"));
        if(user.getRole().equalsIgnoreCase("admin")){
            return PageConstant.HR_CHANGE_INFO_PAGE;
        }else{
            return PageConstant.CHANGE_INFO_PAGE;
        }


    }
}
