package com.dealership;

import java.math.BigDecimal;

public class SalesContract extends Contract {
    private BigDecimal taxAmount;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean financeOption;
    private BigDecimal vehiclePrice;


    public SalesContract(String dateOfContract,
                         String customerName,
                         String customerEmail,
                         Vehicle vehicleSold,
                         BigDecimal vehiclePrice,
                         boolean financeOption) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;
        this.vehiclePrice = vehiclePrice;
        this.recordingFee = new BigDecimal("100.00");
        this.taxAmount = vehiclePrice.multiply(new BigDecimal("0.05"));
        if (vehiclePrice.compareTo(new BigDecimal("10000")) < 0) {
            this.processingFee = new BigDecimal("295");
        } else {
            this.processingFee = new BigDecimal("495");
        }


    }


    @Override
    public BigDecimal getTotalPrice() {
        return vehiclePrice.add(recordingFee).add(taxAmount).add(processingFee);


    }

    @Override
    public BigDecimal getMonthlyPayment() {

        if (!financeOption) {
            return new BigDecimal("0.00");
        } else {

            double interestRate;
            int months;

            if (vehiclePrice.compareTo(new BigDecimal("10000")) >= 0) {
                interestRate = 0.0425;
                months = 48;
            } else {
                interestRate = 0.0525;
                months = 24;
            }

            double principal = getTotalPrice().doubleValue();
            double monthlyRate = interestRate / 12;

            double payment = principal * monthlyRate /
                    (1 - Math.pow(1 + monthlyRate, -months));

            return BigDecimal.valueOf(payment);
        }
    }
}

