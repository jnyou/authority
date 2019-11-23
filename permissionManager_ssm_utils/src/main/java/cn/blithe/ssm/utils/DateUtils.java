package cn.blithe.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Deacription TODO
 * @Author 夏小颜
 * @Date 2019/11/23 18:51
 * @Version 1.0
 **/
public class DateUtils {

    /**
     * @Author: nankexiansheng
     * @Description: 日期转换成字符串
     * @Date: 2019/11/23
     * @Param: [date, patt]
     * @Return: java.lang.String
     **/
    public static String date2String(Date date,String patt){
        SimpleDateFormat sf = new SimpleDateFormat();
        String format = sf.format(date);
        return format;
    }

    public static Date string2Date(String dataStr,String patt) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat(patt);
        Date parse = sf.parse(dataStr);
        return parse;
    }

}