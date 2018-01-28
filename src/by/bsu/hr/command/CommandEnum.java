package by.bsu.hr.command;

public enum CommandEnum {
    REGISTRATION {
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
    CANCEL_PROPOSAL {
        {
            this.command = new CancelProposalCommand();
        }
    },
    ADD_PROPOSAL {
        {
            this.command = new AddProposalCommand();
        }
    },
    CHANGE_INFO {
        {
            this.command = new ChangeInfoCommand();
        }
    },
    GO_CHANGE_INFO {
        {
            this.command = new GoChangeInfoCommand();
        }
    },
    GO_LOGIN {
        {
            this.command = new GoLoginCommand();
        }
    },
    GO_REGISTRATION {
        {
            this.command = new GoRegistrationCommand();
        }
    },
    GET_VACANCIES {
        {
            this.command = new GetVacanciesCommand();
        }
    },
    ONE_VACANCY {
        {
            this.command = new OneVacancyCommand();
        }
    },
    GO_WINNERS {
        {
            this.command = new GoWinnersCommand();
        }
    },
    GO_VACANCIES_HR {
        {
            this.command = new GoVacanciesHRCommand();
        }
    },
    GO_ADD_VACANCY {
        {
            this.command=new GoAddVacancyCommand();
        }
    },
    ADD_VACANCY {
        {
            this.command=new AddVacancyCommand();
        }
    },
    GO_HR_PROPOSALS {
        {
            this.command = new GoHRProposalsCommand();
        }
    },
    GO_HR_PREVIEWS {
        {
            this.command = new GoHRPreviewsCommand();
        }
    },
    GO_HR_TECH_INTERVIEWS {
        {
            this.command = new GoHRTechInterviewsCommand();
        }
    },
    HANDLE_WINNER {
        {
            this.command = new HandleWinnerCommand();
        }
    },
    GO_HR_PROFILE{
        {
            this.command=new GoHRProfileCommand();
        }
};
    ActionCommand command;
    public ActionCommand getCurrentCommand() { return command; }
}