package com.sourcefuseorders.api.v1.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public enum Status {

    NEW("NEW"),
    PAID("PAID"),
    SHIPPED("SHIPPED"),
    CANCELLED("CANCELLED");

    private String value;
}
