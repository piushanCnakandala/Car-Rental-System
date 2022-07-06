package lk.Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rates {
    @Id
    private String rateId;
    private double dailyRate;
    private String freeKmForADay;
    private double monthlyRate;
    private String freeKmForAMonth;
    private double pricePerExtraKm;

    public Rates() {
    }

    public Rates(String rateId, double dailyRate, String freeKmForADay, double monthlyRate, String freeKmForAMonth, double pricePerExtraKm) {
        this.rateId = rateId;
        this.dailyRate = dailyRate;
        this.freeKmForADay = freeKmForADay;
        this.monthlyRate = monthlyRate;
        this.freeKmForAMonth = freeKmForAMonth;
        this.pricePerExtraKm = pricePerExtraKm;
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getFreeKmForADay() {
        return freeKmForADay;
    }

    public void setFreeKmForADay(String freeKmForADay) {
        this.freeKmForADay = freeKmForADay;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public String getFreeKmForAMonth() {
        return freeKmForAMonth;
    }

    public void setFreeKmForAMonth(String freeKmForAMonth) {
        this.freeKmForAMonth = freeKmForAMonth;
    }

    public double getPricePerExtraKm() {
        return pricePerExtraKm;
    }

    public void setPricePerExtraKm(double pricePerExtraKm) {
        this.pricePerExtraKm = pricePerExtraKm;
    }
}
