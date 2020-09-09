package com.aiflow.dashboard.admin;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeTest {

    @Test
    public void test() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date(Long.valueOf(1589962122) * 1000));
        System.out.println(date);
    }
}
