/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.tone.app.IToneTextConstants;

public class ToneTextConstantsImplEvo
implements IToneTextConstants {
    @Override
    public int mapToVariant(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                return 1698959104;
            }
            case 2: {
                return -1824190720;
            }
            case 3: {
                return -1706750208;
            }
        }
        return n2;
    }
}

