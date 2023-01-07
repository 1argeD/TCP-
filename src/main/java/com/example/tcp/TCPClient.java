package com.example.tcp;

import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.Request;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) throws Exception{

        Socket s = new Socket("localhost", 50000);
        System.out.println("클라이언트 : 서버와 접속");

        OutputStream o  = s.getOutputStream();
        PrintStream p = new PrintStream(o);
        p.println("서버 하이");
        System.out.println("클라이언트 : 서버로 인삿말 출력");
        p.flush();

        InputStream is = s.getInputStream();
        Scanner sc = new Scanner(is);
        System.out.println("[클라이언트 :  서버로 부터 받은 인삿말 ===" + sc.nextLine() + "===]");

        s.close();
        System.out.println("클라이언트와 접속 해제");


    }
}
