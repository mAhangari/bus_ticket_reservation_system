package ir.maktab.bus_ticket_reservation_system.service.login;

import ir.maktab.bus_ticket_reservation_system.model.User;
import ir.maktab.bus_ticket_reservation_system.service.UserService;
import ir.maktab.bus_ticket_reservation_system.service.login.ExceptionHandling.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends LoginServiceContext {

    private final UserService<User> userService;

    public LoginService(@Qualifier("userServiceImpl") UserService<User> userService) {
        super(new AwaitingFirstLoginAttempt());
        this.userService = userService;
    }

    public User login(String username, String password) {
        User user = userService.findByUsername(username);

        if (user == null)
            throw new AccountNotFoundException("Account not exists");

        return getState().login(this, user, password);
    }
}