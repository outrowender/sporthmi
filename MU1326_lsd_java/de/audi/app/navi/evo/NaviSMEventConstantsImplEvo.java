/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.tghu.navi.app.appcore.INaviSMEventConstants;

public class NaviSMEventConstantsImplEvo
implements INaviSMEventConstants {
    @Override
    public int mapToVariant(int n) {
        int n2 = -1;
        switch (n) {
            case 2: {
                n2 = 1484;
                break;
            }
            case 3: {
                n2 = 1484;
                break;
            }
            case 1: {
                n2 = 1484;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }
}

