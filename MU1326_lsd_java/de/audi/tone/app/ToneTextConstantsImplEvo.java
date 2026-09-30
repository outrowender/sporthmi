/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.tone.app.IToneTextConstants;

public class ToneTextConstantsImplEvo
implements IToneTextConstants {
    public int mapToVariant(int n) {
        int n2 = -1;
        switch (n) {
            case 1: {
                return 1000549;
            }
            case 2: {
                return 1000851;
            }
            case 3: {
                return 1000858;
            }
        }
        return n2;
    }
}

