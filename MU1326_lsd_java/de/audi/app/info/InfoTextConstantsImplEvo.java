/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info;

import de.audi.tghu.info.app.IInfoTextConstants;

public class InfoTextConstantsImplEvo
implements IInfoTextConstants {
    public int mapToVariant(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 500060;
                break;
            }
            case 1: {
                n2 = 500059;
                break;
            }
        }
        return n2;
    }
}

