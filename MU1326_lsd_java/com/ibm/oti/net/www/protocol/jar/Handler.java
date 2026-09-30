/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import com.ibm.oti.net.www.protocol.jar.JarURLConnection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler
extends URLStreamHandler {
    protected URLConnection openConnection(URL uRL) throws IOException {
        return new JarURLConnection(uRL);
    }

    protected void parseURL(URL uRL, String string, int n, int n2) {
        String string2 = uRL.getFile();
        if (string2 == null) {
            string2 = "";
        }
        if ((string = n2 > n ? string.substring(n, n2) : "").indexOf("!/") == -1 && string2.indexOf("!/") == -1) {
            throw new NullPointerException(Msg.getString("K01b6"));
        }
        string2 = string.charAt(0) == '/' ? String.valueOf(string2.substring(0, string2.indexOf(33) + 1)) + string : String.valueOf(string2.substring(0, string2.lastIndexOf(47) + 1)) + string;
        try {
            new URL(string2);
        }
        catch (MalformedURLException malformedURLException) {
            throw new NullPointerException(malformedURLException.toString());
        }
        this.setURL(uRL, "jar", "", -1, null, null, string2, null, null);
    }

    protected String toExternalForm(URL uRL) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("jar:");
        stringBuffer.append(uRL.getFile());
        String string = uRL.getRef();
        if (string != null) {
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}

