package com.plaxa.spring_course.mapper;

public interface Mapper<F, T> {

    T map(F o);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
