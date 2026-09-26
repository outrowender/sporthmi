/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class AppConnectDeviceTypeEnumeration
extends Enum {
    public static final AppConnectDeviceTypeEnumeration NOT_CONNECTED = new AppConnectDeviceTypeEnumeration("NOT_CONNECTED", 0);
    public static final AppConnectDeviceTypeEnumeration MIRROR_LINK = new AppConnectDeviceTypeEnumeration("MIRROR_LINK", 1);
    public static final AppConnectDeviceTypeEnumeration CAR_PLAY = new AppConnectDeviceTypeEnumeration("CAR_PLAY", 2);
    public static final AppConnectDeviceTypeEnumeration GAL = new AppConnectDeviceTypeEnumeration("GAL", 3);
    public static final AppConnectDeviceTypeEnumeration UNKNOWN = new AppConnectDeviceTypeEnumeration("UNKNOWN", 4);

    protected AppConnectDeviceTypeEnumeration(String string, int n) {
        super(string, n);
    }

    public static AppConnectDeviceTypeEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return NOT_CONNECTED;
            }
            case 1: {
                return MIRROR_LINK;
            }
            case 2: {
                return CAR_PLAY;
            }
            case 3: {
                return GAL;
            }
            case 4: {
                return UNKNOWN;
            }
        }
        return null;
    }
}

