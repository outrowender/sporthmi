/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public interface DSICarParkingSystemC {
    public void setHMIStateIsReady(boolean var1) throws MethodException;

    public void setPDCDefaultParkingMode(int var1) throws MethodException;

    public void setPDCMute(boolean var1) throws MethodException;

    public void setPDCFrequenceFront(int var1) throws MethodException;

    public void setPDCFrequenceRear(int var1) throws MethodException;

    public void setPDCVolumeFront(int var1) throws MethodException;

    public void setPDCVolumeRear(int var1) throws MethodException;

    public void setPDCAutoActivation(boolean var1) throws MethodException;

    public void setPDCSystemOnOff(boolean var1) throws MethodException;

    public void setPDCFrequenceRight(int var1) throws MethodException;

    public void setPDCFrequenceLeft(int var1) throws MethodException;

    public void setPDCVolumeRight(int var1) throws MethodException;

    public void setPDCVolumeLeft(int var1) throws MethodException;

    public void setPDCFlankGuard(boolean var1) throws MethodException;

    public void setPDCSoundReproduction(PDCSoundReproduction var1) throws MethodException;

    public void setPDCSoundFront(PDCSound var1) throws MethodException;

    public void setPDCSoundRear(PDCSound var1) throws MethodException;

    public void setPDCSoundLeft(PDCSound var1) throws MethodException;

    public void setPDCSoundRight(PDCSound var1) throws MethodException;

    public void setPDCPLAPreSelection(int var1) throws MethodException;

    public void setPDCPLAParkMode(int var1) throws MethodException;

    public void setPDCPLASystemState(PDCPLASystemState var1) throws MethodException;

    public void setPDCOffroadMode(boolean var1) throws MethodException;

    public void setPDCVisualisationParkbox(boolean var1) throws MethodException;

    public void setPDCOPSVisualisationPosition(int var1) throws MethodException;

    public void setVPSFollowUpTime(int var1) throws MethodException;

    public void setVPSColor(int var1) throws MethodException;

    public void setVPSContrast(int var1) throws MethodException;

    public void setVPSBrightness(int var1) throws MethodException;

    public void setVPSDefaultModeRV(VPSDefaultMode var1) throws MethodException;

    public void setVPSDefaultModeFV(VPSDefaultMode var1) throws MethodException;

    public void setVPSDefaultModeSV(VPSDefaultMode var1) throws MethodException;

    public void setVPSDefaultModeBV(VPSDefaultMode var1) throws MethodException;

    public void setVPSDefaultView(int var1) throws MethodException;

    public void setVPSOPSOverlay(VPSOPSOverlay var1) throws MethodException;

    public void setVPSDynamicParkingMode(VPSDynParkingMode var1) throws MethodException;

    public void setVPSSystemOnOff(boolean var1) throws MethodException;

    public void setVPSExtCamConfig(int var1) throws MethodException;

    public void setVPSExtCamManActivation(boolean var1) throws MethodException;

    public void setVPS3DBirdview(int var1, int var2) throws MethodException;

    public void setVPSSystemState(boolean var1) throws MethodException;

    public void showParkingPopup(DisplayContent var1) throws MethodException;

    public void cancelParkingPopup(DisplayContent var1, int var2) throws MethodException;

    public void requestLifeMonitoring(boolean var1) throws MethodException;

    public void setPdcSetFactoryDefault() throws MethodException;

    public void setVpsSetFactoryDefault() throws MethodException;

    public void setARATargetTrailerAngle(int var1) throws MethodException;

    public void setPDCManeuverAssistConfig(int var1) throws MethodException;

    public void setPDCManeuverAssist(boolean var1) throws MethodException;

    public void setPDCContinueDrivingAssist(int var1) throws MethodException;

    public void setPDCIpaConfig(int var1) throws MethodException;

    public void setPDCPiloPaSystemState(PDCPiloPaSystemState var1) throws MethodException;

    public void setVPSCameraCleaning(VPSCameraCleaning var1) throws MethodException;

    public void setWCAutoActivation(boolean var1) throws MethodException;

    public void setWCSystemOnOff(boolean var1) throws MethodException;

    public void setWCSetFactoryDefault() throws MethodException;

    public void showWCPopup(int var1) throws MethodException;

    public void cancelWCPopup(int var1, int var2) throws MethodException;

    public void requestWCPanelList(CarArrayListUpdateInfo var1) throws MethodException;

    public void enterWCPinPuk(String var1, String var2) throws MethodException;

    public void abortWCEnterPinPuk() throws MethodException;

    public void startWCScanning() throws MethodException;

    public void abortWCScanning() throws MethodException;

    public void startWCPairing(String var1, String var2) throws MethodException;

    public void abortWCPairing() throws MethodException;

    public void startWCSoftwareUpdate(String var1) throws MethodException;

    public void abortWCSoftwareUpdate() throws MethodException;

    public void changeWCPin(String var1, String var2) throws MethodException;

    public void abortWCChangePin() throws MethodException;

    public void changeWCPanelName(String var1, String var2) throws MethodException;

    public void abortWCChangePanelName() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

