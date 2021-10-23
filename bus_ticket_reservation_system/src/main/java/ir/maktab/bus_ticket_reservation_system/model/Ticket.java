package ir.maktab.bus_ticket_reservation_system.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.maktab.bus_ticket_reservation_system.json_formater.CustomLocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = Ticket.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity<Long> {
    public static final String TABLE_NAME = "ticket_table";
    private static final String CUSTOMER_ID = "customer_id";
    private static final String TRAVEL_TIME = "travel_time";
    private static final String TRAVEL_ID = "travel_id";
    private static final String TICKET_ID = "ticket_id";

    @ManyToOne
    @Column(name = CUSTOMER_ID, nullable = false)
    private Customer customer;

    private String source;

    private String destination;

    @Column(name = TRAVEL_TIME)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime travelTime;

    @Column(name = TRAVEL_ID)
    private String travelId;

    @Column(name = TICKET_ID)
    private String ticketId;

}
