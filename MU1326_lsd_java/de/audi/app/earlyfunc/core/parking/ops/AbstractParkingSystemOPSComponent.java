/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemComponent;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.ops.IOPSDistanceControl;
import de.audi.app.earlyfunc.core.parking.ops.OPSTrackHoseControl;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.storage.IStorageAccess;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCConfiguration;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public abstract class AbstractParkingSystemOPSComponent
extends AbstractParkingSystemComponent
implements ChoiceListener {
    protected PDCConfiguration pdcConfiguration = new PDCConfiguration();
    protected IOPSDistanceControl distanceControl = this.initDistanceControl();
    protected OPSTrackHoseControl trackHoseControl = new OPSTrackHoseControl(this.getBaseListModel(2100308), this.getChoiceModel(42).getValue(), this.getLogChannel());
    public static final int OPSTYPE_NOTAVAILABLE = 0;
    public static final int OPSTYPE_NORMAL = 1;
    public static final int OPSTYPE_360 = 2;
    private int opsType = 0;

    public AbstractParkingSystemOPSComponent(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController, "App.EarlyFunc.Parking.OPS");
    }

    public OPSTrackHoseControl getTrackHoseControl() {
        return this.trackHoseControl;
    }

    public String getName() {
        return "Parking System OPS";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{40, 32, 41, 9, 10, 11, 33, 34, 51, 52, 35, 36, 37, 38, 49, 50, 7})};
    }

    public void init() {
        this.distanceControl.init();
        super.init();
    }

    protected void initModels() {
        this.getChoiceModel(2100314).setChoiceListener(this);
        this.getChoiceModel(2100533).setChoiceListener(this);
        this.loadFromPersistence();
    }

    protected void loadFromPersistence() {
        IStorageAccess iStorageAccess = this.getApplication().getFrameworkAccess().getStorageMgr();
        int n = iStorageAccess.getInt(1006, 50, 1);
        this.controller.notifyViewModeSettingChanged(this, this.getParkingSystemID(), n, n, true);
        this.trackHoseControl.initializeTrackHoseList();
    }

    protected void deinitModels() {
        this.getChoiceModel(2100314).resetListener();
        this.getChoiceModel(2100533).resetListener();
    }

    public void setActive(boolean bl, DisplayContent displayContent) {
        this.getLogChannel().log(10000000, "[AbstractParkingSystemOPSComponent#setActive] active=%1, displayContent=%2", bl, (Object)displayContent);
        if (bl) {
            this.controller.notifyParkingSystemActive(this, true);
            ParkingPopupIdentifier parkingPopupIdentifier = this.getHMIPopupID(displayContent.popup);
            if (parkingPopupIdentifier != null) {
                this.controller.addPopupRequest(this.getHMIPopupID(displayContent.popup), this);
            }
        } else {
            ParkingPopupIdentifier parkingPopupIdentifier = this.getHMIPopupID(this.controller.getCurrentDisplayContent().getPopup());
            if (parkingPopupIdentifier != null) {
                this.controller.removePopupRequest(parkingPopupIdentifier, this);
            }
            this.controller.notifyParkingSystemActive(this, false);
        }
    }

    public int[] getSupportedDSIPopupIDs() {
        int[] nArray = this.opsType == 2 ? new int[]{1, 3, 4, 7, 8, 10, 11, 13, 14, 15, 16, 17, 18} : new int[]{1, 3, 4, 10, 13};
        return nArray;
    }

    public int getParkingSystemID() {
        return 2;
    }

    public int getOPSType() {
        return this.opsType;
    }

    public IOPSDistanceControl getDistanceControl() {
        return this.distanceControl;
    }

    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        super.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
        if (n != 1) {
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        if (this.currentViewOptions.getPdcConfiguration() != null) {
            this.pdcConfiguration = this.currentViewOptions.getPdcConfiguration();
            bl = this.pdcConfiguration.getNumberFrontSectors() == 4 && this.pdcConfiguration.getNumberRearSectors() == 4;
            bl2 = bl && this.pdcConfiguration.getNumberLeftSectors() == 4 && this.pdcConfiguration.getNumberRightSectors() == 4;
            this.handleAvailabilityOfTrackHose();
        }
        this.handleAvailability(bl ^ bl2, bl2);
        this.getChoiceModel(2100326).setValue(bl ? 0 : 1);
        this.primaryAttributeFirstSetReceived();
    }

    private void handleAvailabilityOfTrackHose() {
        if (this.pdcConfiguration.isSteeringInformation()) {
            this.trackHoseControl.setWheelbase(this.pdcConfiguration.getWheelbase());
        }
    }

    private void handleAvailability(boolean bl, boolean bl2) {
        this.getLogChannel().log(10000000, "[AbstractParkingSystemOPSComponent#handleAvailability] opsAvailable=%1, ops360Available=%2", bl, bl2);
        if (bl) {
            this.opsType = 1;
            this.controller.registerParkingSystemComponent(this);
            this.distanceControl.activateForOPS();
        } else if (bl2) {
            this.opsType = 2;
            this.controller.registerParkingSystemComponent(this);
            this.distanceControl.activateForOPS360();
        } else {
            this.opsType = 0;
            this.controller.unregisterParkingSystemComponent(this);
        }
    }

    public void updatePDCTrailerHitched(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updatePDCTrailerHitched: pdcTrailerHitched=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.distanceControl.setTrailerHitched(bl);
        }
    }

    public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        this.getLogChannel().log(1000000, "updatePDCDistanceValuesFront: distanceValues=%1, valid=%2", (Object)pDCDistanceValuesFrontRear, (long)n);
        if (n == 1) {
            this.distanceControl.updateDistancesFront(pDCDistanceValuesFrontRear);
        }
    }

    public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        this.getLogChannel().log(1000000, "updatePDCDistanceValuesRear: distanceValues=%1, valid=%2", (Object)pDCDistanceValuesFrontRear, (long)n);
        if (n == 1) {
            this.distanceControl.updateDistancesRear(pDCDistanceValuesFrontRear);
        }
    }

    public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        this.getLogChannel().log(1000000, "updatePDCDistanceValuesRight: distanceValues=%1, valid=%2", (Object)pDCDistanceValuesRightLeft, (long)n);
        if (n == 1) {
            this.distanceControl.updateDistancesRight(pDCDistanceValuesRightLeft);
        }
    }

    public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        this.getLogChannel().log(1000000, "updatePDCDistanceValuesLeft: distanceValues=%1, valid=%2", (Object)pDCDistanceValuesRightLeft, (long)n);
        if (n == 1) {
            this.distanceControl.updateDistancesLeft(pDCDistanceValuesRightLeft);
        }
    }

    public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        this.getLogChannel().log(1000000, "updatePDCStatusLevelFront: statusLevel=%1, valid=%2", (Object)pDCStatusLevelFrontRear, (long)n);
        if (n == 1) {
            this.distanceControl.applyFrontToStatusLvls(pDCStatusLevelFrontRear);
        }
    }

    public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        this.getLogChannel().log(1000000, "updatePDCStatusLevelRear: statusLevel=%1, valid=%2", (Object)pDCStatusLevelFrontRear, (long)n);
        if (n == 1) {
            this.distanceControl.applyRearToStatusLvls(pDCStatusLevelFrontRear);
        }
    }

    public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        this.getLogChannel().log(1000000, "updatePDCStatusLevelRight: statusLevel=%1, valid=%2", (Object)pDCStatusLevelRightLeft, (long)n);
        if (n == 1) {
            this.distanceControl.applyRightToStatusLvls(pDCStatusLevelRightLeft);
        }
    }

    public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        this.getLogChannel().log(1000000, "updatePDCStatusLevelLeft: statusLevel=%1, valid=%2", (Object)pDCStatusLevelRightLeft, (long)n);
        if (n == 1) {
            this.distanceControl.applyLeftToStatusLvls(pDCStatusLevelRightLeft);
        }
    }

    public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemOPSComponent#updatePDCDistanceValuesFrontExt] distanceValues=%1, valid=%2", (Object)pDCDistanceValuesFrontRearExt, (long)n);
        if (n == 1) {
            this.distanceControl.updateDistancesFrontExt(pDCDistanceValuesFrontRearExt);
        }
    }

    public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemOPSComponent#updatePDCDistanceValuesRearExt] distanceValues=%1, valid=%2", (Object)pDCDistanceValuesFrontRearExt, (long)n);
        if (n == 1) {
            this.distanceControl.updateDistancesRearExt(pDCDistanceValuesFrontRearExt);
        }
    }

    public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemOPSComponent#updatePDCStatusLevelFrontExt] statusLevel=%1, valid=%2", (Object)pDCStatusLevelFrontRearExt, (long)n);
        if (n == 1) {
            this.distanceControl.applyFrontExtToStatusLvls(pDCStatusLevelFrontRearExt);
        }
    }

    public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemOPSComponent#updatePDCStatusLevelRearExt] statusLevel=%1, valid=%2", (Object)pDCStatusLevelFrontRearExt, (long)n);
        if (n == 1) {
            this.distanceControl.applyRearExtToStatusLvls(pDCStatusLevelFrontRearExt);
        }
    }

    public void updatePDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation, int n) {
        this.getLogChannel().log(1000000, "updatePDCSteeringInformation: statusLevel=%1, valid=%2", (Object)pDCSteeringInformation, (long)n);
        if (n == 1) {
            this.trackHoseControl.updateSteeringInformation(pDCSteeringInformation);
        }
    }

    public void updatePDCWallDetection(PDCWallDetection pDCWallDetection, int n) {
        this.getLogChannel().log(1000000, "[ParkingSystemOPSComponentPorsche#updatePDCWallDetection] wallDetection=%1, valid=%2", (Object)pDCWallDetection, (long)n);
        if (n == 1 && pDCWallDetection != null) {
            this.distanceControl.updateWallFlags(pDCWallDetection);
        }
    }

    public void updatePDCInfo(PDCInfo pDCInfo, int n) {
        this.getLogChannel().log(1000000, "[ParkingSystemOPSComponentPorsche#updatePDCInfo] information=%1, valid=%2", (Object)pDCInfo, (long)n);
        if (n == 1) {
            this.distanceControl.updatePDCInfo(pDCInfo);
        }
    }

    public void updatePDCMute(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updatePDCMute: pdcMute=%1, valid=%2", bl, (long)n);
        if (1 == n) {
            this.getChoiceModel(2100533).setValue(bl ? 1 : 0);
        }
    }

    public ParkingPopupIdentifier getHMIPopupID(int n) {
        return null;
    }

    public int getHMIPopupPrio(int n) {
        return 0;
    }

    protected abstract IOPSDistanceControl initDistanceControl();

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 2100314: {
                int n5 = this.getChoiceModel(n).getValue();
                this.controller.notifyViewModeSettingChanged(this, this.getParkingSystemID(), n5, n2, true);
                break;
            }
            case 2100533: {
                boolean bl = 1 == n2;
                this.getLogChannel().log(1000000, "AbstractParkingSystemOPSComponent: DSI().setPDCMute(%1)", (Object)(bl ? "true" : "false"));
                this.getDSI().setPDCMute(bl);
                break;
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

