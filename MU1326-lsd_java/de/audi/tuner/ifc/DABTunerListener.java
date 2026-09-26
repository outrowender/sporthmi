/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.CmdDefaultListener;
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

public interface DABTunerListener
extends CmdDefaultListener {
    default public void updateSelectedEnsemble(EnsembleInfo ensembleInfo) {
    }

    default public void updateSelectedService(ServiceInfo serviceInfo) {
    }

    default public void updateSelectedComponent(ComponentInfo componentInfo) {
    }

    default public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
    }

    default public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray) {
    }

    default public void updateServiceList(ServiceInfo[] serviceInfoArray) {
    }

    default public void updateComponentList(ComponentInfo[] componentInfoArray) {
    }

    default public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
    }

    default public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
    }

    default public void updateRadioText(DABRadioText dABRadioText) {
    }

    default public void updateSyncStatus(int n) {
    }

    default public void updateQuality(short s) {
    }

    default public void updateLinkingSwitchStatus(int n) {
    }

    default public void updateFrequencyTableSwitchStatus(int n) {
    }

    default public void updateLinkingStatus(int n) {
    }

    default public void updateLinkingUsageStatus(int n) {
    }

    default public void updateDetectedDevice(int n) {
    }

    default public void updateQualityInfo(String string) {
    }

    default public void selectServiceStatus(int n) {
    }

    default public void seekServiceStatus(int n) {
    }

    default public void tuneEnsembleStatus(int n) {
    }

    default public void selectDataServiceStatus(int n) {
    }

    default public void forceLMUpdateStatus(int n) {
    }

    default public void updateEpgLogoList(EPGLogo[] ePGLogoArray) {
    }

    default public void updateAvailability(int n) {
    }

    default public void updateEPGMode(int n) {
    }

    default public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray) {
    }

    default public void updateEPGDetailData(EPGFullInfo ePGFullInfo) {
    }

    default public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
    }

    default public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
    }
}

