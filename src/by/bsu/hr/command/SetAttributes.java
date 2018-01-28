package by.bsu.hr.command;

import javax.servlet.http.HttpServletRequest;

public class SetAttributes {
    public static void setAttributesLoginPage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request) {
        request.setAttribute("login",lang.getMessage("login"));
        request.setAttribute("password",lang.getMessage("password"));
        request.setAttribute("registration",lang.getMessage("registration"));
        request.setAttribute("LogIn",lang.getMessage("LogIn"));
        request.setAttribute("name",lang.getMessage("name"));
        request.setAttribute("sname",lang.getMessage("sname"));
    }
    public static void setAttributesMyProfilePage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request){
        request.setAttribute("futurePreview",lang.getMessage("futurePreview"));
        request.setAttribute("futureTechInterview",lang.getMessage("futureTechInterview"));
        request.setAttribute("date",lang.getMessage("date"));
        request.setAttribute("time",lang.getMessage("time"));
        request.setAttribute("place",lang.getMessage("place"));
        request.setAttribute("cancel",lang.getMessage("cancel"));
        request.setAttribute("vacancyName",lang.getMessage("vacancyName"));
        request.setAttribute("companyName",lang.getMessage("companyName"));
        request.setAttribute("login",lang.getMessage("login"));
        request.setAttribute("name",lang.getMessage("name"));
        request.setAttribute("sname",lang.getMessage("sname"));
        request.setAttribute("role",lang.getMessage("role"));
        request.setAttribute("rating",lang.getMessage("rating"));
        request.setAttribute("vacancy",lang.getMessage("vacancy"));
        request.setAttribute("welcome",lang.getMessage("welcome"));
        request.setAttribute("LogOut",lang.getMessage("LogOut"));
        request.setAttribute("result",lang.getMessage("result"));
        request.setAttribute("myProfile",lang.getMessage("myProfile"));
        request.setAttribute("myProposal",lang.getMessage("myProposal"));
        request.setAttribute("addProposal",lang.getMessage("addProposal"));
        request.setAttribute("changeInfo",lang.getMessage("changeInfo"));
        request.setAttribute("deleteProfile",lang.getMessage("deleteProfile"));
    }
    public static void setAttributesRegistrationPage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request){
        request.setAttribute("login",lang.getMessage("login"));
        request.setAttribute("password",lang.getMessage("password"));
        request.setAttribute("registration",lang.getMessage("registration"));
        request.setAttribute("LogIn",lang.getMessage("LogIn"));
        request.setAttribute("yes",lang.getMessage("yes"));
        request.setAttribute("no",lang.getMessage("no"));
        request.setAttribute("name",lang.getMessage("name"));
        request.setAttribute("sname",lang.getMessage("sname"));
    }
    public static void setAttributesChangeInfoPage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request){
        request.setAttribute("changeInfo",lang.getMessage("changeInfo"));
        request.setAttribute("name",lang.getMessage("name"));
        request.setAttribute("sname",lang.getMessage("sname"));
        request.setAttribute("phone",lang.getMessage("phone"));
        request.setAttribute("email",lang.getMessage("email"));
        request.setAttribute("apply",lang.getMessage("apply"));
        request.setAttribute("vacancy",lang.getMessage("vacancy"));
        request.setAttribute("LogOut",lang.getMessage("LogOut"));
        request.setAttribute("result",lang.getMessage("result"));
        request.setAttribute("myProfile",lang.getMessage("myProfile"));
    }
    public static void setAttributesResultPage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request){
        request.setAttribute("vacancy",lang.getMessage("vacancy"));
        request.setAttribute("LogOut",lang.getMessage("LogOut"));
        request.setAttribute("result",lang.getMessage("result"));
        request.setAttribute("myProfile",lang.getMessage("myProfile"));
        request.setAttribute("PrevResults",lang.getMessage("PrevResults"));
        request.setAttribute("company",lang.getMessage("company"));
        request.setAttribute("vacancy",lang.getMessage("vacancy"));
        request.setAttribute("date",lang.getMessage("date"));
        request.setAttribute("time",lang.getMessage("time"));
        request.setAttribute("place",lang.getMessage("place"));
        request.setAttribute("mark",lang.getMessage("mark"));
        request.setAttribute("feedback",lang.getMessage("feedback"));
        request.setAttribute("TIResults",lang.getMessage("TIResults"));

    }
    public static void setAttributesVacancyPage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request){
        request.setAttribute("vacancy",lang.getMessage("vacancy"));
        request.setAttribute("more",lang.getMessage("more"));
        request.setAttribute("company",lang.getMessage("company"));
        request.setAttribute("LogOut",lang.getMessage("LogOut"));
        request.setAttribute("result",lang.getMessage("result"));
        request.setAttribute("myProfile",lang.getMessage("myProfile"));
    }

    public static void setAttributesOneVacancyPage(LocaleResourceBundle.ResourceBundleEnum lang, HttpServletRequest request) {
        request.setAttribute("company",lang.getMessage("company"));
        request.setAttribute("vacancy",lang.getMessage("vacancy"));
        request.setAttribute("salary",lang.getMessage("salary"));
        request.setAttribute("other",lang.getMessage("other"));
        request.setAttribute("LogOut",lang.getMessage("LogOut"));
        request.setAttribute("result",lang.getMessage("result"));
        request.setAttribute("myProfile",lang.getMessage("myProfile"));
        request.setAttribute("addProposal",lang.getMessage("addProposal"));
    }
}
