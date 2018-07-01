package com.tailt.bot;

import com.google.gson.JsonObject;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.oa.message.OpenInAppAction;

import java.util.Arrays;

public class Main {
    long oaid = 2240678076137108619L; // put your oaid here
    String secrect = "FtDTseRxEA8dSp8tpVBC";
    ZaloOaInfo info = new ZaloOaInfo(oaid, secrect);
    ZaloOaClient oaClient = new ZaloOaClient(info);

    public void start(){

        try {
            long userid = 513283509958561100L; // user id or phone number;
//            JsonObject profile = oaClient.getProfile(userid);
//            String message = "Hnay Nghi12112";
//            JsonObject ret = oaClient.sendTextMessage(userid, message);
//            System.out.println(ret);
//            System.out.println(profile);

//
//            MsgAction action = new OpenInAppAction();
//            action.setTitle("Send interactive messages");
//            action.setDescription("This is a test for API send interactive messages");
//            action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");
//
//            JsonObject popup = new JsonObject();
//            popup.addProperty("title", "Open Website Zalo For Developers");
//            popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
//            popup.addProperty("ok", "ok");
//            popup.addProperty("cancel", "cancel");
//            action.setPopup(popup);
//
//            JsonObject ret1 = oaClient.sendActionMessage(userid, Arrays.asList(action));
//            System.out.println(ret1);

//            MsgAction action = new OpenInAppAction();
//            action.setTitle("Send interactive messages");
//            action.setDescription("This is a test for API send interactive messages");
//            action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");
//
//            JsonObject popup = new JsonObject();
//            popup.addProperty("title", "Open Website Zalo For Developers");
//            popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
//            popup.addProperty("ok", "ok");
//            popup.addProperty("cancel", "cancel");
//            action.setPopup(popup);
//
//            JsonObject ret = oaClient.sendActionMessage(userid, Arrays.asList(action));



            JsonObject ret = oaClient.getProfile(userid);
            oaClient.sendFollowMessage()
            System.out.println(ret);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
