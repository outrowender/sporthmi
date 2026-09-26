/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class GPXDataTypeEnumeration
extends Enum {
    public static final GPXDataTypeEnumeration ROUTE_IMPORT = new GPXDataTypeEnumeration("ROUTE_IMPORT", 0);
    public static final GPXDataTypeEnumeration TOUR_IMPORT = new GPXDataTypeEnumeration("TOUR_IMPORT", 1);

    protected GPXDataTypeEnumeration(String string, int n) {
        super(string, n);
    }

    public static GPXDataTypeEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return ROUTE_IMPORT;
            }
            case 1: {
                return TOUR_IMPORT;
            }
        }
        return null;
    }
}

