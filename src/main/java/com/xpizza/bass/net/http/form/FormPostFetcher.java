package com.xpizza.bass.net.http.form;

import com.xpizza.bass.net.http.*;
import com.xpizza.bass.util.MapUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;

public class FormPostFetcher extends AbstractHttpFetcher {
    private Map<String, Object> formParams;

    @Override
    protected boolean needInput() {
        return true;
    }

    @Override
    protected boolean needOutput() {
        return true;
    }

    @Override
    protected boolean needCaches() {
        return false;
    }

    @Override
    protected boolean needAutoRedirect() {
        return true;
    }

    @Override
    protected ContentType configContentType() {
        return ContentType.ApplicationForm;
    }

    @Override
    protected RequestMethod configRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public HttpResponse sendRequest() throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        String paramStr = getParamStr(formParams);
        PostUtil.output(connection, paramStr);
        httpResponse.setStatusCode(connection.getResponseCode());
        httpResponse.setMessage(connection.getResponseMessage());
        // 判断返回状态码
        if (HttpURLConnection.HTTP_OK != httpResponse.getStatusCode()) {
            return httpResponse;
        }
        // 取返回数据
        httpResponse.pushBody(connection.getInputStream(), getCharset());
        return httpResponse;
    }

    private String getParamStr(Map<String,Object> formParams) {
        if (MapUtil.isEmpty(formParams)) {
            return "";
        }
        String retStr = "?";
        Iterator<String> i = formParams.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            Object val = formParams.get(key);
            retStr += (key + "=" + val + "&");
        }
        return retStr.substring(0, retStr.length() - 1);
    }
}
