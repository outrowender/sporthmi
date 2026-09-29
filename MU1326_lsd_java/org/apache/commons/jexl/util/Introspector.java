/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import org.apache.commons.jexl.util.introspection.Uberspect;
import org.apache.commons.jexl.util.introspection.UberspectImpl;
import org.apache.commons.jexl.util.introspection.UberspectLoggable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Introspector {
    private static Uberspect uberSpect;
    static /* synthetic */ Class class$org$apache$commons$jexl$util$Introspector;

    public static Uberspect getUberspect() {
        return uberSpect;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        Log log = LogFactory.getLog(class$org$apache$commons$jexl$util$Introspector == null ? (class$org$apache$commons$jexl$util$Introspector = Introspector.class$("org.apache.commons.jexl.util.Introspector")) : class$org$apache$commons$jexl$util$Introspector);
        uberSpect = new UberspectImpl();
        ((UberspectLoggable)((Object)uberSpect)).setRuntimeLogger(log);
    }
}

