package com.example.demo.common.utils;



import com.mysql.cj.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author ZQQ
 * @Date 2020/5/14 19:55
 */
public class DateUtils {

    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE = "yyyy-MM-dd";

    public static final String DATE_TIME_CH = "yyyy年MM月dd日";

    public static final String DATE_TIME_FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static final String DATE_yyyyMMdd = "yyyyMMdd";

    /**
     * 格式化日期字符串
     *
     * @param date    日期对应的字符串 格式为yyyy-MM-dd HH:mm:ss
     * @param format 格式
     * @return 若传入的格式正确，返回Date
     */
    public static String formatDataString(String date, String format) {
        return format(parseDateTime(date), format);
    }

    /**
     * 根据Date类型日期获取String类型日期
     *
     * @param date    Date类型日期
     * @param format 格式
     * @return 若传入的格式正确，返回String类型的日期
     */
    public static String format(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 根据Date类型日期获取String类型日期 格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date    Date类型日期
     * @return 若传入的格式正确，返回String类型的日期
     */
    public static String formatDateTime(Date date) {
        return null == date ? null : format(date, DATE_TIME);
    }

    /**
     * 根据Date类型日期获取String类型日期 格式为yyyy-MM-dd
     *
     * @param date    Date类型日期
     * @return 若传入的格式正确，返回String类型的日期
     */
    public static String formatDate(Date date) {
        return null == date ? null : format(date, DATE);
    }

    /**
     * 时间字符串格式化时间
     * @param dateStr   时间字符串
     * @param format   时间格式
     * @return Date
     */
    public static Date parse(String dateStr, String format) {
        try {
            dateStr = normalize(dateStr);
            return new SimpleDateFormat(format).parse(dateStr);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 时间字符串转date 格式为yyyy-MM-dd HH:mm:ss
     * @param dateString  时间字符串
     * @return Date
     */
    public static Date parseDateTime(String dateString) {
        dateString = normalize(dateString);
        return parse(dateString, DATE_TIME);
    }

    /**
     * 时间字符串转date 格式为yyyy-MM-dd
     * @param dateString  时间字符串
     * @return Date
     */
    public static Date parseDate(String dateString) {
        dateString = normalize(dateString);
        return parse(dateString, DATE);
    }

    private static String normalize(String dateStr) {
        if (StringUtils.isNullOrEmpty(dateStr)) {
            return dateStr;
        } else {
            List<String> dateAndTime = new ArrayList<>(Arrays.asList(dateStr.split(" ")));
            int size = dateAndTime.size();
            if (size >= 1 && size <= 2) {
                StringBuilder builder = new StringBuilder();
                String datePart = dateAndTime.get(0).replaceAll("[\\/.年月]", "-");
                datePart = datePart.replaceAll("日", "");
                builder.append(datePart);
                if (size == 2) {
                    builder.append(" ");
                    String timePart = dateAndTime.get(1).replaceAll("[时分秒]", ":");
                    if(timePart.endsWith(":")){
                        timePart = timePart.substring(0, timePart.length() - 1 );
                    }
                    builder.append(timePart);
                }

                return builder.toString();
            } else {
                return dateStr;
            }
        }
    }

    /**
     * 获取当前时间字符串 格式yyyy-MM-dd HH:mm:ss
     */
    public static String now(){
        return format(new Date(), DATE_TIME);
    }

    /**
     * date 转calender
     */
    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * 获取时间比较结果
     * @param date          时间
     * @param anotherDate   时间
     * @return Date
     */
    public static boolean isBeforeOrEquals(Date date, Date anotherDate) {
        if (null == date || null == anotherDate) {
            return false;
        } else {
            return date.compareTo(anotherDate) <= 0;
        }
    }

    /**
     * 获取时间比较结果
     * @param date          时间
     * @param anotherDate   时间
     * @return Date
     */
    public static boolean isAfterOrEquals(Date date, Date anotherDate) {
        if (null == date || null == anotherDate) {
            return false;
        } else {
            return date.compareTo(anotherDate) >= 0;
        }
    }

    /**
     * 获取根据偏移单位偏移后的时间
     * @param date        时间
     * @param dateFiled   偏移单位
     * @param offset      偏移量
     * @return Date
     */
    public static Date offset(Date date, int dateFiled, int offset) {
        Calendar calendar = toCalendar(date);
        calendar.add(dateFiled, offset);
        return calendar.getTime();
    }

    public static Date offsetSecond(Date date, int offset) {
        return offset(date, Calendar.SECOND, offset);
    }

    public static Date offsetMinute(Date date, int offset) {
        return offset(date, Calendar.MINUTE, offset);
    }

    public static Date offsetHour(Date date, int offset) {
        return offset(date, Calendar.HOUR_OF_DAY, offset);
    }

    public static Date offsetDay(Date date, int offset) {
        return offset(date, Calendar.DAY_OF_YEAR, offset);
    }

    public static Date offsetMonth(Date date, int offset) {
        return offset(date, Calendar.MONTH, offset);
    }

    /**
     * 获取一天的开始时间
     * @param date   时间
     * @return Date
     */
    public static Date beginOfDay(Date date) {
        return beginOfDay(toCalendar(date)).getTime();
    }

    /**
     * 获取一天的结束时间
     * @param date   时间
     * @return Date
     */
    public static Date endOfDay(Date date) {
        return endOfDay(toCalendar(date)).getTime();
    }

    public static Calendar beginOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static Calendar endOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }

    /**
     * 获取一个月的开始时间
     * @param date   时间
     * @return Date
     */
    public static Date beginOfMonth(Date date) {
        return beginOfMonth(toCalendar(date)).getTime();
    }

    /**
     * 获取一个月的结束时间
     * @param date   时间
     * @return Date
     */
    public static Date endOfMonth(Date date) {
        return endOfMonth(toCalendar(date)).getTime();
    }

    public static Calendar beginOfMonth(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return beginOfDay(calendar);
    }

    public static Calendar endOfMonth(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return endOfDay(calendar);
    }

    /**
     * 时间戳转时间类型
     * @param time  时间戳字符串
     * @return  时间格式字符串 yyyy-MM-dd HH:mm:ss
     */
    public static Date timeStamp2Date(String time) {
        Long timeLong = Long.parseLong(time);
        //要转换的时间格式
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME);
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return date;
        } catch (Exception  e) {
            e.printStackTrace();
            return null;
        }
    }




}
