package com.lvym.generic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        //使用serverSocket.accept();获得Socket
        Socket accept = serverSocket.accept();
         //利用Socket获得输入流读取
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len= inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //利用Socket获得输出流
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("收到".getBytes());
        //释放资源
        accept.close();
        serverSocket.close();




    }
}
