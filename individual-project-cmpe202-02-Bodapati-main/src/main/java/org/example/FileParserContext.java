package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class FileParserContext {
    private FileParser fileParser;

    public void FileParserContext(){}
    public void executeFileParser(String inputFilePath, String outputFilePath){

        //Getting the file extensions of Input and output Files
        String inputFilePathExtension = inputFilePath.substring(inputFilePath.lastIndexOf('.'));
        String outputFilePathExtension = outputFilePath.substring(outputFilePath.lastIndexOf('.'));

        //System.out.println(inputFilePathExtension + "   "+ outputFilePathExtension);

        // Checking given input and output file names are same or not
        if(!inputFilePathExtension.equals(outputFilePathExtension)){
            System.out.println("Given Input and output paths are different");
            return;
        }

        try{

            if (inputFilePathExtension.equals(".csv")){
                fileParser = new CSVFileParser();
            } else if (inputFilePathExtension.equals(".json")) {
                fileParser = new JSONFileParser();
            } else if (inputFilePathExtension.equals(".xml")) {
                fileParser = new XMLFileParser();
            }
            else {
                System.out.println("This File Extension is not supported please: " + inputFilePath);
                System.out.println("Please Enter the file path in CSV/JSON/XML formats");
                return;
            }

            fileParser.readFile(inputFilePath);
            fileParser.processEachCardNumber();
            fileParser.writeOutputFile(outputFilePath);
        }
        catch (Exception e){
            System.out.println("Error:" + e);
            return;
        }
    }
}
