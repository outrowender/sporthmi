/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class StartGuidanceResultEnumeration
extends Enum {
    public static final StartGuidanceResultEnumeration OK = new StartGuidanceResultEnumeration("OK", 0);
    public static final StartGuidanceResultEnumeration REQUESTED = new StartGuidanceResultEnumeration("REQUESTED", 1);
    public static final StartGuidanceResultEnumeration DECLINED = new StartGuidanceResultEnumeration("DECLINED", 2);
    public static final StartGuidanceResultEnumeration INTERNAL_ERROR = new StartGuidanceResultEnumeration("INTERNAL_ERROR", 3);
    public static final StartGuidanceResultEnumeration CALCULATION_IN_PROGRESS = new StartGuidanceResultEnumeration("CALCULATION_IN_PROGRESS", 4);
    public static final StartGuidanceResultEnumeration NOT_NAVIGABLE = new StartGuidanceResultEnumeration("NOT_NAVIGABLE", 5);

    protected StartGuidanceResultEnumeration(String string, int n) {
        super(string, n);
    }

    public static StartGuidanceResultEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return OK;
            }
            case 1: {
                return REQUESTED;
            }
            case 2: {
                return DECLINED;
            }
            case 3: {
                return INTERNAL_ERROR;
            }
            case 4: {
                return CALCULATION_IN_PROGRESS;
            }
            case 5: {
                return NOT_NAVIGABLE;
            }
        }
        return null;
    }
}

