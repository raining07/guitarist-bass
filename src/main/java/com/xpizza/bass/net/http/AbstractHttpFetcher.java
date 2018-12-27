package com.xpizza.bass.net.http;

import com.xpizza.bass.io.Charset;
import com.xpizza.bass.time.TimeUnit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 网络抓取器
 */
public abstract class AbstractHttpFetcher {
    /** 连接 */
    protected HttpURLConnection connection;

    /** 需要爬取的网址 */
    private String url;

    /** 默认时间为1分钟 */
    private int timeout = TimeUnit.ONE_MINUTE;

    /** 是否需要长连接 */
    private boolean needKeepAlive = true;

    private Charset charset = Charset.UTF8;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isNeedKeepAlive() {
        return needKeepAlive;
    }

    public void setNeedKeepAlive(boolean needKeepAlive) {
        this.needKeepAlive = needKeepAlive;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void build() throws IOException {
        // 1.设置url的同时,设置连接
        this.connection = (HttpURLConnection) new URL(this.url).openConnection();
        // 2.是否需要长连接
        if (this.needKeepAlive) {
            this.connection.setRequestProperty(RequestProperty.Connection, "Keep-Alive");// 维持长连接
        }
        // 3.设置超时时间
        this.connection.setConnectTimeout(this.timeout);
        // 4.设置上下文类型
        this.connection.addRequestProperty(RequestProperty.ContentType, configContentType().getValue());
        // 5.设置编码
        this.connection.addRequestProperty(RequestProperty.Charset, this.charset.getValue());
        // 6.设置请求方式
        this.connection.setRequestMethod(configRequestMethod().getValue());
        // 7.设置输入需要
        this.connection.setDoInput(needInput());
        // 8.设置输出需要
        this.connection.setDoOutput(needOutput());
        // 9.设置缓存需要
        this.connection.setUseCaches(needCaches());
        // 10.设置自动重定向需要
        this.connection.setInstanceFollowRedirects(needAutoRedirect());
    }

    /** 是否需要输入 */
    protected abstract boolean needInput();

    /** 是否需要输出 */
    protected abstract boolean needOutput();

    /** 是否开启缓存 */
    protected abstract boolean needCaches();

    /** 是否自动处理重定向 */
    protected abstract boolean needAutoRedirect();

    /** 增加请求头 */
    public void addRequestHeader(Map<String, String> header) {
        header.keySet().iterator().forEachRemaining(each -> {
            this.connection.addRequestProperty(each, header.get(each));
        });
    }

    /** 配置ContentType */
    protected abstract ContentType configContentType();

    /** 配置请求方式 */
    protected abstract RequestMethod configRequestMethod();

    /** 发送请求 */
    public abstract HttpResponse sendRequest() throws IOException;

    /** 关闭资源 */
    public void close() {
        try {
            this.connection.disconnect();
            this.connection = null;
        } catch (Throwable thr) {
            throw new FetcherCloseException(thr);
        }
    }
}
