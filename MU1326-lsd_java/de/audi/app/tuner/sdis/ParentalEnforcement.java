/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.sdis;

import de.audi.app.tuner.sdis.NullSDISBlockingService;
import de.audi.atip.interapp.sdis.ISDISBlockingService;

public class ParentalEnforcement {
    private ISDISBlockingService blockingService = new NullSDISBlockingService();

    public void setService(ISDISBlockingService iSDISBlockingService) {
        this.blockingService = iSDISBlockingService;
    }

    void enforceRadio() {
        this.blockingService.enterAppContext(1, "");
    }
}

