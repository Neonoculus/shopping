package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
}
