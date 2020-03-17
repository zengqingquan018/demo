package com.example.demo.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZQQ
 * @Date 2020/2/14 15:55
 */
public class StringUtils {

    public static List<String> getImgStr(String htmlStr) {
        List<String> list = new ArrayList<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                list.add(m.group(1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> a = getImgStr("<div> <img src='133.png' /> xxxxxxxxxx <div> <img src='133.png' /> ");
        System.out.println("=========="+a);
    }
}
