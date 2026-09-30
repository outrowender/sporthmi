/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractDSICarVehicleStatesAdapter
extends AbstractCarComponent
implements DSICarVehicleStatesListener {
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;

    public AbstractDSICarVehicleStatesAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarVehicleStates getDSI() {
        return (DSICarVehicleStates)this.getBaseDSI();
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = AbstractDSICarVehicleStatesAdapter.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AbstractDSICarVehicleStatesAdapter.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName();
    }

    public final boolean isUsingDSI() {
        return true;
    }

    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        this.logStub();
    }

    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        this.logStub();
    }

    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        this.logStub();
    }

    public void updateVINData(String string, int n) {
        this.logStub();
    }

    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        this.logStub();
    }

    public void updateKeyData(KeyData keyData, int n) {
        this.logStub();
    }

    public void updateDrvSchoolBlinkingState(int n, int n2) {
        this.logStub();
    }

    public void updateDrvSchoolSystem(boolean bl, int n) {
        this.logStub();
    }

    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        this.logStub();
    }

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        this.logStub();
    }

    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        this.logStub();
    }

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        this.logStub();
    }

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        this.logStub();
    }

    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
        this.logStub();
    }

    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        this.logStub();
    }

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        this.logStub();
    }

    public void responseServiceKey(int n, byte[] byArray) {
        this.logStub();
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

