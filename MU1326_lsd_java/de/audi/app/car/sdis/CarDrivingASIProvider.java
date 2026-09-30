/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class CarDrivingASIProvider
extends ASIHMISyncCarDrivingAbstractBaseService
implements IASIProvider {
    private LogChannel log;
    private ASIHMISyncCarDrivingService asiService;

    public CarDrivingASIProvider(LogChannel logChannel) {
        this.log = logChannel;
        this.asiService = new ASIHMISyncCarDrivingService(0, this);
        try {
            this.updateASIVersion("1.1.00");
            this.updateReplyIDs(new short[]{6, 9, 10, 11, 13, 14, 15, 22, 21});
            this.updateRequestIDs(new short[]{0, 1, 2, 3, 4, 5});
        }
        catch (MethodException methodException) {
            this.log.log(10000, "CarServiceASIProvider - unknown MethodException occured.");
            methodException.printStackTrace();
        }
    }

    public IService getService() {
        return this.asiService;
    }

    public void attachStub(IStub iStub) {
        this.log.log(1000000, "[attachStub] %1", (Object)iStub);
    }

    public void detachStub(IStub iStub) {
        this.log.log(1000000, "[detachStub] %1", (Object)iStub);
    }
}

