package org.geektimes.web.mvc.ioc;

import java.util.LinkedHashMap;
import java.util.Map;

public class IocComponentContext {
    private static Map<String, Object> componentsMap = new LinkedHashMap<>();

    public static Map<String, Object> getComponentsMap() {
        return componentsMap;
    }
}
