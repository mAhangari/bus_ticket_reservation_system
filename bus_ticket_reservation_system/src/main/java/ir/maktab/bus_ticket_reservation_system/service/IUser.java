package ir.maktab.bus_ticket_reservation_system.service;

public interface IUser {

    boolean passwordMatches(String passwordMatches);

    boolean isLoggedIn();

    void setLoggedIn(boolean loggedIn);

    boolean isRevoked();

    void setRevoked(boolean revoked);

    String getUsername();
}