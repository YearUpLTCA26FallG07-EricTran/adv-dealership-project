package com.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

     String filename = "contracts.csv";

    public void saveContract(Contract contract) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, true))) {

            String contractData = "";

            if (contract instanceof SalesContract) {

                SalesContract salesContract = (SalesContract) contract;

                Vehicle vehicle = salesContract.getVehicleSold();

                String financeOption = salesContract.isFinanceOption() ? "YES" : "NO";

                contractData = "SALE|" +
                        salesContract.getDateOfContract() + "|" +
                        salesContract.getCustomerName() + "|" +
                        salesContract.getCustomerEmail() + "|" +
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        salesContract.getVehiclePrice() + "|" +
                        salesContract.getTaxAmount() + "|" +
                        salesContract.getRecordingFee() + "|" +
                        salesContract.getProcessingFee() + "|" +
                        salesContract.getTotalPrice() + "|" +
                        financeOption + "|" +
                        salesContract.getMonthlyPayment();

            } else if (contract instanceof LeaseContract) {

                LeaseContract leaseContract = (LeaseContract) contract;

                Vehicle vehicle = leaseContract.getVehicleSold();

                contractData = "LEASE|" +
                        leaseContract.getDateOfContract() + "|" +
                        leaseContract.getCustomerName() + "|" +
                        leaseContract.getCustomerEmail() + "|" +
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        leaseContract.getVehiclePrice() + "|" +
                        leaseContract.getExpectedEndingValue() + "|" +
                        leaseContract.getLeaseFee() + "|" +
                        leaseContract.getTotalPrice() + "|" +
                        leaseContract.getMonthlyPayment();
            }

            writer.write(contractData);
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}