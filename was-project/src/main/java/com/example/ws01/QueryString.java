package com.example.ws01;

/**
 * packageName    : com.example
 * fileName       : QueryString
 * author         : swch
 * date           : 2022-09-22
 * description    :
 */
public class QueryString {

    private final String key;
    private final String value;

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean exist(String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.value;
    }
}
