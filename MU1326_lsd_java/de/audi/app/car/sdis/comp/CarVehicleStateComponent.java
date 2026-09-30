/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.base.AbstractDSICarVehicleState;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
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
    private static final String LOG_CHANNEL_NAME = "App.CarSDIS.CarVehicleState";
    public static final byte[] CODING = new byte[]{18, 32, 19, 53};
    private static final int[] attributes = new int[]{2, 1, 6, 5, 4, 3, 18, 14, 12, 11};
    private LogChannel logger;
    private DSICarVehicleStates dsi;
    private ISDISFramework baseService;
    private CarStateHandler carStateHandler;
    private ASIHMISyncCarServiceAbstractBaseService toSDIS;
    private OilLevelData storedOilLevelData;
    private DynamicVehicleInfoSCR storedDynamicVehicleInfoScr;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;

    public CarVehicleStateComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel(LOG_CHANNEL_NAME));
        this.logger = iSDISFramework.getLogChannel(LOG_CHANNEL_NAME);
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getServiceASI();
        this.carStateHandler = new CarStateHandler(this.logger);
    }

    public void init() {
        this.logger.log(10000000, "register DSICarVehicleStates");
        this.notCodedInfo();
        this.carStateHandler.registerCarStates(CODING);
        this.baseService.registerDSI((class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = CarVehicleStateComponent.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).getName(), (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = CarVehicleStateComponent.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener).getName(), this);
    }

    public void deinit() {
        this.logger.log(10000000, "deregister DSICarVehicleStates and services for car states");
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
                    this.logger.log(10000000, "[notCodedInfo]: %1 not supported.", (long)CODING[n]);
                }
            }
        } while (++n < CODING.length);
    }

    public synchronized void updateOilLevelViewOption(CarViewOption carViewOption, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "updateOilLevelViewOption: %1", (Object)carViewOption);
        int n2 = this.carStateHandler.oilVisibility = this.baseService.updateVisibility(carViewOption, (short)18);
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)18, n2);
        this.sendUpdateOilLevelVisibilityState(n3);
    }

    private void sendUpdateOilLevelVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> updateOilLevelDataVisibilityState: %1", (long)n);
            this.toSDIS.updateOilLevelDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateOilLevelDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateOilLevelData(OilLevelData oilLevelData, int n) {
        if (n != 1) {
            return;
        }
        if (this.carStateHandler.isClamp15Sensitive((short)18) && this.carStateHandler.isClamp15Off()) {
            this.storedOilLevelData = oilLevelData;
            return;
        }
        this.logger.log(10000000, "updateOilLevelData: %1", (Object)oilLevelData);
        this.baseService.getDsiAsiHandler().updateValue(4001, oilLevelData);
    }

    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "updateVINViewOption: %1", (Object)carViewOption);
        int n2 = this.baseService.updateVisibility(carViewOption, (short)19);
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)19, n2);
        this.sendUpdateVinDataVisibilityState(n3);
        this.carStateHandler.vinVisibility = n3;
    }

    private void sendUpdateVinDataVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> updateVinDataVisibilityState: %1", (long)n);
            this.toSDIS.updateVinDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateVinDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateVINData(String string, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateVINData]: %1", (Object)string);
        try {
            this.logger.log(10000000, "Send update to devices -> updateVINData: %1", (Object)string);
            this.toSDIS.updateVinData(string);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateVinData] %1", (Throwable)methodException);
        }
    }

    public void updateKeyViewOption(CarViewOption carViewOption, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateKeyViewOption]: %1", (Object)carViewOption);
        int n2 = this.baseService.updateVisibility(carViewOption, (short)32);
        this.carStateHandler.keyVisibility = n2;
        this.sendUpdateKeyDataVisibilityState(n2);
    }

    private void sendUpdateKeyDataVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> updateKeyDataVisibilityState: %1", (long)n);
            this.toSDIS.updateKeyDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateKeyDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateKeyData(KeyData keyData, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateKeyData]: %1", (Object)keyData);
        int[] nArray = new int[]{keyData.getActualValue(), keyData.getActiveKey(), keyData.getTargetValue()};
        try {
            this.logger.log(10000000, "Send update to devices -> updateKeyData: %1", (Object)nArray);
            this.toSDIS.updateKeyData(nArray);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateKeyData] %1", (Throwable)methodException);
        }
    }

    public synchronized void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateVehicleInfoViewOptions.adblue]: %1", (Object)vehicleInfoViewOptions.getScrInfo());
        int n2 = this.carStateHandler.adblueVisibility = this.baseService.updateVisibility(vehicleInfoViewOptions.getScrInfo(), (short)53);
        int n3 = this.carStateHandler.updateMenuEntryVisibility((short)53, n2);
        this.sendUpdateAdblueVisibilityState(n3);
    }

    private void sendUpdateAdblueVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> sendUpdateAdblueVisibilityState: %1", (long)n);
            this.toSDIS.updateAdBlueInfoVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateAdBlueDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        if (n != 1) {
            return;
        }
        if (this.carStateHandler.isClamp15Sensitive((short)53) && this.carStateHandler.isClamp15Off()) {
            this.storedDynamicVehicleInfoScr = dynamicVehicleInfoSCR;
            return;
        }
        this.logger.log(10000000, "[updateDynamicVehicleInfoSCR]: %1", (Object)dynamicVehicleInfoSCR);
        int n2 = Math.round(dynamicVehicleInfoSCR.getRefillLevelMin() * 100.0f);
        int n3 = Math.round(dynamicVehicleInfoSCR.getRefillLevelMax() * 100.0f);
        AdBlueInfo adBlueInfo = new AdBlueInfo(dynamicVehicleInfoSCR.getRange(), dynamicVehicleInfoSCR.getRangeUnit(), dynamicVehicleInfoSCR.getLevel(), (int)dynamicVehicleInfoSCR.getTankVolume(), dynamicVehicleInfoSCR.getStatus(), dynamicVehicleInfoSCR.getVolumeUnit(), n2, n3);
        try {
            this.logger.log(10000000, "Send update to devices -> updateDynamicVehicleInfoSCR: %1", (Object)adBlueInfo);
            this.toSDIS.updateAdBlueInfo(adBlueInfo);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateDynamicVehicleInfoSCR] %1", (Throwable)methodException);
        }
    }

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (n == 1) {
            this.logger.log(10000000, "[updateDynamicVehicleInfoHighFrequentViewOptions.vehicleSpeed]: %1", (Object)dynamicVehicleInfoHighFrequentViewOptions.getVehicleSpeed());
            int n2 = this.baseService.updateVisibility(dynamicVehicleInfoHighFrequentViewOptions.getVehicleSpeed(), (short)128);
            this.sendUpdateSpeedVisibilityState(n2);
        }
    }

    private void sendUpdateSpeedVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> sendUpdateSpeedVisibilityState: %1", (long)n);
            this.toSDIS.updateVehicleSpeedVisibility(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateVehicleSpeedVisibility] %1", (Throwable)methodException);
        }
    }

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (n == 1) {
            this.logger.log(1000000, "updateDynamicVehicleInfoHighFrequent(%1)", (Object)dynamicVehicleInfoHighFrequent.getVehicleSpeed());
            float f2 = dynamicVehicleInfoHighFrequent.getVehicleSpeed().getSpeedValue();
            int n2 = dynamicVehicleInfoHighFrequent.getVehicleSpeed().getSpeedUnit();
            FloatBaseType floatBaseType = new FloatBaseType(f2, n2, -1);
            try {
                this.logger.log(10000000, "Send update to devices -> updateDynamicVehicleInfoSCR: %1", (Object)floatBaseType);
                this.toSDIS.updateVehicleSpeed(floatBaseType);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[updateVehicleSpeed] %1", (Throwable)methodException);
            }
        }
    }

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

    public class CarStateHandler
    extends AbstractCarStateHandler {
        private volatile int vinVisibility;
        private volatile int keyVisibility;
        private volatile int oilVisibility;
        private volatile int adblueVisibility;

        public CarStateHandler(LogChannel logChannel) {
            super(logChannel, CarVehicleStateComponent.this.baseService);
            this.vinVisibility = 0;
            this.keyVisibility = 0;
            this.oilVisibility = 0;
            this.adblueVisibility = 0;
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            boolean bl5 = this.isClamp15On;
            super.updateClampState(bl, bl2, bl3, bl4);
            this.logger.log(1000000, "[updateClampState] clamp15=%1", bl2);
            this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
            this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
            this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
            this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
            if (!bl5 && bl2) {
                this.resendOilValue();
                this.resendScrValue();
            }
        }

        public void exceedsUpperThreshold(int n) {
            super.exceedsUpperThreshold(n);
            this.logger.log(1000000, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
            this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
            this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
            this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
            this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
        }

        public void belowLowerThreshold(int n) {
            super.belowLowerThreshold(n);
            this.logger.log(1000000, "[belowLowerThreshold] =%1", this.isUnderVThr);
            this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
            this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
            this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
            this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
        }

        public void updateStandStill(boolean bl) {
            super.updateStandStill(bl);
            this.logger.log(1000000, "[updateStandStill] =%1", bl);
            this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
            this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
            this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
            this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
        }

        private boolean isClamp15Off() {
            return !this.isClamp15On;
        }

        private void updateVisibilityAfterCarStateChange(short s, int n) {
            int n2 = this.updateMenuEntryVisibility(s, n);
            switch (s) {
                case 19: {
                    CarVehicleStateComponent.this.sendUpdateVinDataVisibilityState(n2);
                    break;
                }
                case 32: {
                    CarVehicleStateComponent.this.sendUpdateKeyDataVisibilityState(n2);
                    break;
                }
                case 18: {
                    CarVehicleStateComponent.this.sendUpdateOilLevelVisibilityState(n2);
                    break;
                }
                case 53: {
                    CarVehicleStateComponent.this.sendUpdateAdblueVisibilityState(n2);
                    break;
                }
                default: {
                    this.logger.log(100000, "Coding %1 not supported", (long)s);
                }
            }
        }

        private void resendOilValue() {
            if (CarVehicleStateComponent.this.storedOilLevelData != null && this.isClamp15Sensitive((short)18)) {
                CarVehicleStateComponent.this.updateOilLevelData(CarVehicleStateComponent.this.storedOilLevelData, 1);
                CarVehicleStateComponent.this.storedOilLevelData = null;
            }
        }

        private void resendScrValue() {
            if (CarVehicleStateComponent.this.storedDynamicVehicleInfoScr != null && this.isClamp15Sensitive((short)53)) {
                CarVehicleStateComponent.this.updateDynamicVehicleInfoSCR(CarVehicleStateComponent.this.storedDynamicVehicleInfoScr, 1);
                CarVehicleStateComponent.this.storedDynamicVehicleInfoScr = null;
            }
        }
    }
}

