/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSIDABTunerReply {
    public static final String IPL_COMM_UUID = "3fbfdf95-fc8b-5629-8f28-b325d5f820f4";
    public static final String IPL_COMM_INTERFACE_KEY = "61784239-985b-53d5-a461-2d04f297b9d6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void updateSelectedEnsemble(EnsembleInfo var1, int var2) throws MethodException;

    public void updateSelectedService(ServiceInfo var1, int var2) throws MethodException;

    public void updateSelectedComponent(ComponentInfo var1, int var2) throws MethodException;

    public void updateSelectedFrequency(FrequencyInfo var1, int var2) throws MethodException;

    public void updateEnsembleList(EnsembleInfo[] var1, int var2) throws MethodException;

    public void updateServiceList(ServiceInfo[] var1, int var2) throws MethodException;

    public void updateComponentList(ComponentInfo[] var1, int var2) throws MethodException;

    public void updateDataServiceList(DataServiceInfo[] var1, int var2) throws MethodException;

    public void updateFrequencyList(FrequencyInfo[] var1, int var2) throws MethodException;

    public void updateRadioText(DABRadioText var1, int var2) throws MethodException;

    public void updateSyncStatus(int var1, int var2) throws MethodException;

    public void updateQuality(short var1, int var2) throws MethodException;

    public void updateDRCSwitchStatus(boolean var1, int var2) throws MethodException;

    public void updateLinkingSwitchStatus(int var1, int var2) throws MethodException;

    public void updateFrequencyTableSwitchStatus(int var1, int var2) throws MethodException;

    public void updateLinkingStatus(int var1, int var2) throws MethodException;

    public void updateLinkingUsageStatus(int var1, int var2) throws MethodException;

    public void updateAudioStatus(AudioStatus var1, int var2) throws MethodException;

    public void updateDetectedDevice(int var1, int var2) throws MethodException;

    public void updateQualityInfo(String var1, int var2) throws MethodException;

    public void selectServiceStatus(int var1) throws MethodException;

    public void seekServiceStatus(int var1) throws MethodException;

    public void tuneEnsembleStatus(int var1) throws MethodException;

    public void selectDataServiceStatus(int var1) throws MethodException;

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo var1, int var2) throws MethodException;

    public void updateDecodedDataService(DataServiceInfo var1, boolean var2, String var3, int var4) throws MethodException;

    public void forceLMUpdateStatus(int var1) throws MethodException;

    public void prepareTuningStatus(int var1) throws MethodException;

    public void updateEpgLogo(int[] var1, ResourceLocator[] var2, int var3) throws MethodException;

    public void updateEpgLogoList(EPGLogo[] var1, int var2) throws MethodException;

    public void updateSlideShowInfo(DABSlideShowInfo var1, int var2) throws MethodException;

    public void updateAvailability(int var1, int var2) throws MethodException;

    public void updateIntellitext(IntellitextMenu[] var1, int var2) throws MethodException;

    public void updateEPGMode(int var1, int var2) throws MethodException;

    public void updateEPGListData(EPGShortInfo[] var1, int var2) throws MethodException;

    public void updateEPGDetailData(EPGFullInfo var1, int var2) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

