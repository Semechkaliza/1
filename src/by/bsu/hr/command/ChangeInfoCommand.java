package by.bsu.hr.command;

import by.bsu.hr.entity.Interview;
import by.bsu.hr.entity.Proposal;
import by.bsu.hr.entity.User;
import by.bsu.hr.logic.ChangeInfoLogic;
import by.bsu.hr.logic.MyProfileLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChangeInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        ResourseBundle.ResourceBundleEnum rb= (ResourseBundle.ResourceBundleEnum) session.getAttribute("rb");
        String name;
        if(!request.getParameter("name").isEmpty()){
            name=request.getParameter("name");
            ((List<User>) session.getAttribute("user")).get(0).setName(name);
        }else name=((List<User>) session.getAttribute("user")).get(0).getName();
        String sname;
        if(!request.getParameter("sname").isEmpty()){
            sname=request.getParameter("sname");
            ((List<User>) session.getAttribute("user")).get(0).setSname(sname);
        }else sname=((List<User>) session.getAttribute("user")).get(0).getSname();
        String phone;
        if(!request.getParameter("phone").isEmpty()){
            phone=request.getParameter("phone");
            ((List<User>) session.getAttribute("user")).get(0).setPhone(phone);
        }else phone=((List<User>) session.getAttribute("user")).get(0).getPhone();
        String email;
        if(!request.getParameter("email").isEmpty()){
            email=request.getParameter("email");
            ((List<User>) session.getAttribute("user")).get(0).setEmail(email);
        }else email=((List<User>) session.getAttribute("user")).get(0).getEmail();
        int id=((List<User>) session.getAttribute("user")).get(0).getUser_id();
        ChangeInfoLogic.updateInfo(name,sname,phone,email,id);
        List<Proposal> proposalList= MyProfileLogic.getProposals(((List<User>) session.getAttribute("user")).get(0).getLogin());
        List<Interview> previewList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getLogin(),"PREV");
        List<Interview> techList=MyProfileLogic.getFutureInterview(((List<User>) session.getAttribute("user")).get(0).getLogin(),"TECH");
        request.setAttribute("proposalList",proposalList);
        request.setAttribute("previewList",previewList);
        request.setAttribute("techList",techList);
        request.setAttribute("proposalList",proposalList);
        request.setAttribute("user",session.getAttribute("user"));
        SetAttributes.setAttributesMyProfilePage(rb,request);
        return PageConstant.MY_PROFILE_PAGE;
    }
}
