/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
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
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;

public interface DSIDABTunerListener
extends DSIListener {
    public void updateSelectedEnsemble(EnsembleInfo var1, int var2);

    public void updateSelectedService(ServiceInfo var1, int var2);

    public void updateSelectedComponent(ComponentInfo var1, int var2);

    public void updateSelectedFrequency(FrequencyInfo var1, int var2);

    public void updateEnsembleList(EnsembleInfo[] var1, int var2);

    public void updateServiceList(ServiceInfo[] var1, int var2);

    public void updateComponentList(ComponentInfo[] var1, int var2);

    public void updateDataServiceList(DataServiceInfo[] var1, int var2);

    public void updateFrequencyList(FrequencyInfo[] var1, int var2);

    public void updateRadioText(DABRadioText var1, int var2);

    public void updateSyncStatus(int var1, int var2);

    public void updateQuality(short var1, int var2);

    public void updateDRCSwitchStatus(boolean var1, int var2);

    public void updateLinkingSwitchStatus(int var1, int var2);

    public void updateFrequencyTableSwitchStatus(int var1, int var2);

    public void updateLinkingStatus(int var1, int var2);

    public void updateLinkingUsageStatus(int var1, int var2);

    public void updateAudioStatus(AudioStatus var1, int var2);

    public void updateDetectedDevice(int var1, int var2);

    public void updateQualityInfo(String var1, int var2);

    public void selectServiceStatus(int var1);

    public void seekServiceStatus(int var1);

    public void tuneEnsembleStatus(int var1);

    public void selectDataServiceStatus(int var1);

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo var1, int var2);

    public void updateDecodedDataService(DataServiceInfo var1, boolean var2, String var3, int var4);

    public void forceLMUpdateStatus(int var1);

    public void prepareTuningStatus(int var1);

    public void updateEpgLogo(int[] var1, ResourceLocator[] var2, int var3);

    public void updateEpgLogoList(EPGLogo[] var1, int var2);

    public void updateSlideShowInfo(DABSlideShowInfo var1, int var2);

    public void updateAvailability(int var1, int var2);

    public void updateIntellitext(IntellitextMenu[] var1, int var2);

    public void updateEPGMode(int var1, int var2);

    public void updateEPGListData(EPGShortInfo[] var1, int var2);

    public void updateEPGDetailData(EPGFullInfo var1, int var2);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

