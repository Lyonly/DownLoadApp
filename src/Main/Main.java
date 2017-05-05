/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DownLoad.ConnectXml;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
       // int[] a = {1,2,3};
       String filePath="C:\\Users\\Administrator\\Desktop\\";
        String fileName="tag.xml";
     //   ConnectXml.writeToXml(a, filePath, fileName);
        ConnectXml.buildXml(filePath,fileName);
    }
}
