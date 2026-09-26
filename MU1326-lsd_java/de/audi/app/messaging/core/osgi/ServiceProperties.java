/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.osgi;

import de.audi.app.messaging.core.application.MessagingConstants;
import de.audi.atip.util.Util;
import java.util.Dictionary;
import java.util.Hashtable;

public final class ServiceProperties {
    public static Dictionary createServiceProperties() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", MessagingConstants.MSG_APP_NAME);
        hashtable.put("moduleID", Util.createInteger(22));
        return hashtable;
    }

    public static Dictionary createDsiListenerProperties(String string, int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", MessagingConstants.MSG_APP_NAME);
        hashtable.put("DEVICE_NAME", string);
        hashtable.put("DEVICE_INSTANCE", Util.createInteger(n));
        return hashtable;
    }

    public static Dictionary createActionProxyServiceProperties(int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", MessagingConstants.MSG_APP_NAME);
        hashtable.put("moduleID", Util.createInteger(n));
        return hashtable;
    }
}

