package ir.maktab.bus_ticket_reservation_system.service.login;

public abstract class LoginServiceContext {

    private LoginServiceState state;

    public LoginServiceContext(LoginServiceState state) {
        this.state = state;
    }

    public LoginServiceState getState() {
        return state;
    }

    public void setState(LoginServiceState state) {
        this.state = state;
    }

}
