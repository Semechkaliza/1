package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.logic.HRInterviewLogic;
import by.bsu.hr.logic.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoHRPreviewsFullCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        List<Interview> resList= null;
        try {
            resList = HRInterviewLogic.findFullInterviews("PREV");
        } catch (LogicException e) {
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("prevList",resList);
        return PageConstant.HR_PREVIEW_FULL_PAGE;
    }
}
