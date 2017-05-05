/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DownLoad;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Administrator
 */
public class DownLoadMessage {
    public String urlLocation;
    public String filePath;
    public long contentLength;
    public String fileName;
    public HttpURLConnection conn;

    public DownLoadMessage(String url,String filePath) throws IOException{
        this.urlLocation=url;
        this.filePath=filePath;
        this.conn = getConn(urlLocation);
        this.fileName = getFileName(urlLocation);
        this.contentLength=getContentLength(urlLocation);
    }
    
    private static HttpURLConnection getConn(String urlLocation) throws IOException{
         URL url = new URL(urlLocation);
        //获取HttpURLConnection对象 打开链接
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");//设置发送get请求
        con.setConnectTimeout(5000);//设置连接超时时间
        
        return con;
    }
    
    public static String getFileName(String urlLocation){
        String fileName = urlLocation.substring(urlLocation.lastIndexOf("/"));
        return fileName;
    }
    
    public static long getContentLength(String urlLocation)throws IOException{
        HttpURLConnection conn = getConn(urlLocation);
        return conn.getContentLength();
    }
}
