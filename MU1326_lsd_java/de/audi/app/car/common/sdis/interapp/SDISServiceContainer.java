/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.sdis.interapp;

import de.audi.app.car.common.sdis.interapp.ICarSDISService;
import de.audi.atip.log.LogChannel;

public class SDISServiceContainer
implements ICarSDISService {
    private volatile ICarSDISService service;
    private final Object mutex = new Object();
    private final LogChannel logChannel;

    public SDISServiceContainer(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void setService(ICarSDISService iCarSDISService) {
        this.service = iCarSDISService;
    }

    public void asiAvailable(boolean bl) {
    }

    public void sendData(Object object) {
    }
}

