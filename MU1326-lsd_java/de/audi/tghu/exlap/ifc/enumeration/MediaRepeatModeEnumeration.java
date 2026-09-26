/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class MediaRepeatModeEnumeration
extends Enum {
    public static final MediaRepeatModeEnumeration REPEAT_OFF = new MediaRepeatModeEnumeration("REPEAT_OFF", 0);
    public static final MediaRepeatModeEnumeration REPEAT_SCOPE = new MediaRepeatModeEnumeration("REPEAT_SCOPE", 1);
    public static final MediaRepeatModeEnumeration REPEAT_SINGLE = new MediaRepeatModeEnumeration("REPEAT_SINGLE", 2);

    protected MediaRepeatModeEnumeration(String string, int n) {
        super(string, n);
    }

    public static MediaRepeatModeEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return REPEAT_OFF;
            }
            case 1: {
                return REPEAT_SCOPE;
            }
            case 2: {
                return REPEAT_SINGLE;
            }
        }
        return null;
    }
}

