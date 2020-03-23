package com.baieapp.properties;

/**
 * @Author dengmin
 * @Created 2020/3/21 19:13
 */
public class SystemPropertyHolder implements PropertyHolder {
    @Override
    public String getValue(String key) {
        String property = System.getenv(key);
        if (property != null) return property;
        property = System.getProperty(key);
        return property;
    }
}
