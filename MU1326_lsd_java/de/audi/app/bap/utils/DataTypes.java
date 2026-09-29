/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class DataTypes {
    private static final String BAPDATATYPE_INT8;
    private static final String BAPDATATYPE_INT16;
    private static final String BAPDATATYPE_INT32;
    private static final String BAPDATATYPE_BYTESEQUENCE;
    private static final String BAPDATATYPE_UNKNOWN;

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return "INT8";
            }
            case 1: {
                return "INT16";
            }
            case 2: {
                return "INT32";
            }
            case 3: {
                return "BYTESEQUENCE";
            }
        }
        Buffer buffer = new Buffer("UNKNOWN");
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

