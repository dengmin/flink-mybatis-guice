package com.baieapp.properties;

import com.google.inject.name.Named;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.guice.datasource.druid.DruidDataSourceProvider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

/**
 * @Author dengmin
 * @Created 2020/3/22 09:49
 */
public class SystemProperties extends Properties {

    private static final String MYBATIS_ENVIRONMENT_ID = "mybatis.environment.id";

    public static final String MAPPER_PACKAGE = "mybatis.mapperScan";

    public SystemProperties() {
        initProperties();
    }

    private void initProperties() {
        setProperty(MYBATIS_ENVIRONMENT_ID, PropertiesManager.getString(MYBATIS_ENVIRONMENT_ID));
        setProperty(MAPPER_PACKAGE, PropertiesManager.getString(MAPPER_PACKAGE));
        Method[] methods = DruidDataSourceProvider.class.getMethods();
        Arrays.stream(methods).forEach(method -> {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            Arrays.stream(parameterAnnotations).flatMap(Arrays::stream)
                    .filter(annotation -> annotation instanceof Named)
                    .map(annotation -> (Named)annotation)
                    .map(Named::value)
                    .forEach(key -> {
                        String value = PropertiesManager.getString(key);
                        if(StringUtils.isNotEmpty(value)){
                            setProperty(key, value);
                        }
                    });
        });
    }
}
