package com.example.sofademocommon.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnum {
    BOY("男"),

    GIRL("女");

    private final String sex;
}
