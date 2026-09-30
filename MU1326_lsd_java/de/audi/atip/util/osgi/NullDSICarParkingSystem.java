/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util.osgi;

import de.audi.atip.interapp.def.NullService;
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
extends NullService
implements DSICarParkingSystem {
    public NullDSICarParkingSystem(LogChannel logChannel) {
        super(logChannel, "DSICarParkingSystem");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void setHMIStateIsReady(boolean bl) {
        this.log();
    }

    public void setPDCDefaultParkingMode(int n) {
        this.log();
    }

    public void setPDCMute(boolean bl) {
        this.log();
    }

    public void setPDCFrequenceFront(int n) {
        this.log();
    }

    public void setPDCFrequenceRear(int n) {
        this.log();
    }

    public void setPDCVolumeFront(int n) {
        this.log();
    }

    public void setPDCVolumeRear(int n) {
        this.log();
    }

    public void setPDCAutoActivation(boolean bl) {
        this.log();
    }

    public void setPDCSystemOnOff(boolean bl) {
        this.log();
    }

    public void setPDCFrequenceRight(int n) {
        this.log();
    }

    public void setPDCFrequenceLeft(int n) {
        this.log();
    }

    public void setPDCVolumeRight(int n) {
        this.log();
    }

    public void setPDCVolumeLeft(int n) {
        this.log();
    }

    public void setPDCManeuverAssistConfig(int n) {
        this.log();
    }

    public void setPDCManeuverAssist(boolean bl) {
        this.log();
    }

    public void setPDCFlankGuard(boolean bl) {
        this.log();
    }

    public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
        this.log();
    }

    public void setVPSFollowUpTime(int n) {
        this.log();
    }

    public void setVPSColor(int n) {
        this.log();
    }

    public void setVPSContrast(int n) {
        this.log();
    }

    public void setVPSBrightness(int n) {
        this.log();
    }

    public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    public void setVPSDefaultView(int n) {
        this.log();
    }

    public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
        this.log();
    }

    public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
        this.log();
    }

    public void setVPSSystemOnOff(boolean bl) {
        this.log();
    }

    public void showParkingPopup(DisplayContent displayContent) {
        this.log();
    }

    public void cancelParkingPopup(DisplayContent displayContent, int n) {
        this.log();
    }

    public void requestLifeMonitoring(boolean bl) {
        this.log();
    }

    public void setPdcSetFactoryDefault() {
        this.log();
    }

    public void setVpsSetFactoryDefault() {
        this.log();
    }

    public void setPDCSoundFront(PDCSound pDCSound) {
        this.log();
    }

    public void setPDCSoundRear(PDCSound pDCSound) {
        this.log();
    }

    public void setPDCSoundLeft(PDCSound pDCSound) {
        this.log();
    }

    public void setPDCSoundRight(PDCSound pDCSound) {
        this.log();
    }

    public void setPDCPLAPreSelection(int n) {
        this.log();
    }

    public void setPDCPLAParkMode(int n) {
        this.log();
    }

    public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
        this.log();
    }

    public void setPDCOffroadMode(boolean bl) {
        this.log();
    }

    public void setPDCVisualisationParkbox(boolean bl) {
        this.log();
    }

    public void setPDCOPSVisualisationPosition(int n) {
        this.log();
    }

    public void setARATargetTrailerAngle(int n) {
        this.log();
    }

    public void setVPSExtCamConfig(int n) {
        this.log();
    }

    public void setVPSExtCamManActivation(boolean bl) {
        this.log();
    }

    public void setVPS3DBirdview(int n, int n2) {
        this.log();
    }

    public void setVPSSystemState(boolean bl) {
        this.log();
    }

    public void setPDCContinueDrivingAssist(int n) {
        this.log();
    }

    public void setPDCIpaConfig(int n) {
        this.log();
    }

    public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
        this.log();
    }

    public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
        this.log();
    }

    public void setWCAutoActivation(boolean bl) {
        this.log();
    }

    public void setWCSystemOnOff(boolean bl) {
        this.log();
    }

    public void setWCSetFactoryDefault() {
        this.log();
    }

    public void showWCPopup(int n) {
        this.log();
    }

    public void cancelWCPopup(int n, int n2) {
        this.log();
    }

    public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.log();
    }

    public void enterWCPinPuk(String string, String string2) {
        this.log();
    }

    public void abortWCEnterPinPuk() {
        this.log();
    }

    public void startWCScanning() {
        this.log();
    }

    public void abortWCScanning() {
        this.log();
    }

    public void startWCPairing(String string, String string2) {
        this.log();
    }

    public void abortWCPairing() {
        this.log();
    }

    public void startWCSoftwareUpdate(String string) {
        this.log();
    }

    public void abortWCSoftwareUpdate() {
        this.log();
    }

    public void changeWCPin(String string, String string2) {
        this.log();
    }

    public void abortWCChangePin() {
        this.log();
    }

    public void changeWCPanelName(String string, String string2) {
        this.log();
    }

    public void abortWCChangePanelName() {
        this.log();
    }
}

