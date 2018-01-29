package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.ChangeInfoLogic;
import by.bsu.hr.logic.UserProfileLogic;
import by.bsu.hr.logic.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChangeInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        LocaleResourceBundle.ResourceBundleEnum rb= (LocaleResourceBundle.ResourceBundleEnum) session.getAttribute("rb");
        String name;
        if(!request.getParameter("name").isEmpty()){
            name=request.getParameter("name");
            ((User)session.getAttribute("user")).setName(name);
        }else name=((User)session.getAttribute("user")).getName();
        String sname;
        if(!request.getParameter("sname").isEmpty()){
            sname=request.getParameter("sname");
            ((User)session.getAttribute("user")).setSname(sname);
        }else sname=((User)session.getAttribute("user")).getSname();
        String phone;
        if(!request.getParameter("phone").isEmpty()){
            phone=request.getParameter("phone");
            ((User)session.getAttribute("user")).setPhone(phone);
        }else phone=((User)session.getAttribute("user")).getPhone();
        String email;
        if(!request.getParameter("email").isEmpty()){
            email=request.getParameter("email");
            ((User)session.getAttribute("user")).setEmail(email);
        }else email=((User)session.getAttribute("user")).getEmail();
        int id=((User)session.getAttribute("user")).getUserId();
        ChangeInfoLogic.updateInfo(name,sname,phone,email,id);
        request.setAttribute("user", session.getAttribute("user"));
        if(Validator.isUser(session)){
            List<Proposal> proposalList= UserProfileLogic.getProposals(((User)session.getAttribute("user")).getUserId());
            List<Interview> previewList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"PREV");
            List<Interview> techList= UserProfileLogic.getFutureInterview(((User)session.getAttribute("user")).getUserId(),"TECH");
            request.setAttribute("proposalList",proposalList);
            request.setAttribute("previewList",previewList);
            request.setAttribute("techList",techList);
            request.setAttribute("proposalList",proposalList);
            SetAttributes.setAttributesMyProfilePage(rb,request);
            return PageConstant.USER_PROFILE_PAGE;
        }else{
            SetAttributes.setAttributesHRProfilePage(rb,request);
            return PageConstant.HR_PROFILE_PAGE;
        }

    }
}
