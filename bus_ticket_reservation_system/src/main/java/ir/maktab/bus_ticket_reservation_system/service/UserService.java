package ir.maktab.bus_ticket_reservation_system.service;

import ir.maktab.bus_ticket_reservation_system.model.User;

public interface UserService {

    User findByUsername(String username);

}
