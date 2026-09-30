/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class SDSDebugChannelsEnum {
    static final SDSDebugChannelsEnum ALL = new SDSDebugChannelsEnum("ALL", true);
    public static final SDSDebugChannelsEnum DEFAULT = new SDSDebugChannelsEnum("DEFAULT", true);
    public static final SDSDebugChannelsEnum MAIN = new SDSDebugChannelsEnum("MAIN", true);
    public static final SDSDebugChannelsEnum NAVI = new SDSDebugChannelsEnum("NAVI", true);
    public static final SDSDebugChannelsEnum PHONE = new SDSDebugChannelsEnum("PHONE", true);
    public static final SDSDebugChannelsEnum MEDIA = new SDSDebugChannelsEnum("MEDIA", true);
    public static final SDSDebugChannelsEnum ONLINE = new SDSDebugChannelsEnum("ONLINE", true);
    public static final SDSDebugChannelsEnum CAR = new SDSDebugChannelsEnum("CAR", true);
    private static final String BASE_NAME = "SDSDebugChannel-";
    private static Map indexToEnumMap;
    private final String name;
    private volatile boolean activationStatus;

    private SDSDebugChannelsEnum(String string, boolean bl) {
        if (indexToEnumMap == null) {
            indexToEnumMap = new HashMap();
        }
        this.name = string;
        this.activationStatus = bl;
        indexToEnumMap.put(new Integer(indexToEnumMap.size()), this);
    }

    static SDSDebugChannelsEnum getChannelByIndex(int n) {
        if (n < 0 || n >= indexToEnumMap.size()) {
            return DEFAULT;
        }
        return (SDSDebugChannelsEnum)indexToEnumMap.get(new Integer(n));
    }

    static int getChannelsSize() {
        return indexToEnumMap.size();
    }

    synchronized boolean isActive() {
        return this.activationStatus;
    }

    synchronized void toggleActivationStatus() {
        boolean bl = this.activationStatus = !this.activationStatus;
        if (this.name.equalsIgnoreCase("ALL")) {
            Iterator iterator = indexToEnumMap.values().iterator();
            while (iterator.hasNext()) {
                SDSDebugChannelsEnum sDSDebugChannelsEnum = (SDSDebugChannelsEnum)iterator.next();
                sDSDebugChannelsEnum.activationStatus = this.activationStatus;
            }
        }
    }

    String getChannelName() {
        return this.name;
    }

    public String toString() {
        return new Buffer().append(BASE_NAME).append(this.name).toString();
    }
}

