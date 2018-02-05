package by.bsu.hr.command;

import by.bsu.hr.entity.Winner;
import by.bsu.hr.logic.GoWinnersLogic;
import by.bsu.hr.logic.HandleWinnerLogic;
import by.bsu.hr.logic.LogicException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class HandleWinnerCommand implements ActionCommand {
    private static Logger logger=Logger.getLogger(HandleWinnerCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        int user= Integer.parseInt(request.getParameter("user"));
        int vacancy= Integer.parseInt(request.getParameter("vacancy"));
        List<Winner> resList;
        try {
            HandleWinnerLogic.handleWinner(user,vacancy);
            resList= GoWinnersLogic.findWinners();
        } catch (LogicException e) {
            logger.log(Level.INFO,"Error handle winners");
            return PageConstant.ERROR_PAGE;
        }

        request.setAttribute("winList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_WINNERS_PAGE;
    }
}
