/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.atip.hmi.HMIService;

public class OneshotPicklistHandlingPOICity
implements IOneshotPicklistHandling {
    private final HMIService hmi;

    public OneshotPicklistHandlingPOICity(HMIService hMIService) {
        this.hmi = hMIService;
    }

    public void handlePicklistTitle(int n) {
        int n2;
        int n3;
        switch (n) {
            case 20: {
                n3 = 3833;
                n2 = 1;
                break;
            }
            default: {
                n3 = 3831;
                n2 = 0;
            }
        }
        this.hmi.getChoiceModel(n3).setValue(n2);
    }

    public int getSlotLevelOffset() {
        return 0;
    }
}

