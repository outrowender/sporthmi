/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.tghu.online.app.IOnlineTextConstants;

public class OnlineTextConstantsImplEvo
implements IOnlineTextConstants {
    @Override
    public int mapToVariant(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1193543168;
                break;
            }
            case 1: {
                n2 = 1210320384;
                break;
            }
            case 2: {
                n2 = 1227097600;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }
}

