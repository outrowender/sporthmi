/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.dsi2asi;

import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.CarViewOption;

public class CarSportChronoAsiHandler {
    private ASIHMISyncCarSportChronoAbstractBaseService asiUpdater;
    private LogChannel logChannel;
    private ISDISFramework sdisBase;

    public CarSportChronoAsiHandler(ISDISFramework iSDISFramework) {
        this.sdisBase = iSDISFramework;
        this.asiUpdater = iSDISFramework.getASIDataUpdater().getSportChronoASI();
        this.logChannel = iSDISFramework.getLogChannel("App.CarSDIS.Base");
    }

    protected void updateSCVisibilityState(CarViewOption carViewOption) {
        try {
            int n = this.sdisBase.updateVisibility(carViewOption, (short)52);
            this.logChannel.log(1000000, "[SDISCarStatusDistributor#updateSCVisibilityState] %1", (long)n);
            this.asiUpdater.updateSCVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateSCVisibilityState] %1", (Throwable)methodException);
        }
    }

    protected void updateActiveRecord(SCHeader sCHeader) {
        try {
            this.asiUpdater.updateActiveRecord(sCHeader);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateActiveRecord] %1", (Throwable)methodException);
        }
    }

    protected void updateActiveRecordData(SCData sCData) {
        try {
            this.asiUpdater.updateActiveRecordData(sCData);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateActiveRecordData] %1", (Throwable)methodException);
        }
    }

    protected void updateRecordMode(int n) {
        try {
            this.asiUpdater.updateRecordMode(n);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateRecordMode] %1", (Throwable)methodException);
        }
    }

    protected void updateTrackList(SCHeader[] sCHeaderArray) {
        try {
            this.asiUpdater.updateTrackList(sCHeaderArray);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateTrackList] %1", (Throwable)methodException);
        }
    }

    protected void updateTransferState(TransferState transferState) {
        try {
            this.asiUpdater.updateTransferState(transferState);
        }
        catch (MethodException methodException) {
            this.logChannel.log(10000, "[SDISCarStatusDistributor#updateTransferState] %1", (Throwable)methodException);
        }
    }
}

