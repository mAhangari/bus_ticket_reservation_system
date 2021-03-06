package ir.maktab.bus_ticket_reservation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BusTicketReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusTicketReservationSystemApplication.class, args);
    }

}
