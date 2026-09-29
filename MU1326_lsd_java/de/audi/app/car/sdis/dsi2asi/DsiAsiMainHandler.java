/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.dsi2asi;

import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.dsi2asi.CarKombiDsiAsiHandler;
import de.audi.app.car.sdis.dsi2asi.CarSportChronoAsiHandler;
import de.audi.app.car.sdis.dsi2asi.CarVehicleStateAsiHandler;
import de.audi.app.car.sdis.dsi2asi.CarZeroEmissionAsiHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.global.CarViewOption;

public class DsiAsiMainHandler {
    protected LogChannel logChannel;
    protected ISDISFramework sdisBase;
    private CarVehicleStateAsiHandler carVehicleState;
    private CarKombiDsiAsiHandler carKombi;
    private CarSportChronoAsiHandler carSportChrono;
    private CarZeroEmissionAsiHandler carZeroEmission;

    public DsiAsiMainHandler(ISDISFramework iSDISFramework) {
        this.sdisBase = iSDISFramework;
        this.logChannel = iSDISFramework.getLogChannel("App.CarSDIS.Base");
        this.carVehicleState = new CarVehicleStateAsiHandler(iSDISFramework);
        this.carKombi = new CarKombiDsiAsiHandler(iSDISFramework);
        this.carSportChrono = new CarSportChronoAsiHandler(iSDISFramework);
        this.carZeroEmission = new CarZeroEmissionAsiHandler(iSDISFramework);
    }

    protected void updateOilLevelData(OilLevelData oilLevelData) {
        this.carVehicleState.updateOilLevelData(oilLevelData);
    }

    protected void updateOilLevelDataVisibilityState(CarViewOption carViewOption) {
        this.carVehicleState.updateOilLevelDataVisibilityState(carViewOption);
    }

    protected void updateVinData(String string) {
        this.carVehicleState.updateVinData(string);
    }

    protected void updateVinDataVisibilityState(CarViewOption carViewOption) {
        this.carVehicleState.updateVinDataVisibilityState(carViewOption);
    }

    protected void updateKeyDataVisibilityState(CarViewOption carViewOption) {
        this.carVehicleState.updateKeyDataVisibilityState(carViewOption);
    }

    protected void updateKeyData(KeyData keyData) {
        this.carVehicleState.updateKeyData(keyData);
    }

    protected void updateSIAOilInspection(SIAOilInspection sIAOilInspection) {
    }

    protected void updateSIAOilInspectionVisibilityState(CarViewOption carViewOption) {
        this.carKombi.updateSIAOilInspectionVisibilityState(carViewOption);
    }

    protected void updateSIAServiceData(SIAServiceData sIAServiceData) {
        this.carKombi.updateSIAServiceData(sIAServiceData);
    }

    protected void updateSCVisibilityState(CarViewOption carViewOption) {
        this.carSportChrono.updateSCVisibilityState(carViewOption);
    }

    protected void updateActiveRecord(SCHeader sCHeader) {
        this.carSportChrono.updateActiveRecord(sCHeader);
    }

    protected void updateActiveRecordData(SCData sCData) {
        this.carSportChrono.updateActiveRecordData(sCData);
    }

    protected void updateRecordMode(int n) {
        this.carSportChrono.updateRecordMode(n);
    }

    protected void updateTrackList(SCHeader[] sCHeaderArray) {
        this.carSportChrono.updateTrackList(sCHeaderArray);
    }

    protected void updateTransferState(TransferState transferState) {
        this.carSportChrono.updateTransferState(transferState);
    }

    protected void updateZEVisibilityState(CarViewOption carViewOption) {
        this.carZeroEmission.updateVisibilityState(carViewOption);
    }

    protected void updateZECurrentBarGraph(ZeroEmissionEntry zeroEmissionEntry) {
        this.carZeroEmission.updateZECurrentBarGraph(zeroEmissionEntry);
    }

    protected void updateZEHistoryBarGraph(ZeroEmissionEntry[] zeroEmissionEntryArray) {
        this.carZeroEmission.updateZEHistoryBarGraph(zeroEmissionEntryArray);
    }

    protected void updateRDKTireDisplayData(RDKTireDisplayData rDKTireDisplayData) {
    }

    protected void updateRDKTireDisplayDataVisibilityState(int n) {
    }

    protected CarVehicleStateAsiHandler getCarVehicleStateFunctions() {
        return this.carVehicleState;
    }

    protected CarKombiDsiAsiHandler getCarKombiFunctions() {
        return this.carKombi;
    }

    protected CarSportChronoAsiHandler getCarSportChronoFunctions() {
        return this.carSportChrono;
    }

    protected CarZeroEmissionAsiHandler getCarZeroEmissionFunctions() {
        return this.carZeroEmission;
    }
}

