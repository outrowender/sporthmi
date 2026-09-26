/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.atip.log.LogChannel;
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

public abstract class AbstractDSICarVehicleState
implements DSICarVehicleStatesListener {
    protected LogChannel logger;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;

    public AbstractDSICarVehicleState(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logStub();
    }

    @Override
    public void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        this.logStub();
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        this.logStub();
    }

    @Override
    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        this.logStub();
    }

    @Override
    public void updateVINData(String string, int n) {
        this.logStub();
    }

    @Override
    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        this.logStub();
    }

    @Override
    public void updateKeyData(KeyData keyData, int n) {
        this.logStub();
    }

    @Override
    public void updateDrvSchoolSystem(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        this.logStub();
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        this.logStub();
    }

    @Override
    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        this.logStub();
    }

    @Override
    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        this.logStub();
    }

    public void responseServiceKey(int n, byte[] byArray) {
        this.logStub();
    }

    protected void logStub() {
        try {
            StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
            String string = "??";
            if (stackTraceElementArray.length > 1) {
                StackTraceElement stackTraceElement = stackTraceElementArray[1];
                string = new StringBuffer().append(stackTraceElement.getClassName()).append(".").append(stackTraceElementArray[1].getMethodName()).toString();
            }
            this.logger.log(1078071040, "%1 not implemented", (Object)string);
        }
        catch (Exception exception) {
            this.logger.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = AbstractDSICarVehicleState.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = AbstractDSICarVehicleState.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName();
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

