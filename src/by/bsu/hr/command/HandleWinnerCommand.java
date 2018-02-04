package by.bsu.hr.command;

import by.bsu.hr.entity.Winner;
import by.bsu.hr.logic.GoWinnersLogic;
import by.bsu.hr.logic.HandleWinnerLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class HandleWinnerCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        int user= Integer.parseInt(request.getParameter("user"));
        int vacancy= Integer.parseInt(request.getParameter("vacancy"));
        List<Winner> resList;
        try {
            HandleWinnerLogic.handleWinner(user,vacancy);
            resList= GoWinnersLogic.getWinners();
        } catch (LogicException e) {
            return PageConstant.ERROR_PAGE;
        }

        request.setAttribute("winList",resList);
        request.setAttribute("lang",session.getAttribute("locale"));
        return PageConstant.HR_WINNERS_PAGE;
    }
}
