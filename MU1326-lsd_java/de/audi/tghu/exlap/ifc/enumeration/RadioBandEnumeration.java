/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class RadioBandEnumeration
extends Enum {
    public static final RadioBandEnumeration AM = new RadioBandEnumeration("AM", 1);
    public static final RadioBandEnumeration FM = new RadioBandEnumeration("FM", 2);
    public static final RadioBandEnumeration DAB = new RadioBandEnumeration("DAB", 3);

    protected RadioBandEnumeration(String string, int n) {
        super(string, n);
    }

    public static RadioBandEnumeration valueOf(int n) {
        switch (n) {
            case 1: {
                return AM;
            }
            case 2: {
                return FM;
            }
            case 3: {
                return DAB;
            }
        }
        return null;
    }
}

