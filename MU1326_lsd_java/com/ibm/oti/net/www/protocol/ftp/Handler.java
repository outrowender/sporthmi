/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.ftp;

import com.ibm.oti.net.www.protocol.ftp.FtpURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    protected URLConnection openConnection(URL uRL) throws IOException {
        return new FtpURLConnection(uRL);
    }

    protected int getDefaultPort() {
        return 21;
    }
}

