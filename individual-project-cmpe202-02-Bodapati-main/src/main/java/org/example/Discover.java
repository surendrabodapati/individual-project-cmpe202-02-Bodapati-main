package org.example;

public class Discover extends CreditCard{

    public Discover(String cardNumber) {
        super(cardNumber);
    }

    @Override
    String validateCreditCard(String cardNumber) {

        if (cardNumber.equals("")){
            return "Invalid: empty/null card number";
        }

        try{
            long number = Double.valueOf(cardNumber).longValue();
            cardNumber = Long.toString(number);

            if (cardNumber.charAt(0) == '6' && cardNumber.charAt(1) == '0' && cardNumber.charAt(2) == '1' && cardNumber.charAt(3)=='1'){
                return "Discover";
            }
        }
        catch (Exception e){

            return "Invalid";
        }
        return "Invalid: Not a possible card number";
    }
}
