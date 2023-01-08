package com.example.tcp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

@SpringBootApplication
public class TcpServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(50000);
            System.out.println("서버포트 50000에서 시작");

            int cnt = 0;
            while (true) {
                Socket s = ss.accept();
                System.out.println("서버 클라이언트와 연결");

                InputStream is = s.getInputStream();
                Scanner sc = new Scanner(is); // 2byte 처리
                System.out.println("[====서버로부터 받은 인삿말 : " + sc.nextLine() + "====]");

                OutputStream o = s.getOutputStream();
                PrintStream p = new PrintStream(o);
                p.println("클라이언트님 하이");
                System.out.println("서버 : 클라이언트로 인사 출력");
                p.flush();//버퍼의 데이터르 한 번에 쏟아냄.

                InputStream create = s.getInputStream();

                s.close();
                System.out.println("[서버 : "
                        + s.getInetAddress().getHostAddress()
                        + "클라이언트와의 연결 해제]");
                if (cnt > 5) {
                    ss.close();
                    System.out.println("서버 종료");
                }
                cnt += 1;
            }
        } catch (IOException error) {
            error.printStackTrace();//에러 원인 확인
        }

//        String path = "C:\\Program Files\\새폴더";
//        File Folder = new File(path);
//
//        if (!Folder.exists()) {
//            try {
//                Folder.mkdir();
//                System.out.println("폴더 생성");
//            }
//            catch (Exception exception) {
//                exception.getStackTrace();
//            }
//        } else {
//            System.out.println("이미 폴더가 존재합니다.");
//        }
//    }
    }
}
