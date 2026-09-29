/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class ExlapRestrictionModeEnumeration
extends Enum {
    public static final ExlapRestrictionModeEnumeration CHILD = new ExlapRestrictionModeEnumeration("CHILD", 0);
    public static final ExlapRestrictionModeEnumeration STANDARD = new ExlapRestrictionModeEnumeration("STANDARD", 1);
    public static final ExlapRestrictionModeEnumeration CHAUFFEUR = new ExlapRestrictionModeEnumeration("CHAUFFEUR", 2);

    protected ExlapRestrictionModeEnumeration(String string, int n) {
        super(string, n);
    }

    public static ExlapRestrictionModeEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return CHILD;
            }
            case 1: {
                return STANDARD;
            }
            case 2: {
                return CHAUFFEUR;
            }
        }
        return null;
    }
}

