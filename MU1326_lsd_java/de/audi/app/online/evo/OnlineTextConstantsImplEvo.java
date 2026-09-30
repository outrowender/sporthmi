/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.tghu.online.app.IOnlineTextConstants;

public class OnlineTextConstantsImplEvo
implements IOnlineTextConstants {
    public int mapToVariant(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 402503;
                break;
            }
            case 1: {
                n2 = 402504;
                break;
            }
            case 2: {
                n2 = 402505;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }
}

