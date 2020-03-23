package com.baieapp.properties;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author dengmin
 * @Created 2020/3/21 19:05
 */
public class PropertiesManager {
    private static List<PropertyHolder> propertyHolderChain = new LinkedList<>();
    static {
        propertyHolderChain.add(new LocalPropertyHolder());
        propertyHolderChain.add(new SystemPropertyHolder());
    }

    private PropertiesManager() {
    }

    public static String getString(String key) {
        Optional<String> optional = propertyHolderChain.stream()
                .map(propertyHolder -> propertyHolder.getValue(key))
                .filter(Objects::nonNull)
                .findFirst();
        return optional.orElse(null);
    }
}
