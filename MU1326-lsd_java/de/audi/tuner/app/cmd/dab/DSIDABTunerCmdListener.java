/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.esolutions.fw.util.commons.Buffer;
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

public class DSIDABTunerCmdListener
implements DSIDABTunerListener {
    private final LogChannel lc;
    private final IRadioCmdManager cmdListManager;

    public DSIDABTunerCmdListener(LogChannel logChannel, IRadioCmdManager iRadioCmdManager) {
        this.lc = logChannel;
        this.cmdListManager = iRadioCmdManager;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000, "[DSIDABTunerCmdListener.asyncException]", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSelectedEnsemble] %1 valid:%2", (Object)ensembleInfo, (long)n);
        if (n == 1 && ensembleInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateSelectedEnsemble(ensembleInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedService(ServiceInfo serviceInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSelectedService] %1 valid:%2", (Object)serviceInfo, (long)n);
        if (n == 1 && serviceInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateSelectedService(serviceInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateSelectedService]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedComponent(ComponentInfo componentInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSelectedComponent] %1 valid:%2", (Object)componentInfo, (long)n);
        if (n == 1 && componentInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateSelectedComponent(componentInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateSelectedComponent]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSelectedFrequency] %1 valid:%2", (Object)frequencyInfo, (long)n);
        if (n == 1 && frequencyInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateSelectedFrequency(frequencyInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateSelectedFrequency]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEnsembleList] #ensembles:%1 valid:%2", (long)this.size(ensembleInfoArray), (long)n);
        if (n == 1 && ensembleInfoArray != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateEnsembleList(ensembleInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateEnsembleList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateServiceList] #services:%1 valid:%2", (long)this.size(serviceInfoArray), (long)n);
        if (n == 1 && serviceInfoArray != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateServiceList(serviceInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateServiceList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateComponentList(ComponentInfo[] componentInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateComponentList] #components:%1 valid:%2", (long)this.size(componentInfoArray), (long)n);
        if (n == 1 && componentInfoArray != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateComponentList(componentInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateComponentList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateDataServiceList] #dataServices:%1 valid:%2", (long)this.size(dataServiceInfoArray), (long)n);
        if (n == 1 && dataServiceInfoArray != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateDataServiceList(dataServiceInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateDataServiceList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateFrequencyList] #frequencies:%1 valid:%2", (long)this.size(frequencyInfoArray), (long)n);
        if (n == 1 && frequencyInfoArray != null) {
            try {
                if (this.lc.isDebug2()) {
                    for (int i2 = 0; i2 < frequencyInfoArray.length; ++i2) {
                        this.lc.log(14808325, "[DSIDABTunerCmdListener.updateFrequencyList] [%2] %1", (Object)frequencyInfoArray[i2], (long)i2);
                    }
                }
                this.cmdListManager.getActiveDABCmd().updateFrequencyList(frequencyInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateFrequencyList]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateRadioText(DABRadioText dABRadioText, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateRadioText] %1 valid:%2", (Object)dABRadioText, (long)n);
        if (n == 1 && dABRadioText != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateRadioText(dABRadioText);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateRadioText]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSyncStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSyncStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateSyncStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateSyncStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateQuality(short s, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateQuality] quality:%1 valid:%2", (long)s, (long)n);
        if (n == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateQuality(s);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateQuality]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateDRCSwitchStatus(boolean bl, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateDRCSwitchStatus] status:%1 valid:%2", bl, (long)n);
    }

    @Override
    public void updateLinkingSwitchStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateLinkingSwitchStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateLinkingSwitchStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateLinkingSwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateFrequencyTableSwitchStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateFrequencyTableSwitchStatus] frequencyTable:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateFrequencyTableSwitchStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateFrequencyTableSwitchStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateLinkingStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateLinkingStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateLinkingStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateLinkingStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateLinkingUsageStatus] status:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateLinkingUsageStatus(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateLinkingUsageStatus]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateAudioStatus(AudioStatus audioStatus, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateAudioStatus] status:%1 valid:%2", (Object)audioStatus, (long)n);
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateDetectedDevice] device:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateDetectedDevice(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateDetectedDevice]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateQualityInfo(String string, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateQualityInfo] qualityInfo:%1 valid:%2", (Object)string, (long)n);
        if (n == 1 && string != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateQualityInfo(string);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateQualityInfo]", (Throwable)exception);
            }
        }
    }

    @Override
    public void selectServiceStatus(int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.selectServiceStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveDABCmd().selectServiceStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIDABTunerCmdListener.selectServiceStatus]", (Throwable)exception);
        }
    }

    @Override
    public void seekServiceStatus(int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.seekServiceStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveDABCmd().seekServiceStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIDABTunerCmdListener.seekServiceStatus]", (Throwable)exception);
        }
    }

    @Override
    public void tuneEnsembleStatus(int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.tuneEnsembleStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveDABCmd().tuneEnsembleStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIDABTunerCmdListener.tuneEnsembleStatus]", (Throwable)exception);
        }
    }

    @Override
    public void selectDataServiceStatus(int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.selectDataServiceStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveDABCmd().selectDataServiceStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIDABTunerCmdListener.selectDataServiceStatus]", (Throwable)exception);
        }
    }

    @Override
    public void updateDecodedDataService(DataServiceInfo dataServiceInfo, boolean bl, String string, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateDecodedDataService] %1 toggle:%2", (Object)dataServiceInfo, (Object)bl);
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateDecodedDataService] uri:%1 valid:%2", (Object)string, (long)n);
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.forceLMUpdateStatus] status:%1", (long)n);
        try {
            this.cmdListManager.getActiveDABCmd().forceLMUpdateStatus(n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[DSIDABTunerCmdListener.forceLMUpdateStatus]", (Throwable)exception);
        }
    }

    @Override
    public void prepareTuningStatus(int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.prepareTuningStatus] status:%1", (long)n);
    }

    @Override
    public void updateEpgLogo(int[] nArray, ResourceLocator[] resourceLocatorArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEpgLogo] #sID:%1 #pictureIds:%2 valid:%3", (long)this.size(nArray), (long)this.size(resourceLocatorArray), (long)n);
    }

    @Override
    public void updateAvailability(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateAvailability] availability:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateAvailability(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateAvailability]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateIntellitext(IntellitextMenu[] intellitextMenuArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateIntellitext] #IntellitextMenu:%1 valid:%2", (long)this.size(intellitextMenuArray), (long)n);
        if (n == 1 && intellitextMenuArray != null && this.lc.isDebug2()) {
            for (int i2 = 0; i2 < intellitextMenuArray.length; ++i2) {
                this.lc.log(14808325, "[DSIDABTunerCmdListener.updateIntellitext] [%2] %1", (Object)intellitextMenuArray[i2], (long)i2);
            }
        }
    }

    @Override
    public void updateEPGMode(int n, int n2) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEPGMode] mode:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            try {
                this.cmdListManager.getActiveDABCmd().updateEPGMode(n);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateEPGMode]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEPGListData] #size:%1 valid:%2", (long)this.size(ePGShortInfoArray), (long)n);
        if (n == 1 && ePGShortInfoArray != null) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < ePGShortInfoArray.length; ++i2) {
                    this.lc.log(14808325, "[DSIDABTunerCmdListener.updateEPGListData] #epgList:[%2]: %1", (Object)ePGShortInfoArray[i2], (long)i2);
                }
            } else if (this.lc.isDebug()) {
                Buffer buffer = this.logList(ePGShortInfoArray);
                this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEPGListData] #epgList:%1", (Object)buffer);
            }
            try {
                this.cmdListManager.getActiveDABCmd().updateEPGListData(ePGShortInfoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateEPGListData]", (Throwable)exception);
            }
        }
    }

    private Buffer logList(EPGShortInfo[] ePGShortInfoArray) {
        Buffer buffer = new Buffer(200);
        buffer.append(this.size(ePGShortInfoArray));
        buffer.append(':');
        for (int i2 = 0; i2 < ePGShortInfoArray.length; ++i2) {
            if (ePGShortInfoArray[i2] == null) continue;
            buffer.append(ePGShortInfoArray[i2].ensID);
            buffer.append('-');
            buffer.append(ePGShortInfoArray[i2].sID);
            buffer.append(' ');
        }
        return buffer;
    }

    @Override
    public void updateEPGDetailData(EPGFullInfo ePGFullInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEPGDetailData] %1 valid:%2", (Object)ePGFullInfo, (long)n);
        if (n == 1 && ePGFullInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateEPGDetailData(ePGFullInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateEPGDetailData]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateRadioTextPlusInfo] %1 valid:%2", (Object)dABRadioTextPlusInfo, (long)n);
        if (n == 1 && dABRadioTextPlusInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateRadioTextPlusInfo(dABRadioTextPlusInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateRadioTextPlusInfo]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSlideShowInfo] %1 valid:%2", (Object)dABSlideShowInfo, (long)n);
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateSlideShowInfo]: duration1 0x%1, duration2 0x%2", (long)Utilities.getSlideshowDisplayDuration1(), (long)Utilities.getSlideshowDisplayDuration2());
        if (n == 1 && dABSlideShowInfo != null) {
            try {
                this.cmdListManager.getActiveDABCmd().updateSlideShowInfo(dABSlideShowInfo);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateSlideShowInfo]", (Throwable)exception);
            }
        }
    }

    @Override
    public void updateEpgLogoList(EPGLogo[] ePGLogoArray, int n) {
        this.lc.log(-2137614336, "[DSIDABTunerCmdListener.updateEpgLogoList] %1 valid:%2", (long)this.size(ePGLogoArray), (long)n);
        if (n == 1 && ePGLogoArray != null) {
            if (this.lc.isDebug2()) {
                for (int i2 = 0; i2 < ePGLogoArray.length; ++i2) {
                    this.lc.log(14808325, "[DSIDABTunerCmdListener.updateEpgLogoList] [%2] %1", (Object)ePGLogoArray[i2], (long)i2);
                }
            }
            try {
                this.cmdListManager.getActiveDABCmd().updateEpgLogoList(ePGLogoArray);
            }
            catch (Exception exception) {
                this.lc.log(10000, "[DSIDABTunerCmdListener.updateEpgLogoList]", (Throwable)exception);
            }
        }
    }

    private int size(Object[] objectArray) {
        return objectArray != null ? objectArray.length : -1;
    }

    private int size(int[] nArray) {
        return nArray != null ? nArray.length : -1;
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }
}

