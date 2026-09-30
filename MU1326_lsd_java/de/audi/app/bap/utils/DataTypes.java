/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class DataTypes {
    private static final String BAPDATATYPE_INT8 = "INT8";
    private static final String BAPDATATYPE_INT16 = "INT16";
    private static final String BAPDATATYPE_INT32 = "INT32";
    private static final String BAPDATATYPE_BYTESEQUENCE = "BYTESEQUENCE";
    private static final String BAPDATATYPE_UNKNOWN = "UNKNOWN";

    public static String getDescription(int n) {
        switch (n) {
            case 0: {
                return BAPDATATYPE_INT8;
            }
            case 1: {
                return BAPDATATYPE_INT16;
            }
            case 2: {
                return BAPDATATYPE_INT32;
            }
            case 3: {
                return BAPDATATYPE_BYTESEQUENCE;
            }
        }
        Buffer buffer = new Buffer(BAPDATATYPE_UNKNOWN);
        buffer.append(" (");
        buffer.append(n);
        buffer.append(")");
        return buffer.toString();
    }
}

