package com.xpizza.bass;

import com.xpizza.bass.net.http.HttpResponse;
import com.xpizza.bass.net.http.json.JsonGetFetcher;
import org.junit.Test;

import java.io.IOException;

public class WxTest {

    private static final String URL_WX_GET_OPENAPI = "https://api.weixin.qq.com/sns/jscode2session";
    private static final String WX_GRANTTYPE = "authorization_code";
    private static final String WX_APP_ID = "wxd5672517ac511e93";
    private static final String WX_SECERET = "333f56c71a140feeb86bd223b4fb5277";

    @Test
    public void getWxOpenId() throws IOException {
        String code = "071GqutD12yyd60r96tD1KzytD1GqutQ";
        String url = URL_WX_GET_OPENAPI + "?" +
                "appid=" + WX_APP_ID +
                "&secret=" + WX_SECERET +
                "&js_code=" + code +
                "&grant_type=" + WX_GRANTTYPE;
        JsonGetFetcher jsonGetFetcher = new JsonGetFetcher();
        jsonGetFetcher.setUrl(url);
        jsonGetFetcher.build();
        HttpResponse httpResponse = jsonGetFetcher.sendRequest();
        System.out.println(httpResponse.getBody());
    }
}
