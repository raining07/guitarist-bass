package com.xpizza.bass.time;

import com.xpizza.bass.lang.exception.DataOutOfRangeException;
import com.xpizza.bass.util.Assert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @ClassName: DateUtil
 * @Description: TODO 时间类型的处理工具
 * @author: Xpizza
 * @date: Jul 14, 2017 10:40:39 AM
 */
public class DateUtil {

    /** 格式:年月日紧凑排列 */
    public static final String FORMAT_YMD = "yyyyMMdd";

    /** 英语习惯 */
    public static final String FORMAT_YMD_EN = "dd/MM/yyyy";

    /** 格式:年月日以横杠("-")分隔;精确到:年月日 */
    public static final String FORMAT_BAR1 = "yyyy-MM-dd";

    /** 格式:年月日以横杠("-")分隔;精确到:年月日时分 */
    public static final String FORMAT_BAR2 = "yyyy-MM-dd HH:mm";

    /** 格式:年月日以横杠("-")分隔;精确到:年月日时分秒 */
    public static final String FORMAT_BAR3 = "yyyy-MM-dd HH:mm:ss";

    /** 格式:年月日以横杠("-")分隔;精确到:年月日时分秒毫秒 */
    public static final String FORMAT_BAR4 = "yyyy-MM-dd HH:mm:ss:SSS";

    /** 格式:年月日以斜杠("/")分隔;精确到:年月日 */
    public static final String FORMAT_SLASH1 = "yyyy/MM/dd";

    /** 格式:年月日以斜杠("/")分隔;精确到:年月日时分 */
    public static final String FORMAT_SLASH2 = "yyyy/MM/dd HH:mm";

    /** 格式:年月日以斜杠("/")分隔;精确到:年月日时分秒 */
    public static final String FORMAT_SLASH3 = "yyyy/MM/dd HH:mm:ss";

    /** 格式:年月日以斜杠("/")分隔;精确到:年月日时分秒毫秒 */
    public static final String FORMAT_SLASH4 = "yyyy/MM/dd HH:mm:ss:SSS";

    /** 格式:时分秒 */
    public static final String FORMAT_CLOCK = "HH:mm:ss";

    /** 格式:中文形式的年月日 */
    public static final String FORMAT_CHN1 = "yyyy年MM月dd日";

    /**
     * 日期转字符串,可自由选择格式(建议使用)
     */
    public static String dateToString(Date date, String mode) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(mode);
        return dateFormat.format(date);
    }

    /**
     * 字符串转日期,可自由选择格式(建议使用)
     */
    public static Date stringToDate(String dateStr, String mode) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(mode);
        return sdf.parse(dateStr);
    }

    /**
     * 将date转成String 格式：yyyy-MM-dd
     */
    public static String getStrOfYMD(Date date) {
        return dateToString(date, FORMAT_BAR1);
    }

    /**
     * 将String转成date 格式：yyyy-MM-dd
     */
    public static Date getDateForYMD(String dateStr) throws ParseException {
        return stringToDate(dateStr, FORMAT_BAR1);
    }

    /**
     * 转为sql.date,适用于插入数据库
     */
    public static java.sql.Date getSqlDate(String dateStr) {
        return java.sql.Date.valueOf(dateStr);
    }

    /**
     * 获取日期 格式：yyyy-MM-dd
     */
    public static String getStrOfYMD(int fromToday) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, fromToday);
        return dateToString(calendar.getTime(), FORMAT_BAR1);
    }

    /**
     * 获取当前时间的字符串,格式自选
     */
    public static String getStrOfCurrentDate(String mode) {
        return dateToString(new Date(), mode);
    }

    /**
     * 取当前年份
     */
    public static int getCurrentYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取年周数 格式：201604
     */
    public static String getWeekOfYear() {
        Calendar c = Calendar.getInstance();
        int weekNum = c.get(Calendar.WEEK_OF_YEAR);
        String weekStr = null;
        if (weekNum < 10) {
            weekStr = "0" + Integer.toString(weekNum);
        } else {
            weekStr = Integer.toString(weekNum);
        }
        String weekOfYear = c.get(Calendar.YEAR) + weekStr;
        return weekOfYear;
    }

    /**
     * 根据输入的日期(格式是yyyy-MM-dd)计算年龄
     */
    public static int getAge(String nyr) {
        String currentDate = getStrOfYMD(0).replace("-", "");
        nyr = nyr.replace("-", "");
        // 今天的年份
        int year = Integer.parseInt(currentDate.substring(0, 4));
        // 今天的月日
        int monthAndDay = Integer.parseInt(currentDate.substring(4));
        // 输入的年份
        int yearIn = Integer.parseInt(nyr.substring(0, 4));
        // 输入的月日
        int monthAndDayIn = Integer.parseInt(nyr.substring(4));
        // 计算年龄
        int age = year - yearIn;
        if (monthAndDay < monthAndDayIn)
            age = age - 1;
        return age;
    }

    /**
     * 判断输入日期是星期几
     */
    public static int getWeekIndex(Date date) {
        // Date date = getDateForYMD(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 西方世界中的一个星期是从星期日开始计数的,需要减1
        int chnWeekNum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (chnWeekNum == 0) // 星期日
            chnWeekNum = 7;
        return chnWeekNum;
    }

    public static int getWeekNoOfAYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        int no = calendar.get(Calendar.WEEK_OF_YEAR);
        return no;
    }

    /**
     * 判断今天是周几
     */
    public static int getWeekIndexForToday() {
        Date today = new Date();
        return getWeekIndex(today);
    }

    /**
     * 按输入年月计算这个月有多少天
     */
    public static int getDaysCountInMonth(int year, int month) {
        if (month < 1 || month > 12) {
            throw new DataOutOfRangeException("月份应在1~12之间");
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// Java月份才0开始算
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取时间戳
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Object转Date String
     */
    public static String toDate(Object object, String dateMode) {
        if (object == null) {
            return "";
        } else if (object instanceof Date) {
            Date date = (Date) object;
            return dateToString(date, dateMode);
        } else {
            return object.toString();
        }
    }

    /** 一天有多少ms */
    public static final long msOfOneDay = 24 * 60 * 60 * 1000;

    /** 一小时有多少ms */
    public static final long msOfOnehour = 60 * 60 * 1000;

    /** 一分钟有多少ms */
    public static final long msOfOneMinute = 60 * 1000;

    /**
     *
     * @Title: timesFromDeadline
     * @Description: 输入时间与截止时间之间的时间差
     * @param date
     *            输入时间
     * @param deadline
     *            截止时间
     * @return
     * @return: String
     */
    public static String timesFromDeadline(Date date, Date deadline) {
        long time = date.getTime();
        long timeDead = deadline.getTime();
        Assert.isTrue(time < timeDead, "已经超过截止时间");
        long msTotal = timeDead - time;
        long days = msTotal / msOfOneDay;
        long hours = (msTotal - (days * msOfOneDay)) / msOfOnehour;
        long minutes = (msTotal - (days * msOfOneDay) - hours * msOfOnehour) / msOfOneMinute;
        return days + "天" + hours + "小时" + minutes + "分钟";
    }

    /**
     *
     * @Title: nowFromDeadline
     * @Description: 当前时间与截止时间之间的时间差
     * @param deadline
     *            截止时间
     * @return
     * @return: String
     */
    public static String nowFromDeadline(Date deadline) {
        return timesFromDeadline(new Date(), deadline);
    }
}
