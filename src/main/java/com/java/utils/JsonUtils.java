package com.java.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T toObject(Reader json, Class<T> cls) {
        try {
            return MAPPER.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(InputStream json, Class<T> cls) {
        try {
            return MAPPER.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object o){
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}