package com.academy.logistics_department.model.enums;

public enum CategoryEnum {
    AM,
    B,
    BE,
    C,
    CE;

    public static CategoryEnum valueOf(int num){
        for (CategoryEnum item : values()) {
            if (num == item.ordinal()) {
                return item;
            }
        }

        return null;
    }
}
