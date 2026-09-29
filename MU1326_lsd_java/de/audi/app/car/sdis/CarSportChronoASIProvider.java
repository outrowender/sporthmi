/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis;

import de.audi.app.car.common.sdis.interapp.ISDISSportChronoAccess;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class CarSportChronoASIProvider
extends ASIHMISyncCarSportChronoAbstractBaseService
implements IASIProvider {
    private LogChannel log;
    private ASIHMISyncCarSportChronoService asiService;
    private ISDISSportChronoAccess sportChrono;

    public CarSportChronoASIProvider(LogChannel logChannel) {
        this.log = logChannel;
        this.asiService = new ASIHMISyncCarSportChronoService(0, this);
        try {
            this.updateASIVersion("2.1.00");
        }
        catch (MethodException methodException) {
            this.log.log(10000, "CarASIProvider - could not register ASI version!");
            methodException.printStackTrace();
        }
    }

    public void setSportChronoComponent(ISDISSportChronoAccess iSDISSportChronoAccess) {
        this.sportChrono = iSDISSportChronoAccess;
    }

    private boolean isSportChronoAvailable() {
        return this.sportChrono != null;
    }

    @Override
    public void requestRecordData(long l, long l2, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        if (this.isSportChronoAvailable()) {
            SCData[] sCDataArray = this.sportChrono.requestRecordData(l, l2);
            aSIHMISyncCarSportChronoReply.responseRecordData(sCDataArray, 0);
        } else {
            SCData[] sCDataArray = new SCData[]{};
            sCDataArray[0] = new SCData();
            aSIHMISyncCarSportChronoReply.responseRecordData(sCDataArray, 255);
        }
    }

    @Override
    public void setRecord(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        if (this.isSportChronoAvailable()) {
            this.sportChrono.setRecord(n);
        }
    }

    @Override
    public void requestTrackData(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        if (this.isSportChronoAvailable()) {
            SCData[] sCDataArray = this.sportChrono.requestTrackData(n);
            if (sCDataArray != null) {
                aSIHMISyncCarSportChronoReply.responseTrackData(n, sCDataArray, 0);
            } else {
                aSIHMISyncCarSportChronoReply.responseTrackData(n, sCDataArray, 2);
            }
        }
    }

    @Override
    public void initTrackTransfer(SCHeader sCHeader, String string, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        if (this.isSportChronoAvailable()) {
            int n = this.sportChrono.initTrackTransfer(sCHeader, string);
            aSIHMISyncCarSportChronoReply.responseInitTrackTransfer(sCHeader.getUid(), n);
        }
    }

    @Override
    public void setTrackData(int n, SCData[] sCDataArray, int n2, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        if (this.isSportChronoAvailable()) {
            int n3 = this.sportChrono.setTrackData(n, sCDataArray, n2);
            aSIHMISyncCarSportChronoReply.responseSetTrackData(n, n3);
        }
    }

    @Override
    public void setReferenceLap(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    @Override
    public void requestReferenceLapData(int n, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
    }

    @Override
    public void saveReferenceLap(int n, short s, ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
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

