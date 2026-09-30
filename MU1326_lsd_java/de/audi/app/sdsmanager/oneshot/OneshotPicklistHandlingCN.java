/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.oneshot.OneshotPicklistHandlingVDE;
import de.audi.atip.hmi.HMIService;

public class OneshotPicklistHandlingCN
extends OneshotPicklistHandlingVDE {
    public OneshotPicklistHandlingCN(HMIService hMIService) {
        super(hMIService);
    }

    public int getSlotLevelOffset() {
        return 0;
    }
}

