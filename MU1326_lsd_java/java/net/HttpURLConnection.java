/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public abstract class HttpURLConnection
extends URLConnection {
    private String[] methodTokens = new String[]{"GET", "DELETE", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
    protected String method = "GET";
    protected int responseCode = -1;
    protected String responseMessage;
    protected boolean instanceFollowRedirects = followRedirects;
    private static boolean followRedirects = true;
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_BAD_METHOD = 405;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_CONFLICT = 409;
    public static final int HTTP_CREATED = 201;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_GONE = 410;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_LENGTH_REQUIRED = 411;
    public static final int HTTP_MOVED_PERM = 301;
    public static final int HTTP_MOVED_TEMP = 302;
    public static final int HTTP_MULT_CHOICE = 300;
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_NOT_ACCEPTABLE = 406;
    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_NOT_IMPLEMENTED = 501;
    public static final int HTTP_NOT_MODIFIED = 304;
    public static final int HTTP_OK = 200;
    public static final int HTTP_PARTIAL = 206;
    public static final int HTTP_PAYMENT_REQUIRED = 402;
    public static final int HTTP_PRECON_FAILED = 412;
    public static final int HTTP_PROXY_AUTH = 407;
    public static final int HTTP_REQ_TOO_LONG = 414;
    public static final int HTTP_RESET = 205;
    public static final int HTTP_SEE_OTHER = 303;
    public static final int HTTP_USE_PROXY = 305;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNSUPPORTED_TYPE = 415;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final int HTTP_VERSION = 505;

    protected HttpURLConnection(URL uRL) {
        super(uRL);
    }

    public abstract void disconnect();

    public InputStream getErrorStream() {
        return null;
    }

    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    public Permission getPermission() throws IOException {
        int n = this.url.getPort();
        if (n < 0) {
            n = 80;
        }
        return new SocketPermission(String.valueOf(this.url.getHost()) + ":" + n, "connect, resolve");
    }

    public String getRequestMethod() {
        return this.method;
    }

    public int getResponseCode() throws IOException {
        this.getInputStream();
        String string = this.getHeaderField(0);
        if (string == null) {
            return -1;
        }
        string.trim();
        int n = string.indexOf(" ") + 1;
        if (n == 0) {
            return -1;
        }
        int n2 = n + 3;
        if (n2 > string.length()) {
            n2 = string.length();
        }
        this.responseCode = Integer.parseInt(string.substring(n, n2));
        if (n2 + 1 <= string.length()) {
            this.responseMessage = string.substring(n2 + 1);
        }
        return this.responseCode;
    }

    public String getResponseMessage() throws IOException {
        if (this.responseMessage != null) {
            return this.responseMessage;
        }
        this.getResponseCode();
        return this.responseMessage;
    }

    public static void setFollowRedirects(boolean bl) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        followRedirects = bl;
    }

    public void setRequestMethod(String string) throws ProtocolException {
        if (this.connected) {
            throw new ProtocolException(Msg.getString("K0037"));
        }
        int n = 0;
        while (n < this.methodTokens.length) {
            if (this.methodTokens[n].equals(string)) {
                this.method = this.methodTokens[n];
                return;
            }
            ++n;
        }
        throw new ProtocolException();
    }

    public abstract boolean usingProxy();

    public boolean getInstanceFollowRedirects() {
        return this.instanceFollowRedirects;
    }

    public void setInstanceFollowRedirects(boolean bl) {
        this.instanceFollowRedirects = bl;
    }

    public long getHeaderFieldDate(String string, long l) {
        return super.getHeaderFieldDate(string, l);
    }
}

