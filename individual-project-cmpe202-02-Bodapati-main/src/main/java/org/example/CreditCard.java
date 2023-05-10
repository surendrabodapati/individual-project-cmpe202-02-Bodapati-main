package org.example;

abstract class CreditCard {
    public String cardNumber;

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }
    abstract String validateCreditCard(String cardNumber);
}
