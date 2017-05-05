/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DownLoad.ConnectXml;
import java.io.File;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
      int[] a = {1,2,3};
       String filePath="C:\\Users\\hzu\\Desktop\\";
        String fileName="test.exe";
        a=ConnectXml.readXml(filePath, fileName);
         System.out.println("test");
        System.out.println(a[0]+""+a[1]+""+a[2]);
    }
}
