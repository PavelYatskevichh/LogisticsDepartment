package com.academy.logistics_department.model.enums;

public enum ApplicationStatusEnum {
    PROCESSING,
    WAITING_FOR_LOADING,
    ON_THE_WAY,
    DELIVERED;

    public static ApplicationStatusEnum valueOf(int num){
        for (ApplicationStatusEnum item : values()) {
            if (num == item.ordinal()) {
                return item;
            }
        }

        return null;
    }
}
