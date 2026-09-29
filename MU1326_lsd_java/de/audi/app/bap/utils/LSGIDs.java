/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public final class LSGIDs {
    private static final String LSG_ID_UNKNOWN;
    private static final SimpleIntObjectMap LSG_DESCRIPTIONS;

    public static String getDescription(int n) {
        String string = (String)LSG_DESCRIPTIONS.get(n);
        if (string == null) {
            Buffer buffer = new Buffer();
            buffer.append(n).append(" (UNKNOWN)");
            return buffer.toString();
        }
        return string;
    }

    public static void registerLSGID(int n, String string) {
        LSG_DESCRIPTIONS.add(n, string);
    }

    static {
        LSG_DESCRIPTIONS = new SimpleIntObjectMap();
    }
}

