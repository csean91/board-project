package com.example.ws01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName    : com.example.ws01
 * fileName       : QueryStrings
 * author         : swch
 * date           : 2022-09-22
 * description    : 일급 컬렉션
 */
public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String lines) {
        String[] stringTokens = lines.split("&");
        Arrays.stream(stringTokens)
                .forEach(stringToken -> {
                    String[] tokens = stringToken.split("=");
                    if (tokens.length != 2) {
                        throw new IllegalArgumentException("잘못된 QueryString 포맷입니다.");
                    }
                    queryStrings.add(new QueryString(tokens[0], tokens[1]));
                });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
                .filter(queryString -> queryString.exist(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
