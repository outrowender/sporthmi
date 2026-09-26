/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.tv.app.sdis.NullSDISBlockingService;

public class ParentalEnforcement {
    private ISDISBlockingService blockingService = new NullSDISBlockingService();

    public void setService(ISDISBlockingService iSDISBlockingService) {
        this.blockingService = iSDISBlockingService;
    }

    void enforceTV() {
        this.blockingService.enterAppContext(3, "");
    }
}

