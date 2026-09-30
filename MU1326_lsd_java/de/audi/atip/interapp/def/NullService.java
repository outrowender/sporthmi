/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.log.LogChannel;

public class NullService {
    private final int loglevel;
    protected final LogChannel lc;
    private final String serviceName;

    protected NullService(LogChannel logChannel, int n, String string) {
        this.lc = logChannel;
        this.loglevel = n;
        this.serviceName = string;
    }

    protected NullService(LogChannel logChannel, String string) {
        this.lc = logChannel;
        this.loglevel = 100000;
        this.serviceName = string;
    }

    protected NullService(LogChannel logChannel, int n, Class clazz) {
        this(logChannel, n, NullService.getShortClassName(clazz));
    }

    protected NullService(LogChannel logChannel, Class clazz) {
        this(logChannel, NullService.getShortClassName(clazz));
    }

    protected void log() {
        this.lc.log(this.loglevel, "[Null%1] No OSGi service '%1' registered!", (Object)this.serviceName);
    }

    protected void log(String string) {
        this.lc.log(this.loglevel, "[Null%1] No OSGi service '%1' registered! tried to call: %2", (Object)this.serviceName, (Object)string);
    }

    private static String getShortClassName(Class clazz) {
        String string;
        String string2 = clazz.getName();
        String string3 = "";
        Package package_ = clazz.getPackage();
        if (package_ != null && (string = package_.getName()) != null && string.length() > 0) {
            string3 = string + ".";
        }
        String string4 = string3.length() > 0 && string2.startsWith(string3) ? string2.substring(string3.length()) : string2;
        return string4;
    }
}

