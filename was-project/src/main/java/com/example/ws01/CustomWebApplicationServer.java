package com.example.ws01;

import com.example.calculator.Calculator;
import com.example.calculator.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * packageName    : com.example.ws01
 * fileName       : CustomWebApplication
 * author         : swch
 * date           : 2022-09-21
 * description    :
 */
public class CustomWebApplicationServer {

    private final int port;

    // Step3. Thead Pool 적용
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {  // 해당 port로 서버 소켓을 생성
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {    // 서버 소켓이 클라이언트를 기다림
                logger.info("[CustomWebApplicationServer] client connected.");

                /**
                 * 1. 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */
//                try (InputStream is = clientSocket.getInputStream();
//                     OutputStream os = clientSocket.getOutputStream()) {
//                    // inputstream을 reader로 변환. 라인별로 읽기 위해서.
//                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
//                    DataOutputStream dos = new DataOutputStream(os);
//
////                    String line = "";
////                    while ((line = br.readLine()) != "") {
////                        System.out.println(line);
////                    }
//                    HttpRequest httpRequest = new HttpRequest(br);
//                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
//                        QueryStrings queryStrings = httpRequest.getQueryStrings();
//
//                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
//                        String operator = queryStrings.getValue("operator");
//                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
//
//                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//                        byte[] body = String.valueOf(result).getBytes();
//
//                        HttpResponse httpResponse = new HttpResponse(dos);
//                        httpResponse.response200Header("application/json", body.length);
//                        httpResponse.responseBody(body);
//                    }
//
//                }
//              Step1의 문제점은 메인 Thread가 클라이언트의 요청을 처리하고 있을때 다른 클라이언트의 요청이 발생할 경우 처리중인 요청을 끝날때까지 기다려야 함.
//              Step2는 요구사항 1의 코드를 ClientRequestHandler 클래스를 만들어 줌
//                new Thread(new ClientRequestHandler(clientSocket)).start();
//              Step2의 문제점은 사용자가 들어올때마다 Thread를 새로 생성해 메모리가 계속적으로 할당되기 때문에 문제가 발생함.
//              그래서 Thread를 고정된 개수만큼 생성해놓고 그것들을 재활용하는 개념인 Thread Pool을 사용해야 함.
                // Step3
                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
