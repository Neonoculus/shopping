package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    static public java.util.Date StringGoDate(String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            java.util.Date date = format.parse(dateString);
            return date;
        } catch (ParseException e) {
            System.out.println("日期解析失败：" + e.getMessage());
        }
        return null;
    }
    static public long getLongDate(){
        // 获取当前系统时间
        LocalDateTime currentTime = LocalDateTime.now();

        // 设置要显示的时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formattedTime = currentTime.format(formatter);
        long time= Long.parseLong(formattedTime);

        // 返回long格式的时间
        return time;
    }

}
