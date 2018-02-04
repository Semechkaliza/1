package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.LogicException;
import by.bsu.hr.logic.ResultLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.bsu.hr.command.PageConstant.RESULT_PAGE;

public class ResultCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        int userId=((User)session.getAttribute("user")).getUserId();
        try {
            List<Interview> resPreview = ResultLogic.getPreviewResult(userId);
            List<Interview> resTInterview=ResultLogic.getInterviewResult(userId);
            request.setAttribute("resPrev",resPreview);
            request.setAttribute("resTI",resTInterview);
        } catch (LogicException e) {
           return PageConstant.ERROR_PAGE;
        }
        request.setAttribute("lang",session.getAttribute("locale"));
        return RESULT_PAGE;
    }
}
