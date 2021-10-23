package ir.maktab.bus_ticket_reservation_system.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ir.maktab.bus_ticket_reservation_system.json_formater.CustomLocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelSchedule extends BaseEntity<Long> {

    private static final String TRAVEL_ID = "travel_id";
    private static final String TRAVEL_TIME = "travel_time";

    @Column(name = TRAVEL_ID, nullable = false, unique = true)
    private String travelId;

    private String source;

    private String destination;

    @Column(name = TRAVEL_TIME)
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime travelTime;

    private String price;

    @OneToMany(mappedBy = "flightSchedule")
    private Set<Ticket> ticket;

    @Override
    public String toString() {
        return "FlightSchedule{" +
                "destination='" + destination + '\'' +
                ", source='" + source + '\'' +
                ", flyTime=" + travelTime +
                ", price='" + price + '\'' +
                '}';
    }
}
