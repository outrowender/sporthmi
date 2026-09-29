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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setHMIStateIsReady(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCDefaultParkingMode(int n) {
        this.log();
    }

    @Override
    public void setPDCMute(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCFrequenceFront(int n) {
        this.log();
    }

    @Override
    public void setPDCFrequenceRear(int n) {
        this.log();
    }

    @Override
    public void setPDCVolumeFront(int n) {
        this.log();
    }

    @Override
    public void setPDCVolumeRear(int n) {
        this.log();
    }

    @Override
    public void setPDCAutoActivation(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCSystemOnOff(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCFrequenceRight(int n) {
        this.log();
    }

    @Override
    public void setPDCFrequenceLeft(int n) {
        this.log();
    }

    @Override
    public void setPDCVolumeRight(int n) {
        this.log();
    }

    @Override
    public void setPDCVolumeLeft(int n) {
        this.log();
    }

    @Override
    public void setPDCManeuverAssistConfig(int n) {
        this.log();
    }

    @Override
    public void setPDCManeuverAssist(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCFlankGuard(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction) {
        this.log();
    }

    @Override
    public void setVPSFollowUpTime(int n) {
        this.log();
    }

    @Override
    public void setVPSColor(int n) {
        this.log();
    }

    @Override
    public void setVPSContrast(int n) {
        this.log();
    }

    @Override
    public void setVPSBrightness(int n) {
        this.log();
    }

    @Override
    public void setVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    @Override
    public void setVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    @Override
    public void setVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    @Override
    public void setVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode) {
        this.log();
    }

    @Override
    public void setVPSDefaultView(int n) {
        this.log();
    }

    @Override
    public void setVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay) {
        this.log();
    }

    @Override
    public void setVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode) {
        this.log();
    }

    @Override
    public void setVPSSystemOnOff(boolean bl) {
        this.log();
    }

    @Override
    public void showParkingPopup(DisplayContent displayContent) {
        this.log();
    }

    @Override
    public void cancelParkingPopup(DisplayContent displayContent, int n) {
        this.log();
    }

    @Override
    public void requestLifeMonitoring(boolean bl) {
        this.log();
    }

    @Override
    public void setPdcSetFactoryDefault() {
        this.log();
    }

    @Override
    public void setVpsSetFactoryDefault() {
        this.log();
    }

    @Override
    public void setPDCSoundFront(PDCSound pDCSound) {
        this.log();
    }

    @Override
    public void setPDCSoundRear(PDCSound pDCSound) {
        this.log();
    }

    @Override
    public void setPDCSoundLeft(PDCSound pDCSound) {
        this.log();
    }

    @Override
    public void setPDCSoundRight(PDCSound pDCSound) {
        this.log();
    }

    @Override
    public void setPDCPLAPreSelection(int n) {
        this.log();
    }

    @Override
    public void setPDCPLAParkMode(int n) {
        this.log();
    }

    @Override
    public void setPDCPLASystemState(PDCPLASystemState pDCPLASystemState) {
        this.log();
    }

    @Override
    public void setPDCOffroadMode(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCVisualisationParkbox(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCOPSVisualisationPosition(int n) {
        this.log();
    }

    @Override
    public void setARATargetTrailerAngle(int n) {
        this.log();
    }

    @Override
    public void setVPSExtCamConfig(int n) {
        this.log();
    }

    @Override
    public void setVPSExtCamManActivation(boolean bl) {
        this.log();
    }

    @Override
    public void setVPS3DBirdview(int n, int n2) {
        this.log();
    }

    @Override
    public void setVPSSystemState(boolean bl) {
        this.log();
    }

    @Override
    public void setPDCContinueDrivingAssist(int n) {
        this.log();
    }

    @Override
    public void setPDCIpaConfig(int n) {
        this.log();
    }

    @Override
    public void setPDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState) {
        this.log();
    }

    @Override
    public void setVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning) {
        this.log();
    }

    @Override
    public void setWCAutoActivation(boolean bl) {
        this.log();
    }

    @Override
    public void setWCSystemOnOff(boolean bl) {
        this.log();
    }

    @Override
    public void setWCSetFactoryDefault() {
        this.log();
    }

    @Override
    public void showWCPopup(int n) {
        this.log();
    }

    @Override
    public void cancelWCPopup(int n, int n2) {
        this.log();
    }

    @Override
    public void requestWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.log();
    }

    @Override
    public void enterWCPinPuk(String string, String string2) {
        this.log();
    }

    @Override
    public void abortWCEnterPinPuk() {
        this.log();
    }

    @Override
    public void startWCScanning() {
        this.log();
    }

    @Override
    public void abortWCScanning() {
        this.log();
    }

    @Override
    public void startWCPairing(String string, String string2) {
        this.log();
    }

    @Override
    public void abortWCPairing() {
        this.log();
    }

    @Override
    public void startWCSoftwareUpdate(String string) {
        this.log();
    }

    @Override
    public void abortWCSoftwareUpdate() {
        this.log();
    }

    @Override
    public void changeWCPin(String string, String string2) {
        this.log();
    }

    @Override
    public void abortWCChangePin() {
        this.log();
    }

    @Override
    public void changeWCPanelName(String string, String string2) {
        this.log();
    }

    @Override
    public void abortWCChangePanelName() {
        this.log();
    }
}

