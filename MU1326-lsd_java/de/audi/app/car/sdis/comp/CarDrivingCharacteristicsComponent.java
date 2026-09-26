/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractDSICarDrivingCharacteristics;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.base.IVisibility;
import de.audi.app.car.sdis.comp.CarDrivingCharacteristicsComponent$CarStateHandler;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingAbstractBaseService;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public class CarDrivingCharacteristicsComponent
extends AbstractDSICarDrivingCharacteristics
implements IDSIObserver {
    private static final String LOG_CHANNEL_NAME;
    public static final byte[] CODING;
    private static final int[] attributes;
    private static final float INVALID_TAD_ANGLE_VALUE;
    private static final float DEFAULT_TAD_ANGLE_VALUE;
    private final LogChannel logger;
    private DSICarDrivingCharacteristics dsi;
    private ISDISFramework baseService;
    private CarDrivingCharacteristicsComponent$CarStateHandler carStateHandler;
    private ASIHMISyncCarDrivingAbstractBaseService toSDIS;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;

    public CarDrivingCharacteristicsComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel("App.CarSDIS.CarDrivingCharacteristics"));
        this.logger = iSDISFramework.getLogChannel("App.CarSDIS.CarDrivingCharacteristics");
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getDrivingASI();
        this.carStateHandler = new CarDrivingCharacteristicsComponent$CarStateHandler(this, this.logger);
    }

    public void init() {
        this.notCodedInfo();
        this.carStateHandler.registerCarStates(CODING);
        this.baseService.registerDSI((class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = CarDrivingCharacteristicsComponent.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics).getName(), (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = CarDrivingCharacteristicsComponent.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener).getName(), this);
    }

    public void deinit() {
        this.baseService.deRegisterDSI((class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = CarDrivingCharacteristicsComponent.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics).getName());
        this.carStateHandler.deregisterCarStates();
    }

    public void notCodedInfo() {
        int n = 0;
        do {
            if (this.carStateHandler.isActivated(CODING[n])) continue;
            switch (CODING[n]) {
                case 40: {
                    this.sendUpdateTADVisibilityState(0);
                    break;
                }
                case 21: {
                    this.sendUpdateSuspensionVisibilityState(new int[]{0, 0});
                    break;
                }
                case 17: {
                    this.sendUpdateCharismaVisibilityState(0);
                    break;
                }
                default: {
                    this.logger.log(-2137614336, "[notCodedInfo]: %1 not supported.", (long)CODING[n]);
                }
            }
        } while (++n < CODING.length);
    }

    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo) {
        de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo tADVehicleInfo2 = new de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo();
        tADVehicleInfo2.setRoofLoad(tADVehicleInfo.isRoofLoad());
        tADVehicleInfo2.setTrailer(tADVehicleInfo.isTrailer());
        try {
            this.toSDIS.updateTADVehicleInfo(tADVehicleInfo2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADVehicleInfo] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADCurrentRollAngle]: %1", (double)f2);
        float f3 = f2;
        if (f3 == 16711494) {
            f3 = 0.0f;
        }
        try {
            this.toSDIS.updateTADCurrentRollAngle(f3);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADCurrentRollAngle] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADPosMaxRollAngle]: %1", (double)f2);
        try {
            this.toSDIS.updateTADPosMaxRollAngle(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADPosMaxRollAngle] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADPosMaxRollAngle]: %1", (double)f2);
        try {
            this.toSDIS.updateTADNegMaxRollAngle(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADNegMaxRollAngle] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADCurrentPitchAngle]: %1", (double)f2);
        float f3 = f2;
        if (f3 == 16711494) {
            f3 = 0.0f;
        }
        try {
            this.toSDIS.updateTADCurrentPitchAngle(f3);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADCurrentPitchAngle] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADPosMaxPitchAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADPosMaxPitch]: %1", (double)f2);
        try {
            this.toSDIS.updateTADPosMaxPitch(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADPosMaxPitch] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADNegMaxPitchAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADNegMaxPitch]: %1", (double)f2);
        try {
            this.toSDIS.updateTADNegMaxPitch(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADNegMaxPitch] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateTADViewOptions]: %1", (Object)tADViewOptions);
        this.sendUpdateTADVConfiguration(tADViewOptions.getConfiguration());
        int n2 = CarDrivingCharacteristicsComponent$CarStateHandler.access$002(this.carStateHandler, this.baseService.updateVisibility(tADViewOptions.getAngleDisplay(), (short)40));
        this.sendUpdateTADVisibilityState(n2);
    }

    private void sendUpdateTADVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateTADVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
            this.toSDIS.updateTADVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADVisibilityState] %1", (Throwable)methodException);
        }
    }

    private void sendUpdateTADVConfiguration(org.dsi.ifc.cardrivingcharacteristics.TADConfiguration tADConfiguration) {
        if (tADConfiguration != null) {
            TADConfiguration tADConfiguration2 = new TADConfiguration();
            tADConfiguration2.setRollAngleStartSoftWarning(tADConfiguration.getRollAngleStartSoftWarning());
            tADConfiguration2.setRollAngleStartHardWarning(tADConfiguration.getRollAngleStartHardWarning());
            tADConfiguration2.setRollAngleMaxScale(tADConfiguration.getRollAngleMaxScale());
            tADConfiguration2.setPitchAngleStartSoftWarning(tADConfiguration.getPitchAngleStartSoftWarning());
            tADConfiguration2.setPitchAngleStartHardWarning(tADConfiguration.getPitchAngleStartHardWarning());
            tADConfiguration2.setPitchAngleMaxScale(tADConfiguration.getPitchAngleMaxScale());
            tADConfiguration2.setRollAngleInstallation(tADConfiguration.isRollAngleInstallation());
            tADConfiguration2.setPitchAngleInstallation(tADConfiguration.isPitchAngleInstallation());
            try {
                this.logger.log(-2137614336, "Send update to devices -> sendUpdateTADVConfiguration: %1", (Object)tADConfiguration);
                this.toSDIS.updateTADConfiguration(tADConfiguration2);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[sendUpdateTADVConfiguration] %1", (Throwable)methodException);
            }
        }
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateSuspensionControlCurrentLevel]: %1", (long)n);
        try {
            this.toSDIS.updateSuspensionControlCurrentLevel(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionControlCurrentLevel] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateSuspensionControlTargetLevel]: %1", (long)n);
        try {
            this.toSDIS.updateSuspensionControlTargetLevel(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionControlTargetLevel] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        int n2;
        if (n != 1) {
            return;
        }
        boolean bl = this.baseService.getCarAdaption().isMenuDisplayActivated((short)21);
        if (!bl) {
            this.logger.log(-2137614336, "[updateSuspensionControlViewOptions]: Airsuspension is not coded: %1", (long)this.baseService.getCarAdaption().getByteCoding((short)40));
            return;
        }
        this.logger.log(-2137614336, "[updateSuspensionControlViewOptions]: %1", (Object)suspensionControlViewOptions);
        boolean bl2 = this.isAirSuspensionLvlIconVisible(suspensionControlViewOptions);
        if (bl2) {
            n2 = 2;
            CarDrivingCharacteristicsComponent$CarStateHandler.access$102(this.carStateHandler, 2);
        } else {
            n2 = 1;
            CarDrivingCharacteristicsComponent$CarStateHandler.access$102(this.carStateHandler, 1);
        }
        this.sendUpdateSuspensionVisibilityState(new int[]{n2, n2});
    }

    private boolean isAirSuspensionLvlIconVisible(SuspensionControlViewOptions suspensionControlViewOptions) {
        if (suspensionControlViewOptions.getConfiguration() != null && suspensionControlViewOptions.getConfiguration().getAdditionalFunctionsAvailability() != null) {
            SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions = suspensionControlViewOptions.getConfiguration().getAdditionalFunctionsAvailability();
            return suspensionControlAdditionalFunctions.isActualNiveau();
        }
        return false;
    }

    private void sendUpdateSuspensionVisibilityState(int[] nArray) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> updateSuspensionVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[nArray[0]]);
            this.toSDIS.updateSuspensionVisibilityState(nArray);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(-2137614336, "[updateCharismaViewOptions]: activeProfile: %1", (Object)charismaViewOptions.getActiveProfile());
        int n2 = CarDrivingCharacteristicsComponent$CarStateHandler.access$202(this.carStateHandler, this.baseService.updateVisibility(charismaViewOptions.getActiveProfile(), (short)17));
        this.sendUpdateCharismaVisibilityState(n2);
    }

    private void sendUpdateCharismaVisibilityState(int n) {
        try {
            this.logger.log(-2137614336, "Send update to devices -> sendUpdateCharismaVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
            this.toSDIS.updateDriveSelectActiveProfileVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[sendUpdateCharismaVisibilityState] %1", (Throwable)methodException);
        }
    }

    @Override
    public void updateCharismaActiveProfile(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        try {
            this.logger.log(-2137614336, "[updateCharismaActiveProfile]: %1", (long)n);
            this.toSDIS.updateDriveSelectActiveProfile(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionControlTargetLevel] %1", (Throwable)methodException);
        }
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        this.dsi = (DSICarDrivingCharacteristics)dSIBase;
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

    static /* synthetic */ ISDISFramework access$300(CarDrivingCharacteristicsComponent carDrivingCharacteristicsComponent) {
        return carDrivingCharacteristicsComponent.baseService;
    }

    static /* synthetic */ void access$400(CarDrivingCharacteristicsComponent carDrivingCharacteristicsComponent, int n) {
        carDrivingCharacteristicsComponent.sendUpdateTADVisibilityState(n);
    }

    static /* synthetic */ void access$500(CarDrivingCharacteristicsComponent carDrivingCharacteristicsComponent, int[] nArray) {
        carDrivingCharacteristicsComponent.sendUpdateSuspensionVisibilityState(nArray);
    }

    static /* synthetic */ void access$600(CarDrivingCharacteristicsComponent carDrivingCharacteristicsComponent, int n) {
        carDrivingCharacteristicsComponent.sendUpdateCharismaVisibilityState(n);
    }

    static {
        CODING = new byte[]{40, 21, 17};
        attributes = new int[]{23, 22, 27, 25, 26, 24, 21, 19, 1, 30, 29, 13, 12};
    }
}

