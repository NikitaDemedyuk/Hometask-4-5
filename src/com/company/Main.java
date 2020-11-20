package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.company.Company.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = "/Users/nikita/Documents/Hometask university/Java/Hometask4-5/Text.txt";
        System.out.println(fileName + "\n");

        try (FileWriter writer = new FileWriter("TextOut.txt", false)) {

            Date date = new Date();
            DateFormat formatter = new SimpleDateFormat();
            String formattedDate = formatter.format(date);
            writer.write("Time: " + formattedDate);

            List<List<String>> stringListD = readUsingFileReader(fileName);

            for (int i = 0; i < stringListD.size(); ++i) {
                System.out.print("\n" + i + ")");
                for (int j = 0; j < stringListD.get(i).size(); ++j) {
                    System.out.print(stringListD.get(i).get(j) + "  ");
                }
            }

            List <Company> companyList = goToListCompany(stringListD);

            //System.out.print("End");
            //for (String str : args) {
            //  System.out.println("Файл = " + str);
            //}

            // printToFileData();


            System.out.print("\nShort name of company: ");
            Scanner in = new Scanner(System.in);
            String lineNameCompany = in.nextLine();
            findCompany(companyList, lineNameCompany);
            writer.write("Short name of company : " + lineNameCompany + "\n");

            System.out.print("\nIndustry of company: ");
            String lineIndustryCompany = in.nextLine();
            findCompanyByIndustry(companyList, lineIndustryCompany);
            writer.write("Industry of company : " + lineIndustryCompany + "\n");

            System.out.print("\nType of activity: ");
            String lineActivityCompany = in.nextLine();
            findCompanyByActivity(companyList, lineActivityCompany);
            writer.write("Activity of company : " + lineActivityCompany + "\n");

            try {
                System.out.print("\nEnter the date of foundation (min): ");
                int dateFoundationCompanyMin = in.nextInt();
                System.out.print("\nEnter the date of foundation (max): ");
                int dateFoundationCompanyMax = in.nextInt();
                //findCompanyByDateFoundation(companyList, dateFoundationCompanyMin, dateFoundationCompanyMax);
                writer.write("Date of foundation (min) : " + dateFoundationCompanyMin+ "\nDate of foundation (max) : " + dateFoundationCompanyMax);
            } catch (Exception e) {
                System.out.print("Error: " + e.getMessage());
            }

            try {
                System.out.print("\nEnter number of staff (min): ");
                int staffCompanyMin = in.nextInt();
                System.out.print("\nEnter number of staff (max): ");
                int staffCompanyMax = in.nextInt();
                findCompanyByStaff(companyList, staffCompanyMin, staffCompanyMax);
                writer.write("Number of staff (min) : " + staffCompanyMin+ "\nNumber of staff (max) : " + staffCompanyMax);
            } catch (Exception e) {
                System.out.print("Error: " + e.getMessage());
            }
        }

        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
