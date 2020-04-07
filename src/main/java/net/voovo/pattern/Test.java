package net.voovo.pattern;

import java.util.regex.Pattern;

/**
 * @Author yml
 * @Date 2020/4/2
 */
class Test {
    //值包含数字和逗号 ^[\d,]+$
    public static void main(String[] args) {
        boolean matches = Pattern.matches("^[\\d,]+$", "1,2,.4");
        System.out.println(matches);
    }
}
