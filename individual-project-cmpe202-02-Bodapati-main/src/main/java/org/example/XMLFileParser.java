package org.example;

import org.w3c.dom.*;
import org.xml.sax.SAXParseException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLFileParser implements FileParser{

    private List<String> inputCardNumberRecords = new ArrayList<>();
    private List<String> outputCardNumberRecords = new ArrayList<>();
    @Override
    public void readFile(String inputFilePath) {

        try{
            File f = new File(inputFilePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFilePath);
            NodeList cardInfoData = doc.getElementsByTagName("CARD");
            for(int i=0; i<cardInfoData.getLength();i++){
                Node cardInfo = cardInfoData.item(i);
                if(cardInfo.getNodeType() == Node.ELEMENT_NODE){
                    Element card = (Element) cardInfo;
                    inputCardNumberRecords.add(card.getElementsByTagName("CARD_NUMBER").item(0).getTextContent());
                }
            }

        }catch(SAXParseException sax){
            System.out.println("Error with & or any special character:"+sax);

        }catch (ParserConfigurationException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void processEachCardNumber() {

        System.out.println("ProcessEachRecord XML");
        CreditCardFactory creditCardFactory = new CreditCardFactoryImplementation();
        //System.out.println(inputCardNumberRecords);
        try {
            for (int i = 0; i < inputCardNumberRecords.size(); i++) {

                String cardNumber = inputCardNumberRecords.get(i);

                if (cardNumber.length() < 19) {

                    if (cardNumber.equals("")) {
                        outputCardNumberRecords.add(cardNumber + "," + "Invalid: empty/null card number");
                    } else if (!cardNumber.matches("[0-9]+")) {
                        outputCardNumberRecords.add(cardNumber + "," + "Invalid: non numeric characters");
                    } else {
                        CreditCard card = creditCardFactory.getCreditCard(cardNumber);

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
            //System.out.println(outputCardRecords);
        }
            catch (Exception e){
             System.out.println(e);
            }
        System.out.println(outputCardNumberRecords);
    }

    @Override
    public void writeOutputFile(String outputFilePath) {

        String CARD_NUMBER;
        String CARD_TYPE;

        try{
            File f = new File(outputFilePath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.newDocument(); //create temp
            Element root = doc.createElement("CARDS");
            doc.appendChild(root);
            for(int i=0;i<outputCardNumberRecords.size();i++){
                Element cards = doc.createElement("CARD");
                String temp_card_number = outputCardNumberRecords.get(i);
                Element card_number = doc.createElement("CARD_NUMBER");
                card_number.appendChild(doc.createTextNode(temp_card_number.split(",")[0]));
                Element card_type = doc.createElement("CARD_TYPE");
                card_type.appendChild(doc.createTextNode(temp_card_number.split(",")[1]));
                cards.appendChild(card_number);
                cards.appendChild(card_type);
                root.appendChild(cards);
            }

            FileOutputStream output = new FileOutputStream(outputFilePath);
            writeXml(doc, output);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }

}
