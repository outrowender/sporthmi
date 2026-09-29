/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class CarServiceASIProvider
extends ASIHMISyncCarServiceAbstractBaseService
implements IASIProvider {
    private LogChannel log;
    private ASIHMISyncCarServiceService asiService;

    public CarServiceASIProvider(LogChannel logChannel) {
        this.log = logChannel;
        this.asiService = new ASIHMISyncCarServiceService(0, this);
        try {
            this.updateASIVersion("1.0.00");
            this.updateReplyIDs(new short[]{6, 13, 14, 26, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25});
            this.updateRequestIDs(new short[]{0, 1, 2, 3, 4, 5});
        }
        catch (MethodException methodException) {
            this.log.log(10000, "CarServiceASIProvider - unknown MethodException occured.");
            methodException.printStackTrace();
        }
    }

    @Override
    public IService getService() {
        return this.asiService;
    }

    @Override
    public void attachStub(IStub iStub) {
        this.log.log(1078071040, "[attachStub] %1", (Object)iStub);
    }

    @Override
    public void detachStub(IStub iStub) {
        this.log.log(1078071040, "[detachStub] %1", (Object)iStub);
    }
}

