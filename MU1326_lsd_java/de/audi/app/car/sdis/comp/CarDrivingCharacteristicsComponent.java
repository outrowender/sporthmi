/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.base.AbstractDSICarDrivingCharacteristics;
import de.audi.app.car.sdis.base.IDSIObserver;
import de.audi.app.car.sdis.base.ISDISFramework;
import de.audi.app.car.sdis.base.IVisibility;
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
    private static final String LOG_CHANNEL_NAME = "App.CarSDIS.CarDrivingCharacteristics";
    public static final byte[] CODING = new byte[]{40, 21, 17};
    private static final int[] attributes = new int[]{23, 22, 27, 25, 26, 24, 21, 19, 1, 30, 29, 13, 12};
    private static final float INVALID_TAD_ANGLE_VALUE = 32767.0f;
    private static final float DEFAULT_TAD_ANGLE_VALUE = 0.0f;
    private final LogChannel logger;
    private DSICarDrivingCharacteristics dsi;
    private ISDISFramework baseService;
    private CarStateHandler carStateHandler;
    private ASIHMISyncCarDrivingAbstractBaseService toSDIS;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;

    public CarDrivingCharacteristicsComponent(ISDISFramework iSDISFramework) {
        super(iSDISFramework.getLogChannel(LOG_CHANNEL_NAME));
        this.logger = iSDISFramework.getLogChannel(LOG_CHANNEL_NAME);
        this.baseService = iSDISFramework;
        this.toSDIS = this.baseService.getASIDataUpdater().getDrivingASI();
        this.carStateHandler = new CarStateHandler(this.logger);
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
                    this.logger.log(10000000, "[notCodedInfo]: %1 not supported.", (long)CODING[n]);
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

    public void updateTADCurrentRollAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADCurrentRollAngle]: %1", (double)f2);
        float f3 = f2;
        if (f3 == 32767.0f) {
            f3 = 0.0f;
        }
        try {
            this.toSDIS.updateTADCurrentRollAngle(f3);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADCurrentRollAngle] %1", (Throwable)methodException);
        }
    }

    public void updateTADPosMaxRollAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADPosMaxRollAngle]: %1", (double)f2);
        try {
            this.toSDIS.updateTADPosMaxRollAngle(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADPosMaxRollAngle] %1", (Throwable)methodException);
        }
    }

    public void updateTADNegMaxRollAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADPosMaxRollAngle]: %1", (double)f2);
        try {
            this.toSDIS.updateTADNegMaxRollAngle(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADNegMaxRollAngle] %1", (Throwable)methodException);
        }
    }

    public void updateTADCurrentPitchAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADCurrentPitchAngle]: %1", (double)f2);
        float f3 = f2;
        if (f3 == 32767.0f) {
            f3 = 0.0f;
        }
        try {
            this.toSDIS.updateTADCurrentPitchAngle(f3);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADCurrentPitchAngle] %1", (Throwable)methodException);
        }
    }

    public void updateTADPosMaxPitchAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADPosMaxPitch]: %1", (double)f2);
        try {
            this.toSDIS.updateTADPosMaxPitch(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADPosMaxPitch] %1", (Throwable)methodException);
        }
    }

    public void updateTADNegMaxPitchAngle(float f2, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADNegMaxPitch]: %1", (double)f2);
        try {
            this.toSDIS.updateTADNegMaxPitch(f2);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateTADNegMaxPitch] %1", (Throwable)methodException);
        }
    }

    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateTADViewOptions]: %1", (Object)tADViewOptions);
        this.sendUpdateTADVConfiguration(tADViewOptions.getConfiguration());
        int n2 = this.carStateHandler.tadVisibility = this.baseService.updateVisibility(tADViewOptions.getAngleDisplay(), (short)40);
        this.sendUpdateTADVisibilityState(n2);
    }

    private void sendUpdateTADVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> updateTADVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
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
                this.logger.log(10000000, "Send update to devices -> sendUpdateTADVConfiguration: %1", (Object)tADConfiguration);
                this.toSDIS.updateTADConfiguration(tADConfiguration2);
            }
            catch (MethodException methodException) {
                this.logger.log(10000, "[sendUpdateTADVConfiguration] %1", (Throwable)methodException);
            }
        }
    }

    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.logger.log(10000000, "[updateSuspensionControlCurrentLevel]: %1", (long)n);
        try {
            this.toSDIS.updateSuspensionControlCurrentLevel(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionControlCurrentLevel] %1", (Throwable)methodException);
        }
    }

    public void updateSuspensionControlTargetLevel(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.logger.log(10000000, "[updateSuspensionControlTargetLevel]: %1", (long)n);
        try {
            this.toSDIS.updateSuspensionControlTargetLevel(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionControlTargetLevel] %1", (Throwable)methodException);
        }
    }

    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        int n2;
        if (n != 1) {
            return;
        }
        boolean bl = this.baseService.getCarAdaption().isMenuDisplayActivated((short)21);
        if (!bl) {
            this.logger.log(10000000, "[updateSuspensionControlViewOptions]: Airsuspension is not coded: %1", (long)this.baseService.getCarAdaption().getByteCoding((short)40));
            return;
        }
        this.logger.log(10000000, "[updateSuspensionControlViewOptions]: %1", (Object)suspensionControlViewOptions);
        boolean bl2 = this.isAirSuspensionLvlIconVisible(suspensionControlViewOptions);
        if (bl2) {
            n2 = 2;
            this.carStateHandler.suspVisibility = 2;
        } else {
            n2 = 1;
            this.carStateHandler.suspVisibility = 1;
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
            this.logger.log(10000000, "Send update to devices -> updateSuspensionVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[nArray[0]]);
            this.toSDIS.updateSuspensionVisibilityState(nArray);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if (n != 1) {
            return;
        }
        this.logger.log(10000000, "[updateCharismaViewOptions]: activeProfile: %1", (Object)charismaViewOptions.getActiveProfile());
        int n2 = this.carStateHandler.charismaVisibility = this.baseService.updateVisibility(charismaViewOptions.getActiveProfile(), (short)17);
        this.sendUpdateCharismaVisibilityState(n2);
    }

    private void sendUpdateCharismaVisibilityState(int n) {
        try {
            this.logger.log(10000000, "Send update to devices -> sendUpdateCharismaVisibilityState: %1", (Object)IVisibility.TEXT_TO_STATE[n]);
            this.toSDIS.updateDriveSelectActiveProfileVisibilityState(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[sendUpdateCharismaVisibilityState] %1", (Throwable)methodException);
        }
    }

    public void updateCharismaActiveProfile(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        try {
            this.logger.log(10000000, "[updateCharismaActiveProfile]: %1", (long)n);
            this.toSDIS.updateDriveSelectActiveProfile(n);
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[updateSuspensionControlTargetLevel] %1", (Throwable)methodException);
        }
    }

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

    public class CarStateHandler
    extends AbstractCarStateHandler {
        private volatile int tadVisibility;
        private volatile int suspVisibility;
        private volatile int charismaVisibility;

        public CarStateHandler(LogChannel logChannel) {
            super(logChannel, CarDrivingCharacteristicsComponent.this.baseService);
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            super.updateClampState(bl, bl2, bl3, bl4);
            this.logger.log(1000000, "[updateClampState] clamp15=%1", bl2);
            this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
            this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
            this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
        }

        public void exceedsUpperThreshold(int n) {
            super.exceedsUpperThreshold(n);
            this.logger.log(1000000, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
            this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
            this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
            this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
        }

        public void belowLowerThreshold(int n) {
            super.belowLowerThreshold(n);
            this.logger.log(1000000, "[belowLowerThreshold] =%1", this.isUnderVThr);
            this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
            this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
            this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
        }

        public void updateStandStill(boolean bl) {
            super.updateStandStill(bl);
            this.logger.log(1000000, "[updateStandStill] =%1", bl);
            this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
            this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
            this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
        }

        private void updateVisibilityAfterCarStateChange(short s, int n) {
            int n2 = this.updateMenuEntryVisibility(s, n);
            switch (s) {
                case 40: {
                    CarDrivingCharacteristicsComponent.this.sendUpdateTADVisibilityState(n2);
                    break;
                }
                case 21: {
                    CarDrivingCharacteristicsComponent.this.sendUpdateSuspensionVisibilityState(new int[]{n2, n2});
                    break;
                }
                case 17: {
                    CarDrivingCharacteristicsComponent.this.sendUpdateCharismaVisibilityState(n2);
                    break;
                }
                default: {
                    this.logger.log(100000, "Coding %1 not supported", (long)s);
                }
            }
        }
    }
}

