package com.example.ws01;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpHeaders;

/**
 * packageName    : com.example.ws01
 * fileName       : HttpRequest
 * author         : swch
 * date           : 2022-09-22
 * description    :
 */
public class HttpRequest {
    // request line
    private final RequestLine requestLine;
//    이 예제에서는 필요없음
//    // header
//    private final HttpHeaders httpHeaders;
//    // body
//    private final Body body;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());   // br.readLine()은 request line의 첫번째 줄
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchPath(String requestPath) {
        return requestLine.matchPath(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
