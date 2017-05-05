/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DownLoad;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;

/**
 *
 * @author Administrator
 */
public class ConnectXml {

    public static void readXml(String filePath, String fileName) {

    }

    public static void writeToXml(int[] current, String filePath, String fileName) {

    }

    public static void buildXml(String filePath, String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            doc.setXmlVersion("1.0");
            doc.setXmlStandalone(true);
            Element root = doc.createElement("Task-info");
            root.setAttribute("ID", fileName);
            doc.appendChild(root);
            
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transFormer = transFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            File file = new File(filePath+fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file);
            StreamResult xmlResult = new StreamResult(out);
            
            transFormer.setOutputProperty("{/encoding/}", "UTF-8/");
            transFormer.setOutputProperty(OutputKeys.INDENT, "yes");  
            transFormer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transFormer.transform(domSource, xmlResult);
            System.out.println(file.getAbsolutePath());
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException ex) {
            System.out.println(ex);
        }
    }

}
