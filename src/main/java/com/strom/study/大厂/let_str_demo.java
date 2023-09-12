package com.strom.study.大厂;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class let_str_demo {

    /**
     * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * <p>
     * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * <p>
     * 你需要输出替换之后的句子。
     * eg:
     * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
     * 输出："the cat was rat by the bat"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/replace-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> tes = new HashSet<>();
        dictionary.forEach(str -> {
            tes.add(str);
        });
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            for (int j = 0; j < s1.length(); j++) {
                if (tes.contains(s1.substring(0, 1 + j))) {
                    s[i] = s1.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", s);
    }

    public static boolean isJanuaryAndValidMonth(Date A, int B) {
        // 将java.util.Date转换为java.time.LocalDate
        LocalDate localDateA = A.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 获取当前日期的年份和月份
        int currentYear = LocalDate.now().getYear();
        Month currentMonth = LocalDate.now().getMonth();

        // 判断参数A的年份和月份是否与传入的参数B相同
        return localDateA.getYear() == currentYear && localDateA.getMonthValue() == B;
    }


    public static void main(String[] args) {
        String yearMonth = "2023" + "-" + "01";

        String startDateStr = yearMonth + "-" + String.format("%02d", 111);


        System.out.println(startDateStr);
        Date reportStartDate =   toDate(startDateStr,"yyyy-MM-dd");
        System.out.println(reportStartDate);


    }

    public static Date toDate(String dateStr, String format) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate localDate = LocalDate.parse(dateStr, inputFormatter);
            ZoneId defaultZoneId = ZoneId.systemDefault();
            return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        } catch (Exception e) {
            return null;
        }
    }

}
