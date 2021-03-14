package org.geektimes.projects.user.validator.bean.validation;

import java.util.HashMap;
import java.util.Map;

public class ValidResult {
    private int resultCode;

    private final Map<String, String> resultMap = new HashMap<>();

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

//    public void setResultMap(Map<String, String> resultMap) {
//        this.resultMap = resultMap;
//    }
}
