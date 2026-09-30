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
    public void updateSelectedEnsemble(EnsembleInfo var1);

    public void updateSelectedService(ServiceInfo var1);

    public void updateSelectedComponent(ComponentInfo var1);

    public void updateSelectedFrequency(FrequencyInfo var1);

    public void updateEnsembleList(EnsembleInfo[] var1);

    public void updateServiceList(ServiceInfo[] var1);

    public void updateComponentList(ComponentInfo[] var1);

    public void updateDataServiceList(DataServiceInfo[] var1);

    public void updateFrequencyList(FrequencyInfo[] var1);

    public void updateRadioText(DABRadioText var1);

    public void updateSyncStatus(int var1);

    public void updateQuality(short var1);

    public void updateLinkingSwitchStatus(int var1);

    public void updateFrequencyTableSwitchStatus(int var1);

    public void updateLinkingStatus(int var1);

    public void updateLinkingUsageStatus(int var1);

    public void updateDetectedDevice(int var1);

    public void updateQualityInfo(String var1);

    public void selectServiceStatus(int var1);

    public void seekServiceStatus(int var1);

    public void tuneEnsembleStatus(int var1);

    public void selectDataServiceStatus(int var1);

    public void forceLMUpdateStatus(int var1);

    public void updateEpgLogoList(EPGLogo[] var1);

    public void updateAvailability(int var1);

    public void updateEPGMode(int var1);

    public void updateEPGListData(EPGShortInfo[] var1);

    public void updateEPGDetailData(EPGFullInfo var1);

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo var1);

    public void updateSlideShowInfo(DABSlideShowInfo var1);
}

