package com.chy.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTheory {
    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台" +
                "（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型版），4664应用于移动、" +
                "无线及1221有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的标准版），3344应用于桌面环境；" +
                "J2EE（Java 2Enterprise Edition，Java 2平台的企业版），6677应用于基于Java的应用服务器。Java 2平台的发布，" +
                "是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。9889";

        //1、给你一个字符串，请你找出所有四个数字连在一起的子串？

        //定义需要匹配的模式
        String reg = "(\\d\\d)(\\d\\d)";
        //创建一个Pattern对象
        Pattern pattern = Pattern.compile(reg);
        //创建一个匹配器mather,按照 正则表达式的规则 去匹配content字符串
        Matcher matcher = pattern.matcher(content);
        //循环查找，开始匹配

        /*

        matcher.find() 完成任务 (考虑分组)
        什么是分组：比如 (\d\d)(\d\d)，正则表达式中有() 表示分组，第一个()表示第一组，第二个()表示第二组....
        1、根据指定的规则，定位满足规则的子字符串(比如(19)(98))
        2、找到后，将子字符串的开始索引记录到matcher对象的属性中，int[] groups
           2.1、groups[0] = 0, 把该子字符串结束的索引+1的值记录到 groups[1] = 4
           2.2、记录第1组匹配到的字符串  groups[2] = 0  groups[3] = 2
           2.3、记录第2组匹配到的字符串  groups[4] = 2  groups[5] = 4
           .... 如果有更多的分组.....
        3、同时记录oldLast的值为 该子字符串结束的索引+1的值 即 oldLast = 4，即下次执行find()方法时，就从4开始匹配

        matcher.group(0)：分析源码
        public String group(int group) {
            if (first < 0)
                throw new IllegalStateException("No match found");
            if (group < 0 || group > groupCount())
                throw new IndexOutOfBoundsException("No group " + group);
            if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
                return null;
            return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
        }
        1、根据 groups[0] = 0 和 groups[1] = 4 的记录的位置，从content 开始截取子字符串返回
           就是 [0,4) 包括0，而不包括索引为4的位置

        如果再次执行 find()方法，仍然按照上面的分析
         */
        while (matcher.find()) {
            //小结：
            //1、如果正则表达式有() 即分组
            //2、取出匹配的字符串规则如下
            //3、group(0) 表示匹配到的子字符串
            //4、group(1) 表示匹配到的子字符串的第1组字串
            //4、group(2) 表示匹配到的子字符串的第2组字串
            //6、...但是分组数不能越界。
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第1组()匹配到的值 = " + matcher.group(1));
            System.out.println("第2组()匹配到的值 = " + matcher.group(2));
            //System.out.println("第3组()匹配到的值 = " + matcher.group(3));       //越界
        }

        //2、给你一个字符串，请你找出所有四个数字连在一起的子串，并别四个数字要满足：第一位与第四位相同，
        //第二位与第三位相同，比如1221，5775
    }
}