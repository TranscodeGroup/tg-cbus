package com.cbus.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * json操作类
 * @author lin
 * @date 2018年7月20日
 */
public class JsonUtils {
    
    private static ObjectMapper objectMapper = null;
    
    static {
        objectMapper = new ObjectMapper();
//        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
//        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    /**
     * 对象转字符串
     * @param obj
     * @return
     */
    public static <T> String obj2Str(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 字符串转对象
     * @param str
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T str2Obj(String str, Class<T> clazz){
        //if (StringUtils.isEmpty(str) || clazz == null){
        if (str == null || str.isEmpty() || clazz == null)
            return null;
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T str2List(String str, TypeReference<T> jsonTypeReference){
        //if (StringUtils.isEmpty(str) || clazz == null){
        if (str == null || str.isEmpty() || jsonTypeReference == null)
            return null;
        try {
            return (T) objectMapper.readValue(str, jsonTypeReference);
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * 将object转换为pojo
     * @param fromValue
     * @param clazz
     * @return
     */
    public static <T> T convertObj(Object fromValue, Class<T> clazz){
        if (fromValue == null)
            return null;
        try {
            return objectMapper.convertValue(fromValue, clazz);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
