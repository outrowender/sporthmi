/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class ChinaStartupScreenEnumeration
extends Enum {
    public static final ChinaStartupScreenEnumeration VWIMPORTED = new ChinaStartupScreenEnumeration("VWIMPORTED", 0);
    public static final ChinaStartupScreenEnumeration SVWSCREEN = new ChinaStartupScreenEnumeration("SVWSCREEN", 1);
    public static final ChinaStartupScreenEnumeration FAWSCREEN = new ChinaStartupScreenEnumeration("FAWSCREEN", 2);
    public static final ChinaStartupScreenEnumeration INVALID = new ChinaStartupScreenEnumeration("INVALID", 3);

    protected ChinaStartupScreenEnumeration(String string, int n) {
        super(string, n);
    }

    public static ChinaStartupScreenEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return VWIMPORTED;
            }
            case 1: {
                return SVWSCREEN;
            }
            case 2: {
                return FAWSCREEN;
            }
            case 3: {
                return INVALID;
            }
        }
        return null;
    }
}

