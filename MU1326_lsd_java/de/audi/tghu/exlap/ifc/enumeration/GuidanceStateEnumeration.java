/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class GuidanceStateEnumeration
extends Enum {
    public static final GuidanceStateEnumeration NOT_ACTIVE = new GuidanceStateEnumeration("NOT_ACTIVE", 0);
    public static final GuidanceStateEnumeration ACTIVE = new GuidanceStateEnumeration("ACTIVE", 1);
    public static final GuidanceStateEnumeration DESTINATION_REACHED = new GuidanceStateEnumeration("DESTINATION_REACHED", 2);

    protected GuidanceStateEnumeration(String string, int n) {
        super(string, n);
    }

    public static GuidanceStateEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return NOT_ACTIVE;
            }
            case 1: {
                return ACTIVE;
            }
            case 2: {
                return DESTINATION_REACHED;
            }
        }
        return null;
    }
}

