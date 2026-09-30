/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class CarBCASIProvider
extends ASIHMISyncCarBordComputerAbstractBaseService
implements IASIProvider {
    private LogChannel log;
    private ASIHMISyncCarBordComputerService asiService;

    public CarBCASIProvider(LogChannel logChannel) {
        this.log = logChannel;
        this.asiService = new ASIHMISyncCarBordComputerService(0, this);
        try {
            this.updateASIVersion("1.0.00");
            this.updateReplyIDs(new short[]{6, 23, 24, 7, 8, 9, 10, 17, 18, 19, 20, 21, 22});
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

