/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.DABTunerListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class NullDABTunerListener
extends NullService
implements DABTunerListener {
    public NullDABTunerListener(LogChannel logChannel) {
        super(logChannel, "DABTunerListener");
    }

    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo) {
        this.log();
    }

    public void updateSelectedService(ServiceInfo serviceInfo) {
        this.log();
    }

    public void updateSelectedComponent(ComponentInfo componentInfo) {
        this.log();
    }

    public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        this.log();
    }

    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        this.log();
    }

    public void updateServiceList(ServiceInfo[] serviceInfoArray) {
        this.log();
    }

    public void updateComponentList(ComponentInfo[] componentInfoArray) {
        this.log();
    }

    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        this.log();
    }

    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        this.log();
    }

    public void updateRadioText(DABRadioText dABRadioText) {
        this.log();
    }

    public void updateSyncStatus(int n) {
        this.log();
    }

    public void updateQuality(short s) {
        this.log();
    }

    public void updateLinkingSwitchStatus(int n) {
        this.log();
    }

    public void updateFrequencyTableSwitchStatus(int n) {
        this.log();
    }

    public void updateLinkingStatus(int n) {
        this.log();
    }

    public void updateLinkingUsageStatus(int n) {
        this.log();
    }

    public void updateDetectedDevice(int n) {
        this.log();
    }

    public void updateQualityInfo(String string) {
        this.log();
    }

    public void selectServiceStatus(int n) {
        this.log();
    }

    public void seekServiceStatus(int n) {
        this.log();
    }

    public void tuneEnsembleStatus(int n) {
        this.log();
    }

    public void selectDataServiceStatus(int n) {
        this.log();
    }

    public void forceLMUpdateStatus(int n) {
        this.log();
    }

    public void updateEpgLogoList(EPGLogo[] ePGLogoArray) {
        this.log();
    }

    public void updateAvailability(int n) {
        this.log();
    }

    public void updateEPGMode(int n) {
        this.log();
    }

    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray) {
        this.log();
    }

    public void updateEPGDetailData(EPGFullInfo ePGFullInfo) {
        this.log();
    }

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        this.log();
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.log();
    }
}

