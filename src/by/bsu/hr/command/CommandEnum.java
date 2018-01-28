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
    DELETE_USER {
        {
            this.command = new DeleteUserCommand();
        }
    },
    RESULT {
        {
            this.command = new ResultCommand();
        }
    },
    CANCEL_PROPOSAL{
        {
            this.command=new CancelProposalCommand();
        }
    },
    ADD_PROPOSAL{
        {
            this.command=new AddProposalCommand();
        }
    },
    CHANGE_INFO{
        {
            this.command=new ChangeInfoCommand();
        }
    },
    GO_CHANGE_INFO{
        {
            this.command=new GoChangeInfoCommand();
        }
    },
    GO_LOGIN{
        {
            this.command=new GoLoginCommand();
        }
    },
    GO_REGISTRATION{
        {
            this.command=new GoRegistrationCommand();
        }
    },
    GET_VACANCIES {
        {
            this.command = new GetVacanciesCommand();
        }
},
    ONE_VACANCY{
        {
            this.command=new OneVacancyCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() { return command; }
}