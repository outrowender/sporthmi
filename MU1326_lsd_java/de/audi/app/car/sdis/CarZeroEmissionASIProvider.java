/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.app.car.common.sdis.interapp.ISDISZeroEmissionAccess;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class CarZeroEmissionASIProvider
extends ASIHMISyncCarZeroEmissionAbstractBaseService
implements IASIProvider {
    protected final LogChannel logChannel;
    protected ISDISZeroEmissionAccess zeroEmissionAccess;
    private ASIHMISyncCarZeroEmissionService asiService;

    public CarZeroEmissionASIProvider(LogChannel logChannel) {
        this.logChannel = logChannel;
        this.asiService = new ASIHMISyncCarZeroEmissionService(0, this);
        try {
            this.updateASIVersion("1.1.00");
        }
        catch (MethodException methodException) {
            logChannel.log(10000, "[CarZeroEmissionASIProvider] Could not register ASI version!");
            methodException.printStackTrace();
        }
    }

    public boolean isZeroEmissionAccessAvailable() {
        return null != this.zeroEmissionAccess;
    }

    public void setZeroEmissionAccess(ISDISZeroEmissionAccess iSDISZeroEmissionAccess) {
        this.zeroEmissionAccess = iSDISZeroEmissionAccess;
    }

    @Override
    public IService getService() {
        return this.asiService;
    }

    @Override
    public void attachStub(IStub iStub) {
    }

    @Override
    public void detachStub(IStub iStub) {
    }
}

