package by.bsu.hr.command;

public enum CommandEnum {
    REGISTRATION{
    {
        this.command = new RegistrationCommand();
    }

},
    LOGOUT {
    {
        this.command = new LogoutCommand();
    }
},
    LOGIN {
        {
            this.command = new LoginCommand();
        }
},
    GET_VACANCIES {
        {
            this.command = new GetVacanciesCommand();
        }
};
    ActionCommand command;
    public ActionCommand getCurrentCommand() { return command; }
}