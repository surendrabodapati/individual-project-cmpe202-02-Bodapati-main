package org.example;

public class MasterCard extends CreditCard{

    public MasterCard(String cardNumber){
        super(cardNumber);
    }

    @Override
    String validateCreditCard(String cardNumber){

        if(cardNumber.equals("")){
            return "Invalid: empty/null card number";
        }
        try {
            long number = Double.valueOf(cardNumber).longValue();
            String value = Long.toString(number);
            int b = Integer.parseInt(String.valueOf(value.charAt(1)));
            if(value.length() == 16 && (value.charAt(0) == '5' && 1 <= b && b <= 5 )){
                return "MasterCard";
            }
        }
        catch (Exception e){
            return "Invalid";
        }

        return "Invalid: Not a possible card number";
    }
}
