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
import org.w3c.dom.NodeList;

/**
 *
 * @author Administrator
 */
public class ConnectXml {

    public static int[] readXml(String filePath, String fileName) {
        int[] back=new int[3];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(filePath + "info.xml");
            Document doc = db.parse(file);
            Element root = doc.getDocumentElement();
            NodeList nl = root.getElementsByTagName(fileName);
            for (int i = 0; i < nl.getLength(); i++) {
                Element task = (Element) nl.item(i);
                
                for (int k = 0; k < 3; k++) {
                    back[k] = Integer.getInteger(task.getAttribute("thread" + k));
                }
                System.out.println("DownLoad.ConnectXml.readXml()");
            }

        } catch (Exception ex) {
        }
        return back;
    }

    public static void writeToXml(int[] current, String filePath, String fileName) {
           try{
               DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
               DocumentBuilder db = dbf.newDocumentBuilder();
               Document doc = null;
               File file = new File(filePath+"info.xml");
               if (!file.exists()) {
                file.createNewFile();
                doc = db.newDocument();
                Element roott = doc.createElement("Task-info");
                doc.appendChild(roott);
                }
               else{
                 doc = db.parse(file);
               }
               doc.setXmlVersion("1.0");
               doc.setXmlStandalone(true);
               
               Element root = doc.getDocumentElement();
               Element task = doc.createElement(fileName);
               for(int i=0;i<3;i++){
                   task.setAttribute("thread"+i,current[i]+"");
               }
               root.appendChild(task);
               TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transFormer = transFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            
            FileOutputStream out = new FileOutputStream(file);
            StreamResult xmlResult = new StreamResult(out);
            
            transFormer.setOutputProperty("{/encoding/}", "UTF-8/");
            transFormer.setOutputProperty(OutputKeys.INDENT, "yes");  
            transFormer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transFormer.transform(domSource, xmlResult);
           }catch(Exception ex){
           }
    }


}
