package org.example;

import java.util.List;

public interface FileParser {

    public void readFile(String inputFilePath);

    public void processEachCardNumber();

    public void writeOutputFile(String outputFilePath);

}
