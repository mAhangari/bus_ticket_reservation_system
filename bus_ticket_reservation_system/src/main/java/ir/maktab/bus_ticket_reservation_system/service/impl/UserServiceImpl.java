package ir.maktab.bus_ticket_reservation_system.service.impl;

import ir.maktab.bus_ticket_reservation_system.model.User;
import ir.maktab.bus_ticket_reservation_system.repository.UserRepository;
import ir.maktab.bus_ticket_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
