/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class EntertainmentContextEnumeration
extends Enum {
    public static final EntertainmentContextEnumeration NONE = new EntertainmentContextEnumeration("NONE", 0);
    public static final EntertainmentContextEnumeration RADIO = new EntertainmentContextEnumeration("RADIO", 1);
    public static final EntertainmentContextEnumeration MEDIA = new EntertainmentContextEnumeration("MEDIA", 2);
    public static final EntertainmentContextEnumeration APP_CONNECT = new EntertainmentContextEnumeration("APP_CONNECT", 3);
    public static final EntertainmentContextEnumeration TV = new EntertainmentContextEnumeration("TV", 4);

    protected EntertainmentContextEnumeration(String string, int n) {
        super(string, n);
    }

    public static EntertainmentContextEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return NONE;
            }
            case 1: {
                return RADIO;
            }
            case 2: {
                return MEDIA;
            }
            case 3: {
                return APP_CONNECT;
            }
            case 4: {
                return TV;
            }
        }
        return null;
    }
}

