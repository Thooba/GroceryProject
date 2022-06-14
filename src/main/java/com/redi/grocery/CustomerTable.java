package com.redi.grocery;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerTable {
    private final String path = "src/data/customer.csv";
    private final String splitBy = ",";
    private List<Customer> customers = new ArrayList<>();

    public CustomerTable() throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] items = line.split(splitBy);
                customers.add(new Customer(UUID.fromString(items[0]),
                                            items[1],
                                            items[2],
                                            items[3],
                                            LocalDate.parse(items[4]),
                                            Integer.parseInt(items[5])));
            }
        }  finally  {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(Customer customer) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        try {
            bufferedWriter.write(customer.toString() + System.lineSeparator());
        }  finally  {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(String email, String pass){
        return customers.stream().filter(
                cus -> email.equals(cus.getEmailId())&& pass.equals(cus.getPassword())
        ).findFirst().orElse(null);
    }

    public boolean validateEmail(String email){
        return customers.stream().anyMatch(
                cus -> email.equals(cus.getEmailId())
        );
    }
}
