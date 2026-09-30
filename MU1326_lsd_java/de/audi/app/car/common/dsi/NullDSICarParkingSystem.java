/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
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

public class NullDSICarParkingSystem
implements DSICarParkingSystem {
    private final LogChannel logChan;

    public NullDSICarParkingSystem(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setHMIStateIsReady(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCDefaultParkingMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCMute(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCFrequenceFront(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCFrequenceRear(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCVolumeFront(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCVolumeRear(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCAutoActivation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCFrequenceRight(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCFrequenceLeft(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCVolumeRight(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCVolumeLeft(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCFlankGuard(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSFollowUpTime(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSColor(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSContrast(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSBrightness(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSDefaultView(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void showParkingPopup(DisplayContent displayContent) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void cancelParkingPopup(DisplayContent displayContent, int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void requestLifeMonitoring(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPdcSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVpsSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCSoundFront(PDCSound pDCSound) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCSoundRear(PDCSound pDCSound) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCSoundLeft(PDCSound pDCSound) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCSoundRight(PDCSound pDCSound) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCPLAPreSelection(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCPLAParkMode(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCOffroadMode(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCVisualisationParkbox(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCOPSVisualisationPosition(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setARATargetTrailerAngle(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSExtCamConfig(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSExtCamManActivation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPS3DBirdview(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSSystemState(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCManeuverAssistConfig(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCManeuverAssist(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCContinueDrivingAssist(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCIpaConfig(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setWCAutoActivation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setWCSystemOnOff(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void setWCSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void showWCPopup(int n) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void cancelWCPopup(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void enterWCPinPuk(String string, String string2) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void abortWCEnterPinPuk() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void startWCScanning() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void abortWCScanning() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void startWCPairing(String string, String string2) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void abortWCPairing() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void startWCSoftwareUpdate(String string) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void abortWCSoftwareUpdate() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void changeWCPin(String string, String string2) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void abortWCChangePin() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void changeWCPanelName(String string, String string2) {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }

    public void abortWCChangePanelName() {
        this.logChan.log(1000, "null-call at NullDSICarParkingSystem");
    }
}

