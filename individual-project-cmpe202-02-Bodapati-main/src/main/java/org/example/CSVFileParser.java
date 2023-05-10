package org.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class CSVFileParser implements FileParser{

    private List<String> inputCardNumberRecords = new ArrayList<>();
    private List<String> outputCardNumberRecords = new ArrayList<>();
    @Override
    public void readFile(String inputFilePath) {
        try {

            Scanner sc = new Scanner(new File(inputFilePath));
            while (sc.hasNextLine()){
                inputCardNumberRecords.add(sc.nextLine());
            }
            String s = inputCardNumberRecords.get(0);
            if(s.split(",")[0].equals("cardNumber") ){
                inputCardNumberRecords.remove(0);
            }
            //System.out.println(inputCardNumberRecords);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void processEachCardNumber() {

        System.out.println("ProcessEachRecord Method CSV\n");

        CreditCardFactory creditCardFactory = new CreditCardFactoryImplementation();
        try {
            outputCardNumberRecords.add("cardNumber,cardType");
            for (int i = 0; i < inputCardNumberRecords.size(); i++) {

                String cardNumber = inputCardNumberRecords.get(i).split(",")[0];
                //System.out.println(cardNumber);
                if (cardNumber.length() < 19) {

                    if (cardNumber.equals("")) {
                        outputCardNumberRecords.add(cardNumber + "," + "Invalid: empty/null card number");
                    } else if (!cardNumber.matches("[0-9]+")) {
                        outputCardNumberRecords.add(cardNumber + "," + "Invalid: non numeric characters");
                    } else {
                        CreditCard card = creditCardFactory.getCreditCard(cardNumber);
                        //System.out.println(cardNumber + card);
                        if (card == null) {
                            outputCardNumberRecords.add(cardNumber + "," + "Invalid: Not a possible card number");
                        } else {
                            outputCardNumberRecords.add(cardNumber + "," + card.validateCreditCard(cardNumber));
                        }
                    }
                } else {
                    outputCardNumberRecords.add(cardNumber + "," + "Invalid: more than 19 digits");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(outputCardNumberRecords);

    }

    @Override
    public void writeOutputFile(String outputFilePath) {

        try{
            PrintWriter pw = new PrintWriter(new File(outputFilePath));


            for(String sample: outputCardNumberRecords){
                pw.println(sample);
            }
            pw.close();
        }catch (Exception e){
            System.out.println(e);
        }



    }
}
