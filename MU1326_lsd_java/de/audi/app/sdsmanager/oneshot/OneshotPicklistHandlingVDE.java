/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.atip.hmi.HMIService;

public class OneshotPicklistHandlingVDE
implements IOneshotPicklistHandling {
    private final HMIService hmi;

    public OneshotPicklistHandlingVDE(HMIService hMIService) {
        this.hmi = hMIService;
    }

    @Override
    public void handlePicklistTitle(int n) {
        int n2;
        int n3 = 3833;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 7;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        this.hmi.getChoiceModel(n3).setValue(n2);
    }

    @Override
    public int getSlotLevelOffset() {
        return 1;
    }
}

