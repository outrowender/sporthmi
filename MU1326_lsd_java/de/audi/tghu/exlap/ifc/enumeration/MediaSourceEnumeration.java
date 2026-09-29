/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class MediaSourceEnumeration
extends Enum {
    public static final MediaSourceEnumeration CDDVDINTERNAL = new MediaSourceEnumeration("CDDVDINTERNAL", 1);
    public static final MediaSourceEnumeration SDCARD = new MediaSourceEnumeration("SDCARD", 2);
    public static final MediaSourceEnumeration AUX = new MediaSourceEnumeration("AUX", 3);
    public static final MediaSourceEnumeration CDDVDCHANGER = new MediaSourceEnumeration("CDDVDCHANGER", 4);
    public static final MediaSourceEnumeration HDD = new MediaSourceEnumeration("HDD", 5);
    public static final MediaSourceEnumeration BTAUDIO = new MediaSourceEnumeration("BTAUDIO", 6);
    public static final MediaSourceEnumeration USB = new MediaSourceEnumeration("USB", 8);
    public static final MediaSourceEnumeration SDCARD2 = new MediaSourceEnumeration("SDCARD2", 10);
    public static final MediaSourceEnumeration WLAN = new MediaSourceEnumeration("WLAN", 11);
    public static final MediaSourceEnumeration USB2 = new MediaSourceEnumeration("USB2", 13);
    public static final MediaSourceEnumeration USB3 = new MediaSourceEnumeration("USB3", 14);
    public static final MediaSourceEnumeration USB1PART2 = new MediaSourceEnumeration("USB1PART2", 15);
    public static final MediaSourceEnumeration USB2PART2 = new MediaSourceEnumeration("USB2PART2", 16);
    public static final MediaSourceEnumeration USB3PART2 = new MediaSourceEnumeration("USB3PART2", 17);
    public static final MediaSourceEnumeration USB4 = new MediaSourceEnumeration("USB4", 18);
    public static final MediaSourceEnumeration USB4PART2 = new MediaSourceEnumeration("USB4PART2", 19);

    protected MediaSourceEnumeration(String string, int n) {
        super(string, n);
    }

    public static MediaSourceEnumeration valueOf(int n) {
        switch (n) {
            case 1: {
                return CDDVDINTERNAL;
            }
            case 2: {
                return SDCARD;
            }
            case 3: {
                return AUX;
            }
            case 4: {
                return CDDVDCHANGER;
            }
            case 5: {
                return HDD;
            }
            case 6: {
                return BTAUDIO;
            }
            case 8: {
                return USB;
            }
            case 10: {
                return SDCARD2;
            }
            case 11: {
                return WLAN;
            }
            case 13: {
                return USB2;
            }
            case 14: {
                return USB3;
            }
            case 15: {
                return USB1PART2;
            }
            case 16: {
                return USB2PART2;
            }
            case 17: {
                return USB3PART2;
            }
            case 18: {
                return USB4;
            }
            case 19: {
                return USB4PART2;
            }
        }
        return null;
    }
}

