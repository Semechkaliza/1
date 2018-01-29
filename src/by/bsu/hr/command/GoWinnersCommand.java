package by.bsu.hr.command;

import by.bsu.hr.entity.Winner;
import by.bsu.hr.logic.GoWinnersLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoWinnersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        List<Winner> resList= GoWinnersLogic.getWinners();
        request.setAttribute("winList",resList);
        SetAttributes.setAttributesHRWinnersPage(rb,request);
        return PageConstant.HR_WINNERS_PAGE;
    }
}