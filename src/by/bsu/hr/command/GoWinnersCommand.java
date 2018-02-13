package by.bsu.hr.command;

import by.bsu.hr.entity.Winner;
import by.bsu.hr.logic.GoWinnersLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Command to go to page with all info about winners by admin
 */
public class GoWinnersCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(GoWinnersCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null){
            List<Winner> resList;
            try {
                resList = GoWinnersLogic.findWinners();
            } catch (LogicException e) {
                logger.log(Level.INFO,"Error find winners");
                return PageConstant.ERROR_PAGE;
            }
            request.setAttribute("winList",resList);
            request.setAttribute("lang",session.getAttribute("locale"));
            return PageConstant.HR_WINNERS_PAGE;
        }else{
            request.setAttribute("lang", Locale.getDefault());
            return PageConstant.LOGIN_PAGE;
        }
        }

}
