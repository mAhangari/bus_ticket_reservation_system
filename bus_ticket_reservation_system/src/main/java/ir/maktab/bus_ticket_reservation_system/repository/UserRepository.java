package ir.maktab.bus_ticket_reservation_system.repository;

import ir.maktab.bus_ticket_reservation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "FROM User u WHERE u.username=:username")
    User findByUsername(String username);

}
