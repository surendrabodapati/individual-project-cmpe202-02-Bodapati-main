package org.example;

import netscape.javascript.JSObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONFileParser implements FileParser{


    ArrayList<String> inputCardNumberRecords = new ArrayList<>();
    ArrayList<String> outputCardNumberRecords = new ArrayList<>();

    @Override
    public void readFile(String inputFilePath) {

        try{
            Object obj = new JSONParser().parse(new FileReader(inputFilePath));
            JSONArray jsonArray = (JSONArray) obj;

            for(Object o: jsonArray){
                JSONObject jsonObject = (JSONObject) o;
                String cardNumber = (String) jsonObject.get("cardNumber");
                inputCardNumberRecords.add(cardNumber);
            }

            //System.out.println(inputCardNumberRecords);



        }catch (FileNotFoundException e){
            System.out.println(1);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(2);
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println(3);
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(3);
            e.printStackTrace();
        }

        //Object obj = parser.parse(new FileReader(inputFilePath));
        //JSONObject jsonObject = (JSONObject) obj;


    }

    @Override
    public void processEachCardNumber() {

        System.out.println("ProcessEachCardNumber JSONParser");

        CreditCardFactory creditCardFactory = new CreditCardFactoryImplementation();

        try {

            for (int i = 0; i < inputCardNumberRecords.size(); i++) {

                String cardNumber = inputCardNumberRecords.get(i);
                if (cardNumber!=null && cardNumber.length() < 19 ) {

                    if (cardNumber.equals("")) {
                        outputCardNumberRecords.add(cardNumber + "," + "Invalid: empty/null card number");
                    } else if (!cardNumber.matches("[0-9]+")) {
                        outputCardNumberRecords.add(cardNumber + "," + "Invalid: non numeric characters");
                    } else {
                        CreditCard card = creditCardFactory.getCreditCard(cardNumber);

                        if (card == null) {
                            outputCardNumberRecords.add(cardNumber + "," + "Invalid: Not a possible card number");
                        } else {
                            System.out.println(cardNumber + card);
                            outputCardNumberRecords.add(cardNumber + "," + card.validateCreditCard(cardNumber));
                        }
                    }
                } else if(cardNumber!=null && cardNumber.length() > 19){
                    outputCardNumberRecords.add(cardNumber + "," + "Invalid: more than 19 digits");
                }
                else{
                    outputCardNumberRecords.add(cardNumber + "," + "Invalid: empty/null card number");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        //System.out.println(outputCardNumberRecords);
    }



    @Override
    public void writeOutputFile(String outputFilePath) {

        try{

            JSONArray jsonArray = new JSONArray();
            for(int i=0; i<outputCardNumberRecords.size();i++){
                JSONObject jsonObject = new JSONObject();
                String temp_cardInfo = outputCardNumberRecords.get(i);

                jsonObject.put("cardType" , temp_cardInfo.split(",")[1]);
                jsonObject.put("cardNumber" , temp_cardInfo.split(",")[0]);
                jsonArray.add(jsonObject);

            }
            //System.out.println(jsonArray);

            FileWriter fw = new FileWriter(outputFilePath);
            fw.write(jsonArray.toJSONString());
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
