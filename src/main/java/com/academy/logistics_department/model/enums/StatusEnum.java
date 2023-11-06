package com.academy.logistics_department.model.enums;

public enum StatusEnum {
    PROCESSING,
    WAITING_FOR_LOADING,
    ON_THE_WAY,
    DELIVERED;

    public static StatusEnum valueOf(int num){
        for (StatusEnum item : values()) {
            if (num == item.ordinal()) {
                return item;
            }
        }

        return null;
    }
}
