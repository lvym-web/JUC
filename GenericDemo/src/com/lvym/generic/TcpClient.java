package com.lvym.generic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //使用Socket对象中的方法getOutputStream()获取网络字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //向服务器发送数据
        outputStream.write("Hello,服务器".getBytes());
        //利用Socket获得输入流读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024*1];
        int len= inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        //关闭链接
        socket.close();

    }
}
