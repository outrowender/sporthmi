/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
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

public interface DSICarParkingSystemReply {
    public static final String IPL_COMM_UUID = "25fd9fa4-e912-5fdd-a328-629d65736e4c";
    public static final String IPL_COMM_INTERFACE_KEY = "d37789a1-552e-5f0f-b925-4e2178c41e40";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.21";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.21";

    public void updateParkingSystemViewOptions(ParkingSystemViewOptions var1, int var2) throws MethodException;

    public void updatePDCDefaultParkingMode(int var1, int var2) throws MethodException;

    public void updatePDCFrequenceFront(int var1, int var2) throws MethodException;

    public void updatePDCFrequenceRear(int var1, int var2) throws MethodException;

    public void updatePDCFrequenceRight(int var1, int var2) throws MethodException;

    public void updatePDCFrequenceLeft(int var1, int var2) throws MethodException;

    public void updatePDCVolumeFront(int var1, int var2) throws MethodException;

    public void updatePDCVolumeRear(int var1, int var2) throws MethodException;

    public void updatePDCVolumeRight(int var1, int var2) throws MethodException;

    public void updatePDCVolumeLeft(int var1, int var2) throws MethodException;

    public void updatePDCMute(boolean var1, int var2) throws MethodException;

    public void updatePDCSystemOnOff(boolean var1, int var2) throws MethodException;

    public void updatePDCTrailerHitched(boolean var1, int var2) throws MethodException;

