package by.bsu.hr.command;

/**
 * Enum of all commands
 */
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
            this.command = new GoUserProfileCommand();
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
    GO_APPROVED {
        {
            this.command = new GoApprovedCommand();
        }
    },
    ADD_ADMIN {
        {
            this.command = new AddAdminCommand();
        }
    },
    GO_ADD_VACANCY {
        {
            this.command = new GoAddVacancyCommand();
        }
    },
    ADD_VACANCY {
        {
            this.command = new AddVacancyCommand();
        }
    },
    CLOSE_VACANCY {
        {
            this.command = new CloseVacancyCommand();
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
    GO_HR_PREVIEWS_FULL {
        {
            this.command = new GoHRPreviewsFullCommand();
        }
    },
    GO_HR_TECH_INTERVIEWS {
        {
            this.command = new GoHRTechInterviewsCommand();
        }
    },
    GO_HR_TECH_INTERVIEWS_FULL {
        {
            this.command = new GoHRTechInterviewsFullCommand();
        }
    },
    CLOSE_INTERVIEW {
        {
            this.command = new CloseInterviewCommand();
        }
    },
    ADD_APPROVED {
        {
            this.command = new AddApprovedCommand();
        }
    },
    HANDLE_APPROVED {
        {
            this.command = new HandleApprovedCommand();
        }
    },
    ADD_INTERVIEW {
        {
            this.command = new AddInterviewCommand();
        }
    },
    GO_APPOINT_INTERVIEW {
        {
            this.command = new GoAppointInterviewCommand();
        }
    },
    GO_ADD_INTERVIEW_RESULT {
        {
            this.command = new GoAddInterviewResultCommand();
        }
    },
    ADD_INTERVIEW_RESULT {
        {
            this.command = new AddInterviewResultCommand();
        }
    },
    GO_HR_PROFILE {
        {
            this.command = new GoHRProfileCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}