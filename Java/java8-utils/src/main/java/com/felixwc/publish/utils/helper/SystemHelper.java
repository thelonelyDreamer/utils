package com.felixwc.publish.utils.helper;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/4/24--@22:22
 */
public class SystemHelper {

    /**
     * @todo 判断是否是windows系统运行
     * @author felixwc
     * @date 2023/4/24 22:27
     * @return boolean. if it is running in windows return true.
     */
    public static boolean isWindows(){
        String osName = System.getProperty("os.name");
        return osName.startsWith("Window");
    }
}