    public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear var1, int var2) throws MethodException;

    public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear var1, int var2) throws MethodException;

    public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft var1, int var2) throws MethodException;

    public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft var1, int var2) throws MethodException;

    public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear var1, int var2) throws MethodException;

    public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear var1, int var2) throws MethodException;

    public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft var1, int var2) throws MethodException;

    public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft var1, int var2) throws MethodException;

    public void updatePDCOPSAutoActivation(boolean var1, int var2) throws MethodException;

    public void updatePDCCrashWarning(PDCCrashWarning var1, int var2) throws MethodException;

    public void updatePDCSteeringInformation(PDCSteeringInformation var1, int var2) throws MethodException;

    public void updatePDCFlankGuard(boolean var1, int var2) throws MethodException;

    public void updatePDCSoundReproduction(PDCSoundReproduction var1, int var2) throws MethodException;

    public void updatePDCInfo(PDCInfo var1, int var2) throws MethodException;

    public void updatePDCFailure(boolean var1, int var2) throws MethodException;

    public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt var1, int var2) throws MethodException;

    public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt var1, int var2) throws MethodException;

    public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt var1, int var2) throws MethodException;

    public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt var1, int var2) throws MethodException;

    public void updatePDCWallDetection(PDCWallDetection var1, int var2) throws MethodException;

    public void updatePDCPLAMessage(int var1, int var2) throws MethodException;

    public void updatePDCSoundFront(PDCSound var1, int var2) throws MethodException;

    public void updatePDCSoundRear(PDCSound var1, int var2) throws MethodException;

    public void updatePDCSoundLeft(PDCSound var1, int var2) throws MethodException;

    public void updatePDCSoundRight(PDCSound var1, int var2) throws MethodException;

    public void updatePDCPLAStatus(PDCPLAStatus var1, int var2) throws MethodException;

    public void updatePDCPLABargraph(PDCPLABargraph var1, int var2) throws MethodException;

    public void updatePDCPLAParkmodeSelection(int var1, int var2) throws MethodException;

    public void updatePDCPLASystemState(PDCPLASystemState var1, int var2) throws MethodException;

    public void updatePDCOPSVisualisationPosition(int var1, int var2) throws MethodException;

    public void updatePDCOffroadMode(boolean var1, int var2) throws MethodException;

    public void updatePDCParkboxVisualisation(boolean var1, int var2) throws MethodException;

    public void updateVPSFollowUpTime(int var1, int var2) throws MethodException;

    public void updateVPSVideoInfo(VPSVideoInfo var1, int var2) throws MethodException;

    public void updateVPSColor(int var1, int var2) throws MethodException;

    public void updateVPSContrast(int var1, int var2) throws MethodException;

    public void updateVPSBrightness(int var1, int var2) throws MethodException;

    public void updateVPSDefaultModeRV(VPSDefaultMode var1, int var2) throws MethodException;

    public void updateVPSDefaultModeSV(VPSDefaultMode var1, int var2) throws MethodException;

    public void updateVPSDefaultModeFV(VPSDefaultMode var1, int var2) throws MethodException;

    public void updateVPSDefaultModeBV(VPSDefaultMode var1, int var2) throws MethodException;

    public void updateVPSDefaultView(int var1, int var2) throws MethodException;

    public void updateVPSDynamicParkingMode(VPSDynParkingMode var1, int var2) throws MethodException;

    public void updateVPSOPSOverlay(VPSOPSOverlay var1, int var2) throws MethodException;

    public void updateVPSSystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateVPSFailure(boolean var1, int var2) throws MethodException;

    public void updateVPSExtCamConfig(int var1, int var2) throws MethodException;

    public void updateVPSExtCamManActivation(boolean var1, int var2) throws MethodException;

    public void updateVPS3DBirdview(int var1, int var2, int var3) throws MethodException;

    public void updateVPSSystemState(boolean var1, int var2) throws MethodException;

    public void updateVPSCameraStates(VPSCameraStates var1, int var2) throws MethodException;

    public void updateParkingPopupContent(DisplayContent var1, int var2) throws MethodException;

    public void requestParkingPopup(DisplayContent var1) throws MethodException;

    public void acknowledgeParkingPopup(DisplayContent var1) throws MethodException;

    public void responseLifeMonitoring(boolean var1) throws MethodException;

    public void acknowledgePdcSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeVpsSetFactoryDefault(boolean var1) throws MethodException;

    public void updateARAFailure(boolean var1, int var2) throws MethodException;

    public void updateARAInfo(ARAInfo var1, int var2) throws MethodException;

    public void updateARACurrentTrailerAngle(ARACurrentTrailerAngle var1, int var2) throws MethodException;

    public void updateARATargetTrailerAngle(int var1, int var2) throws MethodException;

    public void updatePDCManeuverAssistConfig(int var1, int var2) throws MethodException;

    public void updatePDCManeuverAssist(boolean var1, int var2) throws MethodException;

    public void updatePDCManeuverAssistState(PDCManeuverAssistState var1, int var2) throws MethodException;

    public void updatePDCManeuverAssistMessage(int var1, int var2) throws MethodException;

    public void updatePDCIPAMessage(int var1, int var2) throws MethodException;

    public void updatePDCContinueDrivingAssist(int var1, int var2) throws MethodException;

    public void updatePDCIpaConfig(int var1, int var2) throws MethodException;

    public void updatePDCPiloPaSystemState(PDCPiloPaSystemState var1, int var2) throws MethodException;

    public void updateVPSCameraCleaning(VPSCameraCleaning var1, int var2) throws MethodException;

    public void updateVPSRimProtection(VPSRimProtection var1, int var2) throws MethodException;

    public void updateWCViewOptions(WCViewOptions var1, int var2) throws MethodException;

    public void updateWCSystemOnOff(boolean var1, int var2) throws MethodException;

    public void updateWCAutoActivation(boolean var1, int var2) throws MethodException;

    public void updateWCPopupContent(int var1, int var2) throws MethodException;

    public void updateWCMessage(int var1, int var2) throws MethodException;

    public void updateWCPanelPosition(WCPanelInfo var1, int var2) throws MethodException;

    public void acknowledgeWCSetFactoryDefault(boolean var1) throws MethodException;

    public void requestWCPopup(int var1) throws MethodException;

    public void acknowledgeWCPopup(int var1) throws MethodException;

    public void updateWCPanelListUpdateInfo(CarArrayListUpdateInfo var1, int[] var2, int var3) throws MethodException;

    public void updateWCPanelListTotalNumberOfElements(int var1, int var2) throws MethodException;

    public void updateWCVehiclePanelInfo(WCVehiclePanelInfo var1, int var2) throws MethodException;

    public void updateWCPinPukState(WCPinPukState var1, int var2) throws MethodException;

    public void updateWCScanningProgress(int var1, int var2) throws MethodException;

    public void updateWCSoftwareUpdateProgress(int var1, int var2) throws MethodException;

    public void acknowledgeWCEnterPinPuk(int var1) throws MethodException;

    public void acknowledgeWCScanning(int var1) throws MethodException;

    public void acknowledgeWCPairing(int var1) throws MethodException;

    public void acknowledgeWCSoftwareUpdate(int var1) throws MethodException;

    public void acknowledgeWCChangePin(int var1) throws MethodException;

    public void acknowledgeWCChangePanelName(int var1) throws MethodException;

    public void responseWCPanelList(CarArrayListUpdateInfo var1, WCPanelListRecord[] var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

