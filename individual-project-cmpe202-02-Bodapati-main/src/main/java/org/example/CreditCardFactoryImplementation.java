package org.example;

public class CreditCardFactoryImplementation implements CreditCardFactory{
    @Override
    public CreditCard getCreditCard(String cardNumber) {
        //System.out.println(cardNumber);
        if (cardNumber.equals("")){
            return null;
        }
       try{
           long card_number = Long.valueOf(cardNumber);
           //System.out.println(card_number);
           String value = Long.toString(card_number);

           if (value.length() <=19) {

               if (value.length() == 16 && value.charAt(0) == '5') {
                   return new MasterCard(cardNumber);
               } else if (value.length() == 16 && value.charAt(0) == '6') {
                   return new Discover(cardNumber);
               } else if (value.length() == 15 && value.charAt(0) == '3') {
                   return new AmericanExpress(cardNumber);
               } else if ((value.length() == 13 || value.length() == 16) && value.charAt(0) == '4') {
                   return new Visa(cardNumber);
               } else {
                   return null;
               }
           }
           else if(value.length() > 19){
               System.out.println("Invalid: more than 19 digits");
               return null;
           }

       } catch (Exception e) {
           return null;
       }
       return null;
    }
}
