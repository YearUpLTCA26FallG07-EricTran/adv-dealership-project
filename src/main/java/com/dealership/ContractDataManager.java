
package com.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    String filename  = "contracts.csv";

    public void saveContract(Contract contract) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, true))) {

            String contractData = "";

            if (contract instanceof SalesContract) {

                SalesContract salesContract = (SalesContract) contract;

                // Get vehicle information

                // Get sales contract information

                // Build CSV String

            } else if (contract instanceof LeaseContract) {

                LeaseContract leaseContract = (LeaseContract) contract;

                // Get vehicle information

                // Get lease contract information

                // Build CSV String

            }

            writer.write(contractData);
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
