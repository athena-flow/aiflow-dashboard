package com.aiflow.dashboard.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateUtil {
    public static String format(Integer time) {
        if(time.equals(0)) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date(time.longValue() * 1000));
    }
}
