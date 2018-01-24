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
    GO_MY_PROFILE {
        {
            this.command = new GoMyProfileCommand();
        }
    },
    RESULT {
        {
            this.command = new ResultCommand();
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