package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String FILE_PART_ONE = "src/com/company/data_part1.txt";
        String FILE_PART_TWO = "src/com/company/data_part2.txt";

        partOne(FILE_PART_ONE);
        partTwo(FILE_PART_TWO);
    }

    private static void partOne(String filepath) {
        System.out.println("//Part one");

        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            int counterCorrectPassword = 0;


//            Part one
            while (line != null) {
                // read next line
                line = reader.readLine();

                String[] splittedString = line.split(":");

                String occuranceFirstPart = splittedString[0]; // 2-3 w
                String occuranceSecondPart = splittedString[1]; // cccnvccccchjslcghccc

                String[] searchQuote = occuranceFirstPart.split(" ");

                String searchQuoteNumbers = searchQuote[0]; // 2-3
                String searchQuoteLetter = searchQuote[1]; // w

                int minSearchQuote = Integer.parseInt(searchQuoteNumbers.split("-")[0]); // 2
                int maxSearchQuote = Integer.parseInt(searchQuoteNumbers.split("-")[1]); // 3


                if (occuranceSecondPart.contains(searchQuoteLetter)) { // check if in string
                    int counterKarakters = 0;
                    Character searchQuoteLetterChar = searchQuoteLetter.charAt(0);

                    for (Character currentChar : occuranceSecondPart.toCharArray()) { // loop through each karakter
                        if (currentChar == searchQuoteLetterChar) {
                            counterKarakters++;
                        }
                    }

                    if (counterKarakters <= maxSearchQuote && counterKarakters >= minSearchQuote) { // password correct
                        counterCorrectPassword++;
                        System.out.printf("Valid Password: %s, occurrences: %d%n", occuranceSecondPart, counterKarakters);
                    }
                }

                System.out.printf("Correct passwords: %d%n", counterCorrectPassword);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void partTwo(String filepath) {
        System.out.println("//Part two");
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            int counterCorrectPassword = 0;

            //            Part 2
            while (line != null) {
                // read next line
                line = reader.readLine();

                String[] splittedString = line.split(":");

                String occuranceFirstPart = splittedString[0]; // 2-3 w
                String occuranceSecondPart = splittedString[1]; // cccnvccccchjslcghccc

                String[] searchQuote = occuranceFirstPart.split(" ");

                String searchQuoteNumbers = searchQuote[0]; // 2-3
                String searchQuoteLetter = searchQuote[1]; // w

                int minSearchQuote = Integer.parseInt(searchQuoteNumbers.split("-")[0]); // 2
                int maxSearchQuote = Integer.parseInt(searchQuoteNumbers.split("-")[1]); // 3


                if (occuranceSecondPart.contains(searchQuoteLetter)) { // check if in string
                    char searchQuoteLetterChar = searchQuoteLetter.charAt(0); // w as char
                    char[] charArray = occuranceSecondPart.toCharArray();

                    if (searchQuoteLetterChar == charArray[minSearchQuote] && searchQuoteLetterChar != charArray[maxSearchQuote] ||
                            searchQuoteLetterChar == charArray[maxSearchQuote] && searchQuoteLetterChar != charArray[minSearchQuote]) { // password correct
                        counterCorrectPassword++;
                        System.out.printf("Valid Password: %s,\n with char: %s,\n min: %d-%s,\n max: %d-%s\n\n", occuranceSecondPart, searchQuoteLetterChar, minSearchQuote, charArray[minSearchQuote], maxSearchQuote, charArray[maxSearchQuote]);
                    }
                }

                System.out.printf("Correct passwords: %d%n", counterCorrectPassword);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
