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

    @Override
    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo) {
        this.log();
    }

    @Override
    public void updateSelectedService(ServiceInfo serviceInfo) {
        this.log();
    }

    @Override
    public void updateSelectedComponent(ComponentInfo componentInfo) {
        this.log();
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        this.log();
    }

    @Override
    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        this.log();
    }

    @Override
    public void updateServiceList(ServiceInfo[] serviceInfoArray) {
        this.log();
    }

    @Override
    public void updateComponentList(ComponentInfo[] componentInfoArray) {
        this.log();
    }

    @Override
    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        this.log();
    }

    @Override
    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        this.log();
    }

    @Override
    public void updateRadioText(DABRadioText dABRadioText) {
        this.log();
    }

    @Override
    public void updateSyncStatus(int n) {
        this.log();
    }

    @Override
    public void updateQuality(short s) {
        this.log();
    }

    @Override
    public void updateLinkingSwitchStatus(int n) {
        this.log();
    }

    @Override
    public void updateFrequencyTableSwitchStatus(int n) {
        this.log();
    }

    @Override
    public void updateLinkingStatus(int n) {
        this.log();
    }

    @Override
    public void updateLinkingUsageStatus(int n) {
        this.log();
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.log();
    }

    @Override
    public void updateQualityInfo(String string) {
        this.log();
    }

    @Override
    public void selectServiceStatus(int n) {
        this.log();
    }

    @Override
    public void seekServiceStatus(int n) {
        this.log();
    }

    @Override
    public void tuneEnsembleStatus(int n) {
        this.log();
    }

    @Override
    public void selectDataServiceStatus(int n) {
        this.log();
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        this.log();
    }

    @Override
    public void updateEpgLogoList(EPGLogo[] ePGLogoArray) {
        this.log();
    }

    @Override
    public void updateAvailability(int n) {
        this.log();
    }

    @Override
    public void updateEPGMode(int n) {
        this.log();
    }

    @Override
    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray) {
        this.log();
    }

    @Override
    public void updateEPGDetailData(EPGFullInfo ePGFullInfo) {
        this.log();
    }

    @Override
    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        this.log();
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.log();
    }
}

