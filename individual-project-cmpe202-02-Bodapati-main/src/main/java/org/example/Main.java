package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {

            String inputFilePath = args[0];
            String outputFilePath = args[1];

            FileParserContext fpc = new FileParserContext();

            fpc.executeFileParser(inputFilePath, outputFilePath);
        }
        catch (Exception e){
            System.out.println("Error:" + e);
        }
    }
}