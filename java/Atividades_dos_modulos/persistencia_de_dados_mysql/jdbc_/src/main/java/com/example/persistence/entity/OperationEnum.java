package com.example.persistence.entity;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum OperationEnum {
    INSERT,
    UPDATE,
    DELETE;

    public static OperationEnum getByDbOperation(final String dbOperation){
        return Stream.of(OperationEnum.values())
                        .filter(o -> o.name().startsWith(dbOperation.toUpperCase()))
                        .findFirst()
                        .orElseThrow();
    }
}
