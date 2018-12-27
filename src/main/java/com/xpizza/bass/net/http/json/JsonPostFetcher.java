package com.xpizza.bass.net.http.json;

import com.xpizza.bass.lang.Strings;
import com.xpizza.bass.net.http.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class JsonPostFetcher extends AbstractHttpFetcher {
    private String jsonParam;

    public String getJsonParam() {
        return jsonParam;
    }

    public void setJsonParam(String jsonParam) {
        this.jsonParam = jsonParam;
    }

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
        return ContentType.ApplicationJson;
    }

    @Override
    protected RequestMethod configRequestMethod() {
        return RequestMethod.POST;
    }

    @Override
    public HttpResponse sendRequest() throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        if (Strings.isEmpty(jsonParam)) {
            this.jsonParam = "{}";
        }
        PostUtil.output(connection, jsonParam);
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
}
