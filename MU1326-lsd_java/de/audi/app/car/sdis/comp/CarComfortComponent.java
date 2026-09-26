/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractDSICarComfort;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.comp.CarComfortComponent$CarStateHandler;
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
    private static final String LOG_CHANNEL_NAME;
    public static final byte[] CODING;
    private final LogChannel logger;
    private DSICarComfort dsi;
    private ISDISFramework baseService;
    private CarComfortComponent$CarStateHandler carStates;
    private ASIHMISyncCarServiceAbstractBaseService toSDIS;
    private RDKTireDisplayData displayData;
    private static final int[] attributes;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;

    public CarComfortComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel("App.CarSDIS.CarComfort"));
        this.logger = iSDISFramework.getLogChannel("App.CarSDIS.CarComfort");
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getServiceASI();
        this.carStates = new CarComfortComponent$CarStateHandler(this, this.logger);
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

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsi = (DSICarComfort)dSIBase;
        this.dsi.setNotification(attributes, (DSIListener)this);
    }

    @Override
    public synchronized void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "updateRDKViewOptions: %1", (Object)rDKViewOptions);
        int n2 = CarComfortComponent$CarStateHandler.access$002(this.carStates, this.baseService.updateVisibility(rDKViewOptions.getActualPressure(), (short)11));
        int n3 = this.carStates.updateMenuEntryVisibility((short)11, n2);
        this.sendUpdateTireDisplayDataVisibilityState(n3);
    }

    private void sendUpdateTireDisplayDataVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateTireDisplayDataVisibilityState %1", (long)n);
            this.toSDIS.updateTireDisplayDataVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTireDisplayDataVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "updateRDKTireDisplay: %1", (Object)rDKTireDisplayData);
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
            this.logger.log(-2137614336, "Send update to devices -> updateTireDisplayData: %1", (Object)tireDisplayData);
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

    static /* synthetic */ ISDISFramework access$100(CarComfortComponent carComfortComponent) {
        return carComfortComponent.baseService;
    }

    static /* synthetic */ void access$200(CarComfortComponent carComfortComponent, int n) {
        carComfortComponent.sendUpdateTireDisplayDataVisibilityState(n);
    }

    static {
        CODING = new byte[]{11};
        attributes = new int[]{33, 37};
    }
}

