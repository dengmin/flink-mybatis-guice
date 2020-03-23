package com.baieapp.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author dengmin
 * @Created 2020/3/21 19:01
 */
public class LocalPropertyHolder implements PropertyHolder {

    private static final String APP_PROPERTIES = "app.properties";
    private String propertiesPath;
    private volatile Properties localProperties;

    public LocalPropertyHolder() {
        this(APP_PROPERTIES);
    }

    public LocalPropertyHolder(String propertiesPath) {
        this.propertiesPath = propertiesPath;
        getLocalProperties();
    }

    @Override
    public String getValue(String key) {
        return (String)localProperties.get(key);
    }

    private void getLocalProperties(){
        if(localProperties == null){
            synchronized (this){
                if(localProperties == null){
                    localProperties = new Properties();
                    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesPath);
                    if (inputStream == null) {
                        throw new IllegalStateException("缺少:" + propertiesPath + "配置文件");
                    }
                    try {
                        localProperties.load(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
