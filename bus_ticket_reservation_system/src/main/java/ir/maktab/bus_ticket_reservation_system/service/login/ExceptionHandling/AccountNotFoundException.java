package ir.maktab.bus_ticket_reservation_system.service.login.ExceptionHandling;

public class AccountNotFoundException extends RuntimeException {

    //private static final long serialVersionUID = 1L;

    public AccountNotFoundException() {

    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}