/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    protected URLConnection openConnection(URL uRL) throws IOException {
        return new HttpURLConnection(uRL, this.getDefaultPort());
    }

    protected int getDefaultPort() {
        return 80;
    }
}

