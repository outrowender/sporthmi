/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml.PathResolver;

public class URLResolver
implements PathResolver,
Serializable {
    private static final long serialVersionUID = 1L;
    private Log log = LogFactory.getLog(class$org$apache$commons$scxml$PathResolver == null ? (class$org$apache$commons$scxml$PathResolver = URLResolver.class$("org.apache.commons.scxml.PathResolver")) : class$org$apache$commons$scxml$PathResolver);
    private URL baseURL = null;
    static /* synthetic */ Class class$org$apache$commons$scxml$PathResolver;

    public URLResolver(URL uRL) {
        this.baseURL = uRL;
    }

    public String resolvePath(String string) {
        try {
            URL uRL = new URL(this.baseURL, string);
            return uRL.toString();
        }
        catch (MalformedURLException malformedURLException) {
            this.log.error("Malformed URL", malformedURLException);
            return null;
        }
    }

    public PathResolver getResolver(String string) {
        try {
            URL uRL = new URL(this.baseURL, string);
            return new URLResolver(uRL);
        }
        catch (MalformedURLException malformedURLException) {
            this.log.error("Malformed URL", malformedURLException);
            return null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

