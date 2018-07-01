package com.tailt.common.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {
    private static volatile RegexHelper instance;
    private static final String EMAIL_REGEX="[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
    private static final String PHONE_REGEX="((\\D|^|\\G)0 ?(1 ?2 ?\\d|9 ?\\d|1 ?6 ?[2-9]|1 ?8 ?6|1 ?8 ?8|1 ?9 ?9|8 ?6 ?8|8 ?8|8 ?9)( ?\\d){7}(\\D|$))|((\\D|^|\\G)0(20|21[89]|22|2[34][01]|2[5-7]|28[01]|29|30|31|33|3[25][01]|3[6-9]|4|8|5[0-1]{2}|5[2-9]|6[0-4]|65[0-1]|6[6-9]|70|7[18][01]|7[2-7]|79|8[0-5]|86[2368]|87[13]|88|89|20[3-9]|21[0-68-9]|22[0-25-9]|23[2-9]|24|25[1-24-9]|26[0-39]|27[0-7]|28|29[0-46-79])( ?\\d){7,8}(\\D|$))";

    public boolean isMatch(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


    public boolean isPhone(String s){
        return isMatch(PHONE_REGEX,s);
    }



    public static synchronized RegexHelper getDefault(){
        if (instance == null) {
            instance = new RegexHelper();
        }
        return instance;

    }

    public static void main(String[] args) {
        System.out.println(RegexHelper.getDefault().isPhone("0968690229"));
    }

}
