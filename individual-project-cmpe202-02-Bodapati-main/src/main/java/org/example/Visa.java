package org.example;

public class Visa extends CreditCard{

    public Visa(String cardNumber){
        super(cardNumber);
    }

    @Override
    String validateCreditCard(String cardNumber) {

        if(cardNumber.equals("")){
            return "Invalid: empty/null card number";
        }
        try{
            long number = Double.valueOf(cardNumber).longValue();
            cardNumber = Long.toString(number);
            if(cardNumber.charAt(0) == '4' && (cardNumber.length() == 13 || cardNumber.length() == 16)){
                return "Visa";
            }

        }
        catch (Exception e){
            return "Invalid";
        }
        return "Invalid: Not a possible card number";
    }
}
