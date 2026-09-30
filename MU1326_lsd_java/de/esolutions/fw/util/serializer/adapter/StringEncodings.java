/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;

public class StringEncodings {
    public static final byte ENCODING_UTF8 = 0;
    public static final byte ENCODING_UTF16 = 1;
    public static final byte ENCODING_UTF32 = 2;
    public static final byte ENCODING_TOTAL = 3;
    public static final String[] names = new String[]{"UTF8", "UTF16", "UTF32"};
    public static final int[] byteWidth = new int[]{1, 2, 4};
    public static final StringConverter UTF8 = StringConverter.UTF8;
    public static final StringConverter UTF16 = new StringConverter("UTF16");
    public static final StringConverter UTF32 = new StringConverter("UTF32");

    public static StringConverter getConverter(int n) {
        switch (n) {
            case 0: {
                return UTF8;
            }
            case 1: {
                return UTF16;
            }
            case 2: {
                return UTF32;
            }
        }
        return null;
    }
}

