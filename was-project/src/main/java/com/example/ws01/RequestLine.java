package com.example.ws01;

import java.util.Objects;

/**
 * packageName    : com.example
 * fileName       : RequestLine
 * author         : swch
 * date           : 2022-09-22
 * description    :
 */
public class RequestLine {

    private final String method;
    private final String urlPath;
    private QueryStrings queryStrings;


    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    // GET /calculate?operand1=11&operator=+&operand2=33 HTTP/1.1 이런 식의 request line을 받음
    public RequestLine(String line) {
        String[] tokens = line.split(" ");
        this.method = tokens[0];    // GET

        String[] urlPathTokens = tokens[1].split("\\?");    // /calculate?operand1=11&operator=+&operand2=33
        this.urlPath = urlPathTokens[0];    // /calculate
        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);    // operand1=11&operator=+&operand2=33
        }
    }


    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return requestPath.equals(this.urlPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

}
