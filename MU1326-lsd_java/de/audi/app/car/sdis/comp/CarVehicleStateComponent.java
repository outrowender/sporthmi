/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractDSICarVehicleState;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.comp.CarVehicleStateComponent$CarStateHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class CarVehicleStateComponent
extends AbstractDSICarVehicleState
implements IDSIObserver {
    private static final String LOG_CHANNEL_NAME;
    public static final byte[] CODING;
    private static final int[] attributes;
    private LogChannel logger;
    private DSICarVehicleStates dsi;
    private ISDISFramework baseService;
    private CarVehicleStateComponent$CarStateHandler carStateHandler;
    private ASIHMISyncCarServiceAbstractBaseService toSDIS;
    private OilLevelData storedOilLevelData;
    private DynamicVehicleInfoSCR storedDynamicVehicleInfoScr;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;

    public CarVehicleStateComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel("App.CarSDIS.CarVehicleState"));
        this.logger = iSDISFramework.getLogChannel("App.CarSDIS.CarVehicleState");
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getServiceASI();
        this.carStateHandler = new CarVehicleStateComponent$CarStateHandler(this, this.logger);
    }

    public void init() {
        this.logger.log(-2137614336, "register DSICarVehicleStates");
        this.notCodedInfo();
        this.carStateHandler.registerCarStates(CODING);
        this.baseService.registerDSI((class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = CarVehicleStateComponent.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName(), (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = CarVehicleStateComponent.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener).getName(), this);
    }

    public void deinit() {
        this.logger.log(-2137614336, "deregister DSICarVehicleStates and services for car states");
        this.baseService.deRegisterDSI((class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = CarVehicleStateComponent.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName());
        this.carStateHandler.deregisterCarStates();
    }

    public void notCodedInfo() {
        int n = 0;
        do {
            if (this.carStateHandler.isActivated(CODING[n])) continue;
            switch (CODING[n]) {
                case 53: {
                    this.sendUpdateAdblueVisibilityState(0);
                    break;
                }
                case 32: {
                    this.sendUpdateKeyDataVisibilityState(0);
                    break;
                }
                case 18: {
                    this.sendUpdateOilLevelVisibilityState(0);
                    break;
                }
                case 36: {
                    this.sendUpdateSpeedVisibilityState(0);
                    break;
                }
                case 19: {
                    this.sendUpdateVinDataVisibilityState(0);
                    break;
                }
                default: {
                    this.logger.log(-2137614336, "[notCodedInfo]: %1 not supported.", (long)CODING[n]);
                }
            }
        } while (++n < CODING.length);
    }

    @Override
    public synchronized void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "updateOilLevelViewOption: %1", (Object)carViewOption);
        int n2 = CarVehicleStateComponent$CarStateHandler.access$002(this.carStateHandler, this.baseService.updateVisibility(carViewOption, (short)18));
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)18, n2);
        this.sendUpdateOilLevelVisibilityState(n3);
    }

    private void sendUpdateOilLevelVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateOilLevelDataVisibilityState: %1", (long)n);
            this.toSDIS.updateOilLevelDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateOilLevelDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        if (n != 1) {
            return;
        }
        if (this.carStateHandler.isClamp15Sensitive((short)18) && CarVehicleStateComponent$CarStateHandler.access$100(this.carStateHandler)) {
            this.storedOilLevelData = oilLevelData;
            return;
        }
        this.logger.log(-2137614336, "updateOilLevelData: %1", (Object)oilLevelData);
        this.baseService.getDsiAsiHandler().updateValue(4001, oilLevelData);
    }

    @Override
    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "updateVINViewOption: %1", (Object)carViewOption);
        int n2 = this.baseService.updateVisibility(carViewOption, (short)19);
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)19, n2);
        this.sendUpdateVinDataVisibilityState(n3);
        CarVehicleStateComponent$CarStateHandler.access$202(this.carStateHandler, n3);
    }

    private void sendUpdateVinDataVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateVinDataVisibilityState: %1", (long)n);
            this.toSDIS.updateVinDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateVinDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateVINData(String string, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateVINData]: %1", (Object)string);
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateVINData: %1", (Object)string);
            this.toSDIS.updateVinData(string);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateVinData] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateKeyViewOption]: %1", (Object)carViewOption);
        int n2 = this.baseService.updateVisibility(carViewOption, (short)32);
        CarVehicleStateComponent$CarStateHandler.access$302(this.carStateHandler, n2);
        this.sendUpdateKeyDataVisibilityState(n2);
    }

    private void sendUpdateKeyDataVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateKeyDataVisibilityState: %1", (long)n);
            this.toSDIS.updateKeyDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateKeyDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateKeyData(KeyData keyData, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateKeyData]: %1", (Object)keyData);
        int[] nArray = new int[]{keyData.getActualValue(), keyData.getActiveKey(), keyData.getTargetValue()};
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateKeyData: %1", (Object)nArray);
            this.toSDIS.updateKeyData(nArray);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateKeyData] %1", (Throwable)methodException);
        }
    }

    @Override
    public synchronized void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateVehicleInfoViewOptions.adblue]: %1", (Object)vehicleInfoViewOptions.getScrInfo());
        int n2 = CarVehicleStateComponent$CarStateHandler.access$402(this.carStateHandler, this.baseService.updateVisibility(vehicleInfoViewOptions.getScrInfo(), (short)53));
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)53, n2);
        this.sendUpdateAdblueVisibilityState(n3);
    }

    private void sendUpdateAdblueVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> sendUpdateAdblueVisibilityState: %1", (long)n);
            this.toSDIS.updateAdBlueInfoVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateAdBlueDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        if (n != 1) {
            return;
        }
        if (this.carStateHandler.isClamp15Sensitive((short)53) && CarVehicleStateComponent$CarStateHandler.access$100(this.carStateHandler)) {
            this.storedDynamicVehicleInfoScr = dynamicVehicleInfoSCR;
            return;
        }
        this.logger.log(-2137614336, "[updateDynamicVehicleInfoSCR]: %1", (Object)dynamicVehicleInfoSCR);
        int n2 = Math.round(dynamicVehicleInfoSCR.getRefillLevelMin() * 51266);
        int n3 = Math.round(dynamicVehicleInfoSCR.getRefillLevelMax() * 51266);
        AdBlueInfo adBlueInfo = new AdBlueInfo(dynamicVehicleInfoSCR.getRange(), dynamicVehicleInfoSCR.getRangeUnit(), dynamicVehicleInfoSCR.getLevel(), (int)dynamicVehicleInfoSCR.getTankVolume(), dynamicVehicleInfoSCR.getStatus(), dynamicVehicleInfoSCR.getVolumeUnit(), n2, n3);
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateDynamicVehicleInfoSCR: %1", (Object)adBlueInfo);
            this.toSDIS.updateAdBlueInfo(adBlueInfo);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateDynamicVehicleInfoSCR] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (n == 1) {
            this.logger.log(-2137614336, "[updateDynamicVehicleInfoHighFrequentViewOptions.vehicleSpeed]: %1", (Object)dynamicVehicleInfoHighFrequentViewOptions.getVehicleSpeed());
            int n2 = this.baseService.updateVisibility(dynamicVehicleInfoHighFrequentViewOptions.getVehicleSpeed(), (short)128);
            this.sendUpdateSpeedVisibilityState(n2);
        }
    }

    private void sendUpdateSpeedVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> sendUpdateSpeedVisibilityState: %1", (long)n);
            this.toSDIS.updateVehicleSpeedVisibility(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateVehicleSpeedVisibility] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (n == 1) {
            this.logger.log(1078071040, "updateDynamicVehicleInfoHighFrequent(%1)", (Object)dynamicVehicleInfoHighFrequent.getVehicleSpeed());
            float f2 = dynamicVehicleInfoHighFrequent.getVehicleSpeed().getSpeedValue();
            int n2 = dynamicVehicleInfoHighFrequent.getVehicleSpeed().getSpeedUnit();
            FloatBaseType floatBaseType = new FloatBaseType(f2, n2, -1);
            try {
                this.logger.log(-2137614336, "Send update to devices -> updateDynamicVehicleInfoSCR: %1", (Object)floatBaseType);
                this.toSDIS.updateVehicleSpeed(floatBaseType);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[updateVehicleSpeed] %1", (Throwable)methodException);
            }
        }
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsi = (DSICarVehicleStates)dSIBase;
        this.dsi.setNotification(attributes, (DSIListener)this);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ISDISFramework access$500(CarVehicleStateComponent carVehicleStateComponent) {
        return carVehicleStateComponent.baseService;
    }

    static /* synthetic */ void access$600(CarVehicleStateComponent carVehicleStateComponent, int n) {
        carVehicleStateComponent.sendUpdateVinDataVisibilityState(n);
    }

    static /* synthetic */ void access$700(CarVehicleStateComponent carVehicleStateComponent, int n) {
        carVehicleStateComponent.sendUpdateKeyDataVisibilityState(n);
    }

    static /* synthetic */ void access$800(CarVehicleStateComponent carVehicleStateComponent, int n) {
        carVehicleStateComponent.sendUpdateOilLevelVisibilityState(n);
    }

    static /* synthetic */ void access$900(CarVehicleStateComponent carVehicleStateComponent, int n) {
        carVehicleStateComponent.sendUpdateAdblueVisibilityState(n);
    }

    static /* synthetic */ OilLevelData access$1000(CarVehicleStateComponent carVehicleStateComponent) {
        return carVehicleStateComponent.storedOilLevelData;
    }

    static /* synthetic */ OilLevelData access$1002(CarVehicleStateComponent carVehicleStateComponent, OilLevelData oilLevelData) {
        carVehicleStateComponent.storedOilLevelData = oilLevelData;
        return carVehicleStateComponent.storedOilLevelData;
    }

    static /* synthetic */ DynamicVehicleInfoSCR access$1100(CarVehicleStateComponent carVehicleStateComponent) {
        return carVehicleStateComponent.storedDynamicVehicleInfoScr;
    }

    static /* synthetic */ DynamicVehicleInfoSCR access$1102(CarVehicleStateComponent carVehicleStateComponent, DynamicVehicleInfoSCR dynamicVehicleInfoSCR) {
        carVehicleStateComponent.storedDynamicVehicleInfoScr = dynamicVehicleInfoSCR;
        return carVehicleStateComponent.storedDynamicVehicleInfoScr;
    }

    static {
        CODING = new byte[]{18, 32, 19, 53};
        attributes = new int[]{2, 1, 6, 5, 4, 3, 18, 14, 12, 11};
    }
}

