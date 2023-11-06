package com.academy.logistics_department.model.enums;

public enum RoleEnum {
    CUSTOMER,
    MANAGER,
    DRIVER;

    public static RoleEnum valueOf(int num){
        for (RoleEnum item : values()) {
            if (num == item.ordinal()) {
                return item;
            }
        }

        return null;
    }
}
