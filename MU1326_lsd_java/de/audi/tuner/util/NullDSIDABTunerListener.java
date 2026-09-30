/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;

public class NullDSIDABTunerListener
extends NullService
implements DSIDABTunerListener {
    public NullDSIDABTunerListener(LogChannel logChannel) {
        super(logChannel, "DSIDABTunerListener");
    }

    public void asyncException(int n, String string, int n2) {
        this.log();
    }

    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        this.log();
    }

    public void updateSelectedService(ServiceInfo serviceInfo, int n) {
        this.log();
    }

    public void updateSelectedComponent(ComponentInfo componentInfo, int n) {
        this.log();
    }

    public void updateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        this.log();
    }

    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
        this.log();
    }

    public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        this.log();
    }

    public void updateComponentList(ComponentInfo[] componentInfoArray, int n) {
        this.log();
    }

    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
        this.log();
    }

    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
        this.log();
    }

    public void updateRadioText(DABRadioText dABRadioText, int n) {
        this.log();
    }

    public void updateSyncStatus(int n, int n2) {
        this.log();
    }

    public void updateQuality(short s, int n) {
        this.log();
    }

    public void updateDRCSwitchStatus(boolean bl, int n) {
        this.log();
    }

    public void updateLinkingSwitchStatus(int n, int n2) {
        this.log();
    }

    public void updateFrequencyTableSwitchStatus(int n, int n2) {
        this.log();
    }

    public void updateLinkingStatus(int n, int n2) {
        this.log();
    }

    public void updateLinkingUsageStatus(int n, int n2) {
        this.log();
    }

    public void updateAudioStatus(AudioStatus audioStatus, int n) {
        this.log();
    }

    public void updateDetectedDevice(int n, int n2) {
        this.log();
    }

    public void updateQualityInfo(String string, int n) {
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

    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        this.log();
    }

    public void updateDecodedDataService(DataServiceInfo dataServiceInfo, boolean bl, String string, int n) {
        this.log();
    }

    public void forceLMUpdateStatus(int n) {
        this.log();
    }

    public void prepareTuningStatus(int n) {
        this.log();
    }

    public void updateEpgLogo(int[] nArray, ResourceLocator[] resourceLocatorArray, int n) {
        this.log();
    }

    public void updateSlideShowImage(ResourceLocator resourceLocator, DateTime dateTime, int n) {
        this.log();
    }

    public void updateAvailability(int n, int n2) {
        this.log();
    }

    public void updateIntellitext(IntellitextMenu[] intellitextMenuArray, int n) {
        this.log();
    }

    public void updateEPGMode(int n, int n2) {
        this.log();
    }

    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray, int n) {
        this.log();
    }

    public void updateEPGDetailData(EPGFullInfo ePGFullInfo, int n) {
        this.log();
    }

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
        this.log();
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        this.log();
    }

    public void updateEpgLogoList(EPGLogo[] ePGLogoArray, int n) {
        this.log();
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.log();
    }

    public void profileChanged(int n, int n2) {
        this.log();
    }

    public void profileCopied(int n, int n2, int n3) {
        this.log();
    }

    public void profileReset(int n, int n2) {
        this.log();
    }

    public void profileResetAll(int n) {
        this.log();
    }
}

