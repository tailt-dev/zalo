package com.tailt.bot;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tailt.web.bean.OpenMsgAction;
import com.tailt.web.controller.ZaloController;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.EndPoint;
import com.vng.zalo.sdk.ZaloBaseClient;
import com.vng.zalo.sdk.oa.ZaloOaClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.oa.message.MsgAction;
import com.vng.zalo.sdk.oa.message.MsgLink;
import com.vng.zalo.sdk.oa.message.OpenInAppAction;
import com.vng.zalo.sdk.utils.MacUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main extends ZaloBaseClient{
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
//            OpenMsgAction action = new OpenInAppAction();
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

//            OpenMsgAction action = new OpenInAppAction();
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



//            JsonObject ret = oaClient.getProfile(6009024723783082551L);
//            System.out.println(ret);

//
//            JsonObject data = new JsonObject();
//            data.addProperty("uid", userid);
//            data.addProperty("title", "66");
//            data.addProperty("desc","jjj");
//            data.addProperty("thumb","https://developers.zalo.me/web/static/images/bg.jpg");
//
//
//            Map<String, String> params = new HashMap();
//            params.put("oaid", String.valueOf(oaid));
//            params.put("data", String.valueOf(data.toString()));
//            long timestamp = System.currentTimeMillis();
//            params.put("timestamp", String.valueOf(timestamp));
//            String mac = MacUtils.buildMac(new Object[]{this.oaid, data.toString(), timestamp, secrect});
//            params.put("mac", mac);
//            JsonParser parser = new JsonParser();
//
//            String response = this.sendHttpPostRequest("https://openapi.zaloapp.com/oa/v1/reqinfo"
//                    , params, APIConfig.DEFAULT_HEADER);
//            System.out.println(response);



//            System.out.println(parser.parse(response).getAsJsonObject());

//            ZaloController zaloController = new ZaloController(info);
//            System.out.println(zaloController.requestProfile(6009024723783082551L));

//            System.out.println(oaClient.getProfile(84968690229L));


//
            OpenMsgAction action = new OpenMsgAction();
            action.setTitle("Send interactive messages");
            action.setDescription("This is a test for API send interactive messages");
            action.setThumb("https://developers.zalo.me/web/static/images/bg.jpg");



            JsonObject popup = new JsonObject();
            popup.addProperty("title", "Open Website Zalo For Developers");
            popup.addProperty("desc", "Click ok to visit Zalo For Developers and read more Document");
            popup.addProperty("ok", "ok");
            popup.addProperty("cancel", "cancel");
            action.setPopup(popup);

            System.out.println(action);

//            JsonObject ret = oaClient.sendActionMessage(userid, Arrays.asList(action));

//            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
