package com.example.ws01;

import com.example.calculator.Calculator;
import com.example.calculator.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * packageName    : com.example.ws01
 * fileName       : ClientRequestHandler
 * author         : swch
 * date           : 2022-09-26
 * description    :
 */
public class ClientRequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);


    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        /**
         * Step2. 사용자 요청이 들어올때마다 Thread를 새로 생성하여 사용자 요청을 처리
         */

        logger.info("[ClientRequestHandler] new client {} started.", Thread.currentThread().getName()); // 현재 사용되는 Thread의 name 출력
        try (InputStream is = clientSocket.getInputStream();
             OutputStream os = clientSocket.getOutputStream()) {
            // inputstream을 reader로 변환. 라인별로 읽기 위해서.
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(os);

//                    String line = "";
//                    while ((line = br.readLine()) != "") {
//                        System.out.println(line);
//                    }
            HttpRequest httpRequest = new HttpRequest(br);
            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();

                HttpResponse httpResponse = new HttpResponse(dos);
                httpResponse.response200Header("application/json", body.length);
                httpResponse.responseBody(body);
            }

        } catch (IOException e) {
//            throw new RuntimeException(e);
            logger.error(e.getMessage());
        }
    }
}
