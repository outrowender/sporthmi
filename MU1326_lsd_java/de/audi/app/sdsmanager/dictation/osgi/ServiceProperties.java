/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.osgi;

import de.audi.atip.util.Util;
import java.util.Dictionary;
import java.util.Hashtable;

public final class ServiceProperties {
    public static Dictionary createServiceProperties(String string, int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "SDSManager");
        hashtable.put("moduleID", Util.createInteger(14));
        return hashtable;
    }

    public static Dictionary createDsiListenerProperties(String string, String string2, int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "SDSManager");
        hashtable.put("DEVICE_NAME", string2);
        hashtable.put("DEVICE_INSTANCE", Util.createInteger(n));
        return hashtable;
    }

    public static Dictionary createActionProxyServiceProperties(String string, int n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "SDSManager");
        hashtable.put("moduleID", Util.createInteger(n));
        return hashtable;
    }
}

