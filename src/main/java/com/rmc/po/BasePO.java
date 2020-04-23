package com.rmc.po;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class BasePO implements Serializable {
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}
