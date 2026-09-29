/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class SoundSourceEnumeration
extends Enum {
    public static final SoundSourceEnumeration ENTERTAINMENT = new SoundSourceEnumeration("ENTERTAINMENT", 1);
    public static final SoundSourceEnumeration TA = new SoundSourceEnumeration("TA", 2);
    public static final SoundSourceEnumeration NAVIGATION = new SoundSourceEnumeration("NAVIGATION", 3);
    public static final SoundSourceEnumeration PHONE = new SoundSourceEnumeration("PHONE", 4);
    public static final SoundSourceEnumeration SDS = new SoundSourceEnumeration("SDS", 5);

    protected SoundSourceEnumeration(String string, int n) {
        super(string, n);
    }

    public static SoundSourceEnumeration valueOf(int n) {
        switch (n) {
            case 1: {
                return ENTERTAINMENT;
            }
            case 2: {
                return TA;
            }
            case 3: {
                return NAVIGATION;
            }
            case 4: {
                return PHONE;
            }
            case 5: {
                return SDS;
            }
        }
        return null;
    }
}

