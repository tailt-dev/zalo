package com.tailt.web.controller;

import com.google.gson.JsonObject;
import com.tailt.common.regex.RegexHelper;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;

import javax.ws.rs.core.MultivaluedMap;

public class BotController {
    private static RegexHelper regexHelper = RegexHelper.getDefault();

    private static long oaid = 2240678076137108619L;
    private static String secrect = "FtDTseRxEA8dSp8tpVBC";
    private static ZaloOaInfo info = new ZaloOaInfo(oaid, secrect);
    private static ZaloOaClient oaClient = new ZaloOaClient(info);

    public static void sendMsgZalo(MultivaluedMap<String, String> param){
        String msg = param.get("message").get(0);
        String userId = param.get("fromuid").get(0);
        System.out.println(param);
        System.out.println(regexHelper.isPhone(msg));
        if(!regexHelper.isPhone(msg)){
            sendMsgNotPhone(userId);
        }else{
            sendMsgPhone(userId);
        }
    }

    private static void sendMsgNotPhone(String userId){
        long l = Long.parseLong(userId);
        try {
            JsonObject profile = oaClient.getProfile(l);
            String message = "Đây không phải là số điện thoại mời nhập lại.";
            JsonObject ret = oaClient.sendTextMessage(l, message);
//            System.out.println(ret);
        } catch (APIException e) {
            e.printStackTrace();
        }

    }

    private static void sendMsgPhone(String userId){
        long l = Long.parseLong(userId);
        try {
            JsonObject profile = oaClient.getProfile(l);
            String message = "Mời bạn chọn ngày khám. Tuyet Vit";
            JsonObject ret = oaClient.sendTextMessage(l, message);
            System.out.println(ret);
        } catch (APIException e) {
            e.printStackTrace();
        }

    }
}
