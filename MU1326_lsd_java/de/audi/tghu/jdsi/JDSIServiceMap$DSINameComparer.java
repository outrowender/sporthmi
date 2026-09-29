/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIServiceMap$1;
import java.util.Comparator;

class JDSIServiceMap$DSINameComparer
implements Comparator {
    private JDSIServiceMap$DSINameComparer() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = 0;
        if (object == null && object2 == null) {
            n = 0;
        } else if (object == null) {
            n = 1;
        } else if (object2 == null) {
            n = -1;
        } else {
            try {
                String string = ((String[])object)[0];
                String string2 = ((String[])object)[0];
                n = string.compareToIgnoreCase(string2);
            }
            catch (ClassCastException classCastException) {
                n = 0;
            }
        }
        return n;
    }

    /* synthetic */ JDSIServiceMap$DSINameComparer(JDSIServiceMap$1 jDSIServiceMap$1) {
        this();
    }
}

