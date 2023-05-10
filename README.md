# individual-project-cmpe202-02-Surendrababu-Bodapati: Credit Card Application

### Name: Surendrababu-Bodapati

### Student ID: 016699683

## Problem Statement

To use different design patterns to create a java application that provides the card number, expiry date, and cardholder name information. When a user submits credit card information, this application verifies the type of credit card.

The Java application validates the MasterCard, Visa, AmericanExpress, and Discover cards and accepts three different input formats: XML, JSON, and CSV. The application prompts the user for the input file directory and output file location, checks whether the credit card number is a valid in that specific file, then creates an instance of the class by looking up the credit card number's basic case. The input file must include the credit card number, name of the cardholder, and expiration date.

## Design patterns used:

### Strategy

In the strategy pattern, we design objects that represent different strategies and a context object whose behavior changes depending on the strategy object. The context object's execution algorithm is modified by the strategy object.

Here we are using strategy design pattern to parse the input file when given in different formats(XML, JSON and CSV).

### Factory

The factory method is a creational design pattern, meaning it has to do with making new objects. In the Factory design, objects are created without disclosing the creation logic to the client, and the client utilizes the same standard interface to produce a new type of object.

Here we are using Factory to get instance of credit card type for each record in the file.

## Steps to Run the Application:

1. Clone the Repository and open the project in any IDE(Ex Intellij)
2. This project is built on maven so all the dependencies in pom.xml will download automatically and any 3rd party dependencies should be downloaded manually(Ex JSONParser)
3. Run the main class by opening in any IDE and edit the configuration of the main class by passing the input and output file paths in the command line arguments
4. Once the main class execution completes, you will see the output file in the path that you have mentioned


## Part 1

#### 1. Describe what is the primary problem you try to solve?
The primary problem that I encountered is to read the file. The file contains the card number, cardholder, and expiration date information to decide the type of credit card by creating an instance of that particular credit card. Here we have subclasses Visa, Discover, AmericanExpress, and MasterCard that are all subclasses of the CreditCard, hence we use Factory Method to implement and solve the problem.
   
#### 2. Describe what are the secondary problems you try to solve (if there are any)?
The secondary problem that I encountered is to solve how to read and parse the data from different file formats. To solve this I have implemented using a strategy design pattern where we can have the same body structure with multiple algorithms.
    
#### 3. Describe what design pattern(s) you use how (use plain text and diagrams)?

##### a. I have used a Strategy design pattern to parse the file.
##### b. Implemented Factory design patterns for different types of credit cards.
  

#### 4. Describe the consequences of using this/these pattern(s)?

##### Strategy Design Pattern
By becoming decoupled from actual strategies, the context can be expanded upon or altered without affecting the code of the context or other strategies. As a result, the code now supports the CSV, XML, and JSON file formats and may be further expanded to handle any more file types by just creating a new class and adding it to the strategy pattern.

##### Factory Design pattern
The factory approach prevents client code from instantiating actual implementation classes. Our code is more resilient, less connected, and simple to extend thanks to the factory approach. Currently, the application supports MasterCard, Visa, AmericanExpress, and Discover. And can be added many making the code more robust. 

## Part 2

#### Continue with the design from Part 1 and extend it to parse different input file formats (JSON, XML, CSV) and detect the type of credit card, and then output to a file  (in the same format as the input - JSON or XML or CSV) - with each line showing the card number, type of card (if a valid card number) and an error (if the card number is not valid). The design should accommodate newer file formats for the future.

#### Design - Class Diagrams

Strategy Design Pattern
![Stratergy](https://user-images.githubusercontent.com/89657709/205791397-b69f1fb6-dd6e-4812-9276-5e6bcc73f89f.png)

Factory Design Pattern
 ![Factory](https://user-images.githubusercontent.com/89657709/205791412-9103cd3b-1887-4239-a97a-7a848b97bd97.png)


## Junits Test Cases:
<img width="1396" alt="Screenshot 2022-12-05 at 7 48 25 PM" src="https://user-images.githubusercontent.com/89657709/205808455-f16a50cc-0de9-44fb-8fc0-069f8e33716c.png">
