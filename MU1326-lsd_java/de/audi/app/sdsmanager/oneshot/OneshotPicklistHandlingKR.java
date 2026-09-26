/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.atip.hmi.HMIService;

public class OneshotPicklistHandlingKR
implements IOneshotPicklistHandling {
    private final HMIService hmi;

    public OneshotPicklistHandlingKR(HMIService hMIService) {
        this.hmi = hMIService;
    }

    @Override
    public void handlePicklistTitle(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 14;
                break;
            }
            case 1: {
                n2 = 15;
                break;
            }
            case 2: {
                n2 = 17;
                break;
            }
            case 3: {
                n2 = 19;
                break;
            }
            case 38: {
                n2 = 7;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        this.hmi.getChoiceModel(3833).setValue(n2);
    }

    @Override
    public int getSlotLevelOffset() {
        return 0;
    }
}

