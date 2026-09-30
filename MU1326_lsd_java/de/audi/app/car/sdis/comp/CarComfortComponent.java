/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.base.AbstractDSICarComfort;
import de.audi.app.car.sdis.base.ICoding;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelPressures;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelStates;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelTemperatures;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKViewOptions;

public class CarComfortComponent
extends AbstractDSICarComfort
implements IDSIObserver {
    private static final String LOG_CHANNEL_NAME = "App.CarSDIS.CarComfort";
    public static final byte[] CODING = new byte[]{11};
    private final LogChannel logger;
    private DSICarComfort dsi;
    private ISDISFramework baseService;
    private CarStateHandler carStates;
    private ASIHMISyncCarServiceAbstractBaseService toSDIS;
    private RDKTireDisplayData displayData;
    private static final int[] attributes = new int[]{33, 37};
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;

    public CarComfortComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel(LOG_CHANNEL_NAME));
        this.logger = iSDISFramework.getLogChannel(LOG_CHANNEL_NAME);
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getServiceASI();
        this.carStates = new CarStateHandler(this.logger);
    }

    public void init() {
        this.notCodedInfo();
        this.carStates.registerCarStates(CODING);
        this.baseService.registerDSI((class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = CarComfortComponent.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName(), (class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = CarComfortComponent.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener).getName(), this);
    }

    public void deinit() {
        this.baseService.deRegisterDSI((class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = CarComfortComponent.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort).getName());
        this.carStates.deregisterCarStates();
    }

    public void notCodedInfo() {
        if (!this.carStates.isActivated(CODING[0])) {
            this.sendUpdateTireDisplayDataVisibilityState(0);
        }
    }

    public void setDSI(DSIBase dSIBase) {
        this.dsi = (DSICarComfort)dSIBase;
        this.dsi.setNotification(attributes, (DSIListener)this);
    }

    public synchronized void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "updateRDKViewOptions: %1", (Object)rDKViewOptions);
        int n2 = this.carStates.rdkVisibility = this.baseService.updateVisibility(rDKViewOptions.getActualPressure(), (short)11);
        int n3 = this.carStates.updateMenuEntryVisibility((short)11, n2);
        this.sendUpdateTireDisplayDataVisibilityState(n3);
    }

    private void sendUpdateTireDisplayDataVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> updateTireDisplayDataVisibilityState %1", (long)n);
            this.toSDIS.updateTireDisplayDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTireDisplayDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "updateRDKTireDisplay: %1", (Object)rDKTireDisplayData);
        this.displayData = rDKTireDisplayData;
        WheelPressures wheelPressures = new WheelPressures();
        this.setPressureValues(wheelPressures);
        WheelPressures wheelPressures2 = new WheelPressures();
        this.setPressureValues(wheelPressures2);
        WheelStates wheelStates = new WheelStates();
        wheelStates.frontLeft = this.displayData.getWheelStates().getFrontLeft();
        wheelStates.frontRight = this.displayData.getWheelStates().getFrontRight();
        wheelStates.rearLeft = this.displayData.getWheelStates().getRearLeft();
        wheelStates.rearRight = this.displayData.getWheelStates().getRearRight();
        wheelStates.collectedState = this.displayData.getWheelStates().getCollectedState();
        WheelTemperatures wheelTemperatures = new WheelTemperatures();
        this.setTemperatureValues(wheelTemperatures);
        TireDisplayData tireDisplayData = new TireDisplayData();
        tireDisplayData.wheelPressures = wheelPressures;
        tireDisplayData.wheelStates = wheelStates;
        tireDisplayData.requiredWheelPressures = wheelPressures2;
        tireDisplayData.wheelTemperatures = wheelTemperatures;
        try {
            this.logger.log(10000000, "Send update to devices -> updateTireDisplayData: %1", (Object)tireDisplayData);
            this.toSDIS.updateTireDisplayData(tireDisplayData);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateRDKTireDisplay] %1", (Throwable)methodException);
        }
    }

    private void setTemperatureValues(WheelTemperatures wheelTemperatures) {
        wheelTemperatures.frontLeft = this.displayData.getWheelTemperatures().getFrontLeft();
        wheelTemperatures.frontRight = this.displayData.getWheelTemperatures().getFrontRight();
        wheelTemperatures.rearLeft = this.displayData.getWheelTemperatures().getRearLeft();
        wheelTemperatures.rearRight = this.displayData.getWheelTemperatures().getRearRight();
        wheelTemperatures.temperatureUnit = this.displayData.getWheelTemperatures().getTemperatureUnit();
    }

    private void setPressureValues(WheelPressures wheelPressures) {
        wheelPressures.frontLeft = this.displayData.getWheelPressures().getFrontLeft();
        wheelPressures.frontRight = this.displayData.getWheelPressures().getFrontRight();
        wheelPressures.rearLeft = this.displayData.getWheelPressures().getRearLeft();
        wheelPressures.rearRight = this.displayData.getWheelPressures().getRearRight();
        wheelPressures.pressureUnit = this.displayData.getWheelPressures().getPressureUnit();
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
        private volatile int rdkVisibility;

        public CarStateHandler(LogChannel logChannel) {
            super(logChannel, CarComfortComponent.this.baseService);
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            super.updateClampState(bl, bl2, bl3, bl4);
            this.logger.log(1000000, "[updateClampState] clamp15=%1", bl2);
            this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
        }

        public void exceedsUpperThreshold(int n) {
            super.exceedsUpperThreshold(n);
            this.logger.log(1000000, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
            this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
        }

        public void belowLowerThreshold(int n) {
            super.belowLowerThreshold(n);
            this.logger.log(1000000, "[belowLowerThreshold] =%1", this.isUnderVThr);
            this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
        }

        public void updateStandStill(boolean bl) {
            super.updateStandStill(bl);
            this.logger.log(1000000, "[updateStandStill] =%1", bl);
            this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
        }

        private void updateVisibilityAfterCarStateChange(short s, int n) {
            int n2 = this.updateMenuEntryVisibility(s, n);
            this.logger.log(10000000, "updateVisibilityAfterCarStateChange: %1 %2 rdkVisiblity:%3", (Object)ICoding.CODING_INDEX_TEXT[s], (long)n2, (long)this.rdkVisibility);
            switch (s) {
                case 11: {
                    CarComfortComponent.this.sendUpdateTireDisplayDataVisibilityState(n2);
                    break;
                }
                default: {
                    this.logger.log(100000, "Coding %1 not supported", (long)s);
                }
            }
        }
    }
}

