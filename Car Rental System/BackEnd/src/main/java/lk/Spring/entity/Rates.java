package lk.Spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Rates {
    @Id
    private String rateId;
    private double dailyRate;
    private double freeKmForADay;
    private double monthlyRate;
    private double freeKmForAMonth;
    private double pricePerExtraKm;

}
