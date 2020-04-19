package com.json.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.json.exception.BadInputException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    private JsonUtil() {
        //private constructor
    }

    public static <T> String convertToJson(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
    }

    public static <T> String convertToJson(T object, boolean nonNull) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            if(nonNull)
                objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsString(object);
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
    }

    public static <T> T convertToObject(String jsonData, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(jsonData, clazz);
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
    }

    public static Map<String, Object> jsonToMap(String jsonString) {
        Map<String, Object> retMap = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            retMap = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>(){});
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
        return retMap;
    }

    public static String convertToJson(Map<String, Object> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(map);
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
    }

    public static <T> String convertToJson(List<T> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
    }

    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonString, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, clazz));
        }catch (IOException ex) {
            throw new BadInputException("The provided input is invalid !!", ex);
        }
    }
}
