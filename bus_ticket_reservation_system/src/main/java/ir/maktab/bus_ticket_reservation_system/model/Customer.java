package ir.maktab.bus_ticket_reservation_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer extends User {

	private static final String WALLET_ID = "wallet_id";

	@OneToOne
	@JoinColumn(name = WALLET_ID, unique = true)
	private Wallet wallet;

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + getFirstName() + '\'' +
				", lastName='" + getLastName() + '\'' +
				", username='" + getUsername() + '\'' +
				", userType=" + getUserType() +
				", birthDate=" + getBirthDate() +
				", nationalCode='" + getNationalCode() + '\'' +
				"wallet=" + wallet +
				'}';
	}

}
