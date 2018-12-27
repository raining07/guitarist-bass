package com.xpizza.bass.net.http.json;

import com.xpizza.bass.io.Charset;
import com.xpizza.bass.net.http.AbstractHttpFetcher;
import com.xpizza.bass.net.http.ContentType;
import com.xpizza.bass.net.http.HttpResponse;
import com.xpizza.bass.net.http.RequestMethod;

import java.io.IOException;

public class JsonGetFetcher extends AbstractHttpFetcher {
    @Override
    protected boolean needInput() {
        return true;
    }

    @Override
    protected boolean needOutput() {
        return false;
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
        return RequestMethod.GET;
    }

    @Override
    public HttpResponse sendRequest() throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.pushBody(connection.getInputStream(), Charset.UTF8);
        return httpResponse;
    }
}
