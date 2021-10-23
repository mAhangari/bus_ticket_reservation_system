package ir.maktab.bus_ticket_reservation_system.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Wallet.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wallet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet_table";
    private static final String TOTAL_AMOUNT = "total_amount";
    private static final String CREDIT_AMOUNT = "credit_amount";
    private static final String CASH_AMOUNT = "cash_amount";

    @Column(name = TOTAL_AMOUNT)
    @Setter(AccessLevel.NONE)
    private Double totalAmount = 0D;

    @Column(name = CREDIT_AMOUNT)
    private Double creditAmount = 0D;

    @Column(name = CASH_AMOUNT)
    private Double cashAmount = 0D;

    public void setCashAmount(Double cashAmount){
        this.cashAmount = cashAmount;
        this.totalAmount = this.cashAmount + this.creditAmount;
    }

    public void setCreditAmount(Double creditAmount){
        this.creditAmount = creditAmount;
        this.totalAmount = this.creditAmount + this.cashAmount;
    }

}
