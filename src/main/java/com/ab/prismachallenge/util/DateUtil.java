package com.ab.prismachallenge.util;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private DateUtil() {
    }

    @SneakyThrows
    public static Date convertStringToDate(String date) {

        return new SimpleDateFormat("MM/dd/yyyy").parse(date);

    }
}
