/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class RadioFMFrequenciesEnumeration
extends Enum {
    public static final RadioFMFrequenciesEnumeration EURDW = new RadioFMFrequenciesEnumeration("EURDW", 0);
    public static final RadioFMFrequenciesEnumeration NAR = new RadioFMFrequenciesEnumeration("NAR", 1);
    public static final RadioFMFrequenciesEnumeration JP = new RadioFMFrequenciesEnumeration("JP", 2);
    public static final RadioFMFrequenciesEnumeration KOR = new RadioFMFrequenciesEnumeration("KOR", 3);
    public static final RadioFMFrequenciesEnumeration CN = new RadioFMFrequenciesEnumeration("CN", 4);

    protected RadioFMFrequenciesEnumeration(String string, int n) {
        super(string, n);
    }

    public static RadioFMFrequenciesEnumeration valueOf(int n) {
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
                return KOR;
            }
            case 4: {
                return CN;
            }
        }
        return null;
    }
}

