/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.base.DSIListener;
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

public interface DSICarParkingSystemListener
extends DSIListener {
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions var1, int var2);

    public void updatePDCDefaultParkingMode(int var1, int var2);

    public void updatePDCFrequenceFront(int var1, int var2);

    public void updatePDCFrequenceRear(int var1, int var2);

    public void updatePDCFrequenceRight(int var1, int var2);

    public void updatePDCFrequenceLeft(int var1, int var2);

    public void updatePDCVolumeFront(int var1, int var2);

    public void updatePDCVolumeRear(int var1, int var2);

    public void updatePDCVolumeRight(int var1, int var2);

    public void updatePDCVolumeLeft(int var1, int var2);

    public void updatePDCMute(boolean var1, int var2);

    public void updatePDCSystemOnOff(boolean var1, int var2);

    public void updatePDCTrailerHitched(boolean var1, int var2);

    public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear var1, int var2);

    public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear var1, int var2);

    public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft var1, int var2);

    public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft var1, int var2);

    public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear var1, int var2);

    public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear var1, int var2);

    public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft var1, int var2);

    public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft var1, int var2);

    public void updatePDCOPSAutoActivation(boolean var1, int var2);

    public void updatePDCCrashWarning(PDCCrashWarning var1, int var2);

    public void updatePDCSteeringInformation(PDCSteeringInformation var1, int var2);

    public void updatePDCFlankGuard(boolean var1, int var2);

    public void updatePDCSoundReproduction(PDCSoundReproduction var1, int var2);

    public void updatePDCInfo(PDCInfo var1, int var2);

    public void updatePDCFailure(boolean var1, int var2);

    public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt var1, int var2);

    public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt var1, int var2);

    public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt var1, int var2);

    public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt var1, int var2);

    public void updatePDCWallDetection(PDCWallDetection var1, int var2);

    public void updatePDCPLAMessage(int var1, int var2);

    public void updatePDCSoundFront(PDCSound var1, int var2);

    public void updatePDCSoundRear(PDCSound var1, int var2);

    public void updatePDCSoundLeft(PDCSound var1, int var2);

    public void updatePDCSoundRight(PDCSound var1, int var2);

    public void updatePDCPLAStatus(PDCPLAStatus var1, int var2);

    public void updatePDCPLABargraph(PDCPLABargraph var1, int var2);

    public void updatePDCPLAParkmodeSelection(int var1, int var2);

    public void updatePDCPLASystemState(PDCPLASystemState var1, int var2);

    public void updatePDCOPSVisualisationPosition(int var1, int var2);

    public void updatePDCOffroadMode(boolean var1, int var2);

    public void updatePDCParkboxVisualisation(boolean var1, int var2);

    public void updateVPSFollowUpTime(int var1, int var2);

    public void updateVPSVideoInfo(VPSVideoInfo var1, int var2);

    public void updateVPSColor(int var1, int var2);

    public void updateVPSContrast(int var1, int var2);

    public void updateVPSBrightness(int var1, int var2);

    public void updateVPSDefaultModeRV(VPSDefaultMode var1, int var2);

    public void updateVPSDefaultModeSV(VPSDefaultMode var1, int var2);

    public void updateVPSDefaultModeFV(VPSDefaultMode var1, int var2);

    public void updateVPSDefaultModeBV(VPSDefaultMode var1, int var2);

    public void updateVPSDefaultView(int var1, int var2);

    public void updateVPSDynamicParkingMode(VPSDynParkingMode var1, int var2);

    public void updateVPSOPSOverlay(VPSOPSOverlay var1, int var2);

    public void updateVPSSystemOnOff(boolean var1, int var2);

    public void updateVPSFailure(boolean var1, int var2);

    public void updateVPSExtCamConfig(int var1, int var2);

    public void updateVPSExtCamManActivation(boolean var1, int var2);

    public void updateVPS3DBirdview(int var1, int var2, int var3);

    public void updateVPSSystemState(boolean var1, int var2);

    public void updateVPSCameraStates(VPSCameraStates var1, int var2);

    public void updateParkingPopupContent(DisplayContent var1, int var2);

    public void requestParkingPopup(DisplayContent var1);

    public void acknowledgeParkingPopup(DisplayContent var1);

    public void responseLifeMonitoring(boolean var1);

    public void acknowledgePdcSetFactoryDefault(boolean var1);

    public void acknowledgeVpsSetFactoryDefault(boolean var1);

    public void updateARAFailure(boolean var1, int var2);

    public void updateARAInfo(ARAInfo var1, int var2);

    public void updateARACurrentTrailerAngle(ARACurrentTrailerAngle var1, int var2);

    public void updateARATargetTrailerAngle(int var1, int var2);

    public void updatePDCManeuverAssistConfig(int var1, int var2);

    public void updatePDCManeuverAssist(boolean var1, int var2);

    public void updatePDCManeuverAssistState(PDCManeuverAssistState var1, int var2);

    public void updatePDCManeuverAssistMessage(int var1, int var2);

    public void updatePDCIPAMessage(int var1, int var2);

    public void updatePDCContinueDrivingAssist(int var1, int var2);

    public void updatePDCIpaConfig(int var1, int var2);

    public void updatePDCPiloPaSystemState(PDCPiloPaSystemState var1, int var2);

    public void updateVPSCameraCleaning(VPSCameraCleaning var1, int var2);

    public void updateVPSRimProtection(VPSRimProtection var1, int var2);

    public void updateWCViewOptions(WCViewOptions var1, int var2);

    public void updateWCSystemOnOff(boolean var1, int var2);

    public void updateWCAutoActivation(boolean var1, int var2);

    public void updateWCPopupContent(int var1, int var2);

    public void updateWCMessage(int var1, int var2);

    public void updateWCPanelPosition(WCPanelInfo var1, int var2);

    public void acknowledgeWCSetFactoryDefault(boolean var1);

    public void requestWCPopup(int var1);

    public void acknowledgeWCPopup(int var1);

    public void updateWCPanelListUpdateInfo(CarArrayListUpdateInfo var1, int[] var2, int var3);

    public void updateWCPanelListTotalNumberOfElements(int var1, int var2);

    public void updateWCVehiclePanelInfo(WCVehiclePanelInfo var1, int var2);

    public void updateWCPinPukState(WCPinPukState var1, int var2);

    public void updateWCScanningProgress(int var1, int var2);

    public void updateWCSoftwareUpdateProgress(int var1, int var2);

    public void acknowledgeWCEnterPinPuk(int var1);

    public void acknowledgeWCScanning(int var1);

    public void acknowledgeWCPairing(int var1);

    public void acknowledgeWCSoftwareUpdate(int var1);

    public void acknowledgeWCChangePin(int var1);

    public void acknowledgeWCChangePanelName(int var1);

    public void responseWCPanelList(CarArrayListUpdateInfo var1, WCPanelListRecord[] var2);
}

