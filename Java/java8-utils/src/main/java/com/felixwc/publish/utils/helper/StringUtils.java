package com.felixwc.publish.utils.helper;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * in order to learn java!
 * created at 2022/6/14 23:59
 *
 * @author felixwc
 */
public class StringUtils {

    /**
     * @param target
     * @param pattern
     * @return
     * @return java.util.List<java.lang.String>
     * @Author felixwc
     * @Description //TODO
     * @Date 00:32 2022/6/15
     * @Param
     **/
    public static List<String> parseString(String target, Pattern pattern) {
        Matcher matcher = pattern.matcher(target);
        LinkedList<String> strings = new LinkedList<>();
        while (matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }

    /**
     * @param target - 传入的字符串
     * @return boolean - 如果为空则返回true,不为空返回false
     * @Author felixwc
     * @Description //TODO 判断字符串是否为null
     * @Date 00:47 2022/6/15
     **/
    public static boolean isNullString(String target) {
        return null == target ? true : false;
    }

    /**
     * @param target - 目标字符串
     * @return boolean
     * @Author felixwc
     * @Description //TODO 判断是否是空串
     * @Date 00:59 2022/6/15
     **/
    public static boolean isEmptyString(String target) {
        return "".equalsIgnoreCase(target);
    }

    /**
     * @param target - 目标字符串
     * @return boolean 如果不为空 返回 false
     * @Author felixwc
     * @Description //TODO 验证字符串是否为空或者为null
     * @Date 01:03 2022/6/15
     **/
    public static boolean isNullOrEmptyString(String target) {
        return isEmptyString(target) || isNullString(target);
    }
}
