package com.company;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class CensusAnalyserTest {
        ReadOperations readObj = new ReadOperations();
        String fileName = "IndianStateCensusData";


        /**
         * Purpose : Given the State Census CSV File when correct but type incorrect
         * Return a Custom Exception
         */
        @Test
        public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException()  {
            String filePathRead = "./src/main/resources/IndianStateCensusData.pdf";

            try {
                int count = readObj.readDataCount(filePathRead, fileName);
                Assert.assertEquals(29, count);
            }  catch (StateSensorAnalyserException e) {
                e.printStackTrace();
            }
        }

        /**
         * Purpose : Given the State Census CSV File when correct but delimiter incorrect
         * Return a Custom Exception
         */
        @Test
        public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
            String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
            String delimiter = ".";
            try {
                if(delimiter.equals(","))
                    Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
                else
                    Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Purpose : Given the State Census CSV File when correct but csv header incorrect
         * Returns a Custom Exception
         */
        @Test
        public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThrowException() {
            List<String> stringName = new ArrayList<>();
            String filePathRead = "./src/main/resources/IndianStateCensusData.csv";
            stringName.add("State");
            stringName.add("Population");
            stringName.add("AreaInSqKm");
            stringName.add("Density");

            try {
                boolean flag = readObj.readHeader(filePathRead, stringName);
                if(flag)
                    Assert.assertTrue(true);
                else
                    Assert.assertFalse(false);
            } catch (IOException | StateSensorAnalyserException e) {
                e.printStackTrace();
            }
        }
    }

