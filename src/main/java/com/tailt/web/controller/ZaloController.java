package com.tailt.web.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vng.zalo.sdk.APIConfig;
import com.vng.zalo.sdk.APIException;
import com.vng.zalo.sdk.ZaloBaseClient;
import com.vng.zalo.sdk.oa.ZaloOaInfo;
import com.vng.zalo.sdk.utils.MacUtils;

import java.util.HashMap;
import java.util.Map;

public class ZaloController extends ZaloBaseClient {
    private ZaloOaInfo oaInfo;

    public ZaloController(ZaloOaInfo oaInfo) {
        this.oaInfo = oaInfo;
    }

    public JsonObject requestProfile (long userId) throws APIException {
        JsonObject data = new JsonObject();

        data.addProperty("uid", userId);
        data.addProperty("title", "Yêu Cầu Gửi Thông Tin");
        data.addProperty("desc","Để nâng cao chất lượng phục vụ. " +
                "Bạn hãy gửi thông tin cho chúng tôi bằng cách click vào đây và nhập đầy đủ thông tin.");
        data.addProperty("thumb","https://developers.zalo.me/web/static/images/bg.jpg");


        Map<String, String> params = new HashMap();
        params.put("oaid", String.valueOf(this.oaInfo.getOaId()));
        params.put("data", String.valueOf(data.toString()));
        long timestamp = System.currentTimeMillis();
        params.put("timestamp", String.valueOf(timestamp));
        String mac = MacUtils.buildMac(new Object[]{this.oaInfo.getOaId(), data.toString(), timestamp, this.oaInfo.getSecrect()});
        params.put("mac", mac);
        JsonParser parser = new JsonParser();

        String response = this.sendHttpPostRequest("https://openapi.zaloapp.com/oa/v1/reqinfo"
                , params, APIConfig.DEFAULT_HEADER);
        return parser.parse(response).getAsJsonObject();
    }


}
