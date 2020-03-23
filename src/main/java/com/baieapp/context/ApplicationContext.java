package com.baieapp.context;

import com.baieapp.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @Author dengmin
 * @Created 2020/3/21 19:17
 */
public class ApplicationContext {

    private static class InjectorHolder {
        static Injector applicationContext = Guice.createInjector(new AppModule());
    }
    private ApplicationContext(){}

    private static Injector getApplicationContext() {
        return InjectorHolder.applicationContext;
    }

    public static <T> T getInstance(Class<T> type) {
        return getApplicationContext().getInstance(type);
    }

}
