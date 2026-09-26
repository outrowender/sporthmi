/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class RadioAMFrequenciesEnumeration
extends Enum {
    public static final RadioAMFrequenciesEnumeration EURDW = new RadioAMFrequenciesEnumeration("EURDW", 0);
    public static final RadioAMFrequenciesEnumeration NAR = new RadioAMFrequenciesEnumeration("NAR", 1);
    public static final RadioAMFrequenciesEnumeration JP = new RadioAMFrequenciesEnumeration("JP", 2);
    public static final RadioAMFrequenciesEnumeration AUS = new RadioAMFrequenciesEnumeration("AUS", 3);
    public static final RadioAMFrequenciesEnumeration EU = new RadioAMFrequenciesEnumeration("EU", 4);

    protected RadioAMFrequenciesEnumeration(String string, int n) {
        super(string, n);
    }

    public static RadioAMFrequenciesEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return EURDW;
            }
            case 1: {
                return NAR;
            }
            case 2: {
                return JP;
            }
            case 3: {
                return AUS;
            }
            case 4: {
                return EU;
            }
        }
        return null;
    }
}

