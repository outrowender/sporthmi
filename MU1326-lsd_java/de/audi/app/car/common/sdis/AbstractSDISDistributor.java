/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis;

import de.audi.app.car.common.sdis.interapp.ICarSDISService;
import de.audi.atip.log.LogChannel;

public abstract class AbstractSDISDistributor {
    private final ICarSDISService sdisService;
    private final LogChannel logChannel;

    public AbstractSDISDistributor(ICarSDISService iCarSDISService, LogChannel logChannel) {
        this.sdisService = iCarSDISService;
        this.logChannel = logChannel;
    }

    protected LogChannel getLogChannel() {
        return this.logChannel;
    }

    ICarSDISService getService() {
        return this.sdisService;
    }
}

