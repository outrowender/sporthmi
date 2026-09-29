/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.app.car.sdis.base.SDISBase;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.caraircondition.DSICarAirCondition;

public class CarClimateASIProvider
extends ASIHMISyncCarClimateAbstractBaseService
implements IASIProvider {
    private LogChannel log;
    private ASIHMISyncCarClimateService asiService;
    private SDISBase sdisBase;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;

    public CarClimateASIProvider(LogChannel logChannel) {
        this.log = logChannel;
        this.asiService = new ASIHMISyncCarClimateService(0, this);
        try {
            this.updateASIVersion("1.0.00");
            this.updateReplyIDs(new short[]{7, 11, 12, 8, 9, 10});
            this.updateRequestIDs(new short[]{0, 1, 2, 4, 5, 6, 3});
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
    public void setAirconAC(boolean bl, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
        String string = (class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = CarClimateASIProvider.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition).getName();
        if (this.sdisBase != null && this.sdisBase.getDSI(string) != null) {
            this.log.log(-1601830656, "[CarASIProvider#setAirconAC] DSICarAirCondition.setAirconMaxAC: acMaxOn=%1", bl);
            ((DSICarAirCondition)this.sdisBase.getDSI(string)).setAirconMaxAC(bl);
        } else {
            this.log.log(-1601830656, "[CarASIProvider#setAirconAC] DSICarAirCondition not started yet.");
        }
    }

    public void setSDISBase(SDISBase sDISBase) {
        this.sdisBase = sDISBase;
    }

    @Override
    public void attachStub(IStub iStub) {
        this.log.log(1078071040, "[attachStub] %1", (Object)iStub);
    }

    @Override
    public void detachStub(IStub iStub) {
        this.log.log(1078071040, "[detachStub] %1", (Object)iStub);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

