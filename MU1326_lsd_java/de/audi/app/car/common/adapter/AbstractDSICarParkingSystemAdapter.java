/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.adapter;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPinPukState;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;
import org.dsi.ifc.carparkingsystem.WCViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public abstract class AbstractDSICarParkingSystemAdapter
extends AbstractCarComponent
implements DSICarParkingSystemListener {
    protected static final String LOGCHANNEL_NAME;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem;

    public AbstractDSICarParkingSystemAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarParkingSystem getDSI() {
        return (DSICarParkingSystem)this.getBaseDSI();
    }

    @Override
    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = AbstractDSICarParkingSystemAdapter.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener).getName();
    }

    @Override
    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem = AbstractDSICarParkingSystemAdapter.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystem")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem).getName();
    }

    @Override
    public final boolean isUsingDSI() {
        return true;
    }

    protected String getPopupForLogging(DisplayContent displayContent) {
        switch (displayContent.popup) {
            case 0: {
                return "NONE";
            }
            case 1: {
                return "OPS";
            }
            case 2: {
                return "VPS";
            }
            case 3: {
                return "VPSOPS";
            }
            case 4: {
                return "OPSAUTOACTIVATION";
            }
            case 5: {
                return "SETTINGS";
            }
            case 6: {
                return "GENERAL";
            }
            case 7: {
                return "OPSFLANKGUARD";
            }
            case 8: {
                return "VPSOPSFLANKGUARD";
            }
            case 10: {
                return "ARAOPS";
            }
            case 11: {
                return "ARAOPSFLANKGUARD";
            }
            case 12: {
                return "ARAVPS";
            }
            case 13: {
                return "ARAVPSOPS";
            }
            case 14: {
                return "ARAVPSOPSFLANKGUARD";
            }
        }
        return "UNKNOWN/INVALID POPUP";
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
    }

    @Override
    public void updatePDCDefaultParkingMode(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCFrequenceFront(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCFrequenceRear(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCFrequenceRight(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCFrequenceLeft(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCVolumeFront(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCVolumeRear(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCVolumeRight(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCVolumeLeft(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCMute(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCTrailerHitched(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCOPSAutoActivation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCCrashWarning(PDCCrashWarning pDCCrashWarning, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCFlankGuard(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCInfo(PDCInfo pDCInfo, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCFailure(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCWallDetection(PDCWallDetection pDCWallDetection, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCPLAMessage(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCSoundFront(PDCSound pDCSound, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCSoundRear(PDCSound pDCSound, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCSoundLeft(PDCSound pDCSound, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCSoundRight(PDCSound pDCSound, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCPLABargraph(PDCPLABargraph pDCPLABargraph, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCPLAParkmodeSelection(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCPLASystemState(PDCPLASystemState pDCPLASystemState, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCOPSVisualisationPosition(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCOffroadMode(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCParkboxVisualisation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSFollowUpTime(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSVideoInfo(VPSVideoInfo vPSVideoInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSColor(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSContrast(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSBrightness(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSDefaultView(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSFailure(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateParkingPopupContent(DisplayContent displayContent, int n) {
    }

    @Override
    public void requestParkingPopup(DisplayContent displayContent) {
    }

    @Override
    public void acknowledgeParkingPopup(DisplayContent displayContent) {
    }

    @Override
    public void responseLifeMonitoring(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgePdcSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeVpsSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void updateARAFailure(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateARAInfo(ARAInfo aRAInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateARACurrentTrailerAngle(ARACurrentTrailerAngle aRACurrentTrailerAngle, int n) {
        this.logStub();
    }

    @Override
    public void updateARATargetTrailerAngle(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSExtCamConfig(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateVPSExtCamManActivation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateVPS3DBirdview(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateVPSSystemState(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSCameraStates(VPSCameraStates vPSCameraStates, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCManeuverAssistConfig(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCManeuverAssist(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCManeuverAssistState(PDCManeuverAssistState pDCManeuverAssistState, int n) {
        this.logStub();
    }

    @Override
    public void updatePDCManeuverAssistMessage(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCIPAMessage(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCContinueDrivingAssist(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCIpaConfig(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updatePDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning, int n) {
        this.logStub();
    }

    @Override
    public void updateVPSRimProtection(VPSRimProtection vPSRimProtection, int n) {
        this.logStub();
    }

    @Override
    public void updateWCViewOptions(WCViewOptions wCViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateWCSystemOnOff(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateWCAutoActivation(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateWCPopupContent(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateWCMessage(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateWCPanelPosition(WCPanelInfo wCPanelInfo, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void requestWCPopup(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCPopup(int n) {
        this.logStub();
    }

    @Override
    public void updateWCPanelListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        this.logStub();
    }

    @Override
    public void updateWCPanelListTotalNumberOfElements(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateWCVehiclePanelInfo(WCVehiclePanelInfo wCVehiclePanelInfo, int n) {
        this.logStub();
    }

    @Override
    public void updateWCPinPukState(WCPinPukState wCPinPukState, int n) {
        this.logStub();
    }

    @Override
    public void updateWCScanningProgress(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateWCSoftwareUpdateProgress(int n, int n2) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCEnterPinPuk(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCScanning(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCPairing(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCSoftwareUpdate(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCChangePin(int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeWCChangePanelName(int n) {
        this.logStub();
    }

    @Override
    public void responseWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo, WCPanelListRecord[] wCPanelListRecordArray) {
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

