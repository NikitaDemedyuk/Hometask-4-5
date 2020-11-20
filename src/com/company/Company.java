package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {
    private String fullName;
    private String shortName;
    private int dateActual;
    private String adress;
    private int dateFoundation;
    private int staff;
    private String auditor;
    private long phoneNumber;
    private String email;
    private String industry;
    private String activity;
    private String pathURL;

    public Company() {}

    public Company(String fullNameC, String shortNameC, int dateActualC, String adressC, int dateFoundationC, int numberStaffC, String auditorC,
                    long phoneNumberC, String emailC, String industryC, String activityC, String pathURLC) {
        dateActual = dateActualC;
        shortName = shortNameC;
        fullName = fullNameC;
        adress = adressC;
        dateFoundation = dateFoundationC;
        staff = numberStaffC;
        auditor = auditorC;
        phoneNumber = phoneNumberC;
        email = emailC;
        industry = industryC;
        activity = activityC;
        pathURL = pathURLC;
    }

    public static List<List<String>> readUsingFileReader(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> stringList = new ArrayList();
        while ((line = br.readLine()) != null) {
            stringList.add(line);
        }
        br.close();
        fr.close();
        String delimeter = ";";
        List<List <String>> stringListD = new ArrayList();
        for (int i = 0; i < stringList.size(); ++i) {
            stringListD.add(Arrays.asList(stringList.get(i).split(delimeter)));
        }
        return stringListD;
    }

    public static List<Company> goToListCompany(List<List<String>> listStringD) throws IOException {
        List<Company> companyList = new ArrayList<>();
        for (int i = 0; i < listStringD.size(); ++i) {
            Company company = new Company(listStringD.get(i).get(0), listStringD.get(i).get(1), Integer.parseInt(listStringD.get(i).get(2)), listStringD.get(i).get(3), Integer.parseInt(listStringD.get(i).get(4)), Integer.parseInt(listStringD.get(i).get(5)), listStringD.get(i).get(6),
                    Long.parseLong(listStringD.get(i).get(7)), listStringD.get(i).get(8), listStringD.get(i).get(9), listStringD.get(i).get(10), listStringD.get(i).get(11));
            companyList.add(company);
        }
        return companyList;
    }

    public static void findCompany(List<Company> companyList, String company) {
        int companyFound = 0;
        for (int i = 0; i < companyList.size(); ++i) {
            if (company.equals(companyList.get(i).shortName)) {
                    System.out.println("Company: " +  companyList.get(i).fullName);
                    ++companyFound;
            }
        }
        if (companyFound == 0) {
            System.out.print("There aren't such companies in list\n");
        }
    }

    public static void findCompanyByIndustry(List<Company> companyList, String industry) {
        int companyFound = 0;
        for (int i = 0; i < companyList.size(); ++i) {
            if (industry.equals(companyList.get(i).industry)) {
                System.out.println("Company: " +  companyList.get(i).fullName);
                ++companyFound;
            }
        }
        if (companyFound == 0) {
            System.out.print("There aren't such companies in list\n");
        }
    }

    public static void findCompanyByActivity(List<Company> companyList, String activity) {
        int companyFound = 0;
        for (int i = 0; i < companyList.size(); ++i) {
            if (activity.equals(companyList.get(i).activity)) {
                System.out.println("Company: " +  companyList.get(i).fullName);
                ++companyFound;
            }
        }
        if (companyFound == 0) {
            System.out.print("There aren't such companies in list\n");
        }
    }

    /*public static void findCompanyByDateFoundation(List <Company> companyList, int minDate, int maxDate) {
        String delimeter = ".";
        List <List <String>> date = new String[companyList.size() + 1];
        for (int i = 1; i < companyList.size(); ++i) {
             date.add(companyList.get(i + 1).dateActual.split(delimeter));
        }
        for (int i = 0; i < companyList.size(); ++i) {
            if ((companyList.get(i).dateFoundation. > minDate) && (companyList.get(i).dateFoundation < maxDate)) {
                System.out.println("Company: " + companyList.get(i).fullName);
            }
        }
    }*/

    public static void findCompanyByStaff(List <Company> companyList, int min, int max) {
        for (int i = 0; i < companyList.size(); ++i) {
            if ((companyList.get(i).staff > min) && (companyList.get(i).staff < max)) {
                System.out.println("Company: " + companyList.get(i).fullName);
            }
        }
    }


}
