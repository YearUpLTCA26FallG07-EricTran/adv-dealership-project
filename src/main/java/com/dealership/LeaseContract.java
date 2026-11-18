
package com.dealership;

import java.math.BigDecimal;

public class LeaseContract extends Contract {

    private BigDecimal vehiclePrice;
    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;

    public LeaseContract(String dateOfContract, String customerName,
                         String customerEmail, Vehicle vehicleSold,
                         BigDecimal vehiclePrice) {

        super(dateOfContract, customerName, customerEmail, vehicleSold);

        this.vehiclePrice = vehiclePrice;
        this.expectedEndingValue = vehiclePrice.multiply(new BigDecimal("0.50"));
        this.leaseFee = vehiclePrice.multiply(new BigDecimal("0.07"));
    }

    public BigDecimal getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(BigDecimal vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public BigDecimal getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(BigDecimal expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return expectedEndingValue.add(leaseFee);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        double principal = getTotalPrice().doubleValue();

        double interestRate = 0.04;
        int months = 36;

        double monthlyRate = interestRate / 12;

        double payment = principal * monthlyRate /
                (1 - Math.pow(1 + monthlyRate, -months));

        return BigDecimal.valueOf(payment);
    }
}
