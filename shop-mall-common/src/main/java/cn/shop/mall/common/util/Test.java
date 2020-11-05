package cn.shop.mall.common.util;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("1、题目：计算字符串最后一个单词的长度，单词以空格隔开。");
//        System.out.println("请输入:");
//        System.out.println("输出为：" + getWordSizeFromLastSpace(scanner.nextLine()));
//
//        System.out.println("2、题目：写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。");
//        System.out.println("请输入:");
//        System.out.println("输出为：" + getCharHappenTimesFromStr(scanner.nextLine(), scanner.nextLine().charAt(0)));
//
//        System.out.println("3、题目：首先输入随机数的个数n，再依次输入n个随机整数组成的数组，输出去重和排序后的数组");
//        System.out.println("请输入:");
//        int size = Integer.valueOf(scanner.nextLine());
//        List<Integer> list = Lists.newArrayList(size);
//        for (int i = 0; i < size; i++) {
//            list.add(Integer.valueOf(scanner.nextLine()));
//        }
//        System.out.println("输出为：" + getDistinctAndOrder(list));
//
//        System.out.println("4、题目：颠倒字符串");
//        System.out.println("请输入:");
//        System.out.println("输出为：" + reverseString(Integer.valueOf(scanner.nextLine())));
//
//        System.out.println("5、输入一个数，求质数");
//        System.out.println("请输入:");
//        System.out.println("输出为：" + getZhiShu(Integer.valueOf(scanner.nextLine())));
//
//        System.out.println("6、接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。");
//        System.out.println("请输入:");
//        System.out.println("输出为：" + getJinSi(Float.valueOf(scanner.nextLine())));

    }

    public static int getJinSi(float num) {
        String numStr = String.valueOf(num);
        String xiaoshuValue = numStr.substring(numStr.indexOf(".") + 1, numStr.indexOf(".") + 2);
        if (Integer.valueOf(xiaoshuValue) >= 5) {
            return Integer.valueOf(numStr.substring(0, numStr.indexOf("."))) + 1;
        } else {
            return Integer.valueOf(numStr.substring(0, numStr.indexOf(".")));
        }
    }

    public static int getWordSizeFromLastSpace(String str) {
        int lastSpaceIndex = str.lastIndexOf(" ");
        return str.substring(lastSpaceIndex + 1).length();
    }

    public static int getCharHappenTimesFromStr(String str, char cr) {
        int happens = 0;
        if (cr >= 'A' && cr <= 'Z') {
            cr += 32;
        }
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            if (c == cr) {
                happens++;
            }
        }
        return happens;
    }

    public static String reverseString(int number) {
        String str = String.valueOf(number);
        String result = "";
        for (int i = str.length() - 1; i > -1; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public static List<Integer> getDistinctAndOrder(List<Integer> intList) {
        if (intList == null || intList.size() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        int nextSizeIndex = 0;
        int index = 0;
        for (int i = 0; i < intList.size(); i++) {
            if (i == nextSizeIndex) {
                index++;
                nextSizeIndex = i + intList.get(nextSizeIndex) + 1;
            } else {
                Set<Integer> set = indexMap.get(index);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(intList.get(i));
                indexMap.put(index, set);
            }
        }
        List<Integer> result = Lists.newArrayList();
        for (Map.Entry<Integer, Set<Integer>> entry : indexMap.entrySet()) {
            result.addAll(entry.getValue().stream().sorted().collect(Collectors.toList()));
        }
        return result;
    }

    private static List<String> getArrayFromString(String str, int number) {
        char[] initStr = null;
        List<String> strList = Lists.newArrayList();
        int num = 0;
        char[] strChar = str.toCharArray();
        for (char c : strChar) {
            int x = num % number;
            if (x == 0) {
                initStr = getLengthStr(number);
            }
            initStr[x] = c;
            if (x == (number - 1) || num == (strChar.length - 1)) {
                strList.add(String.valueOf(initStr));
            }
            num++;
        }
        return strList;
    }

    public static char[] getLengthStr(int number) {
        String arrStr = "";
        for (int i = 0; i < number; i++) {
            arrStr += "0";
        }
        return arrStr.toCharArray();
    }

    public static int get10IntFrom16Int(String str) {
        String newStr = str.substring(2);
        int len = newStr.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            String c = newStr.substring(i, i + 1);
            int num = getNumberFromStr(c);
            result += num * Math.pow(16, len - i - 1);
        }
        return result;
    }

    public static int getNumberFromStr(String str) {
        switch (str) {
            case "0":
                return 0;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "A":
                return 10;
            case "B":
                return 11;
            case "C":
                return 12;
            case "D":
                return 13;
            case "E":
                return 14;
            case "F":
                return 15;
            default:
                return 0;
        }
    }

    public static String getZhiShu(int num) {
        String result = "";
        while (num != 1) {
            for (int i = 2; i <= num; ++i) {
                if (num % i == 0) {
                    result += i + " ";
                    num = num / i;
                    break;
                }
            }
        }
        return result;
    }

}
