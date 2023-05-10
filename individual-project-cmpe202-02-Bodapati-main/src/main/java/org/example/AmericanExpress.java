package org.example;

public class AmericanExpress extends CreditCard {

    public AmericanExpress(String cardNumber) {
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

            if (cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')){
                return "AmericanExpress";
            }
        }
        catch (Exception e){
            return "Invalid";
        }

        return "Invalid: Not a possible card number";
    }
}
