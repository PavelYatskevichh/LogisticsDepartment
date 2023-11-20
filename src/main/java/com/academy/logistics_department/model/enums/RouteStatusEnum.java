package com.academy.logistics_department.model.enums;

public enum RouteStatusEnum {
    CURRENT,
    COMPLETED;

    public static RouteStatusEnum valueOf(int num){
        for (RouteStatusEnum item : values()) {
            if (num == item.ordinal()) {
                return item;
            }
        }

        return null;
    }
}
