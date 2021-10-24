package ir.maktab.bus_ticket_reservation_system.service.login;

import ir.maktab.bus_ticket_reservation_system.model.User;
import ir.maktab.bus_ticket_reservation_system.service.login.ExceptionHandling.AccountLoginLimitReachedException;
import ir.maktab.bus_ticket_reservation_system.service.login.ExceptionHandling.AccountRevokedException;

public abstract class LoginServiceState {
    public final User login(LoginServiceContext context, User account, String password) {

        if (account.passwordMatches(password)) {
            if (account.isLoggedIn())
                throw new AccountLoginLimitReachedException();
            if (account.isRevoked())
                throw new AccountRevokedException();
            account.setLoggedIn(true);
            context.setState(new AwaitingFirstLoginAttempt());
        } else
            handleIncorrectPassword(context, account, password);

        return account;
    }

    public abstract void handleIncorrectPassword(LoginServiceContext context,
                                                 User account, String password);
}