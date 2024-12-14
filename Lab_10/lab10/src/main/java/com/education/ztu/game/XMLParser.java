package com.education.ztu.game;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLParser {
    public void parseXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            document.getDocumentElement().normalize();

            NodeList students = document.getElementsByTagName("student");

            for (int i = 0; i < students.getLength(); i++) {
                Node studentNode = students.item(i);

                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element student = (Element) studentNode;
                    String name = student.getElementsByTagName("name").item(0).getTextContent();
                    String age = student.getElementsByTagName("age").item(0).getTextContent();

                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element school = document.createElement("school");
            document.appendChild(school);

            Element student = document.createElement("student");
            school.appendChild(student);

            Element name = document.createElement("name");
            name.appendChild(document.createTextNode("Anna"));
            student.appendChild(name);

            Element age = document.createElement("age");
            age.appendChild(document.createTextNode("17"));
            student.appendChild(age);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            System.out.println("XML file saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parseXML("students.xml");
        parser.saveXML("new_students.xml");
    }
}
