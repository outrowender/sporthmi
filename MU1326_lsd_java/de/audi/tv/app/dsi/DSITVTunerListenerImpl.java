/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.BCDTime;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.favorites.EmptyFavoritesList;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.settings.AVNorm;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.DSITVTunerListener;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;
import org.dsi.ifc.tvtuner.Time;

public class DSITVTunerListenerImpl
implements DSITVTunerListener {
    private final LogChannel log;
    public volatile ProgramInfo lastUpdatedProgramInfo;
    public volatile ServiceInfo[] lastUpdatedServiceList = new ServiceInfo[0];
    public volatile StartUpConfig lastUpdatedStartUpConfig = new StartUpConfig();
    private DefaultTVListener[] listeners = new DefaultTVListener[0];
    private final Object mutexAddListeners = new Object();
    private IFavoritesList favoritesList = new EmptyFavoritesList();

    public DSITVTunerListenerImpl(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void setFavoritesList(IFavoritesList iFavoritesList) {
        this.favoritesList = iFavoritesList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addListeners(DefaultTVListener[] defaultTVListenerArray) {
        Object object = this.mutexAddListeners;
        synchronized (object) {
            DefaultTVListener[] defaultTVListenerArray2 = new DefaultTVListener[this.listeners.length + defaultTVListenerArray.length];
            System.arraycopy((Object)this.listeners, 0, (Object)defaultTVListenerArray2, 0, this.listeners.length);
            System.arraycopy((Object)defaultTVListenerArray, 0, (Object)defaultTVListenerArray2, this.listeners.length, defaultTVListenerArray.length);
            this.listeners = defaultTVListenerArray2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeListeners() {
        Object object = this.mutexAddListeners;
        synchronized (object) {
            this.listeners = new DefaultTVListener[0];
        }
    }

    public void updateTunerState(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateTunerState] INVALID:%1", (long)n2);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateTunerState] state:%1", (long)n);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateTunerState(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateTunerState]", (Throwable)exception);
        }
    }

    public void updateStartUpMUConfig(StartUpConfig startUpConfig, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateStartUpMUConfig] INVALID:%1", (long)n);
            return;
        }
        if (startUpConfig == null) {
            this.log.log(10000, "<- [DSITVTunerListener.updateStartUpMUConfig] startupConfig:NULL");
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateStartUpMUConfig] %1", (Object)startUpConfig);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateStartUpMUConfig(startUpConfig);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateStartUpMUConfig]", (Throwable)exception);
        }
        this.lastUpdatedStartUpConfig = startUpConfig;
    }

    public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateServiceList] INVALID:%1", (long)n);
            return;
        }
        if (serviceInfoArray == null) {
            this.log.log(10000, "<- [DSITVTunerListener.updateServiceList] serviceList:NULL");
            return;
        }
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer(5000);
            buffer.append("[DSITVTunerListener.updateServiceList] list:\n");
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                buffer.append("    ").append(i2).append(": ").append(serviceInfoArray[i2]).append('\n');
            }
            this.log.log(10000000, buffer.toString());
        } else {
            this.log.log(1000000, "<- [DSITVTunerListener.updateServiceList] #%1", (long)serviceInfoArray.length);
        }
        try {
            for (int i3 = 0; i3 < this.listeners.length; ++i3) {
                this.listeners[i3].updateServiceList(serviceInfoArray);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateServiceList]", (Throwable)exception);
        }
        this.lastUpdatedServiceList = serviceInfoArray;
    }

    public void updateSelectedService(ProgramInfo programInfo, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateSelectedService] INVALID:%1", (long)n);
            return;
        }
        if (programInfo == null) {
            this.log.log(10000, "<- [DSITVTunerListener.updateSelectedService] selectedService:NULL");
            return;
        }
        if (programInfo.serviceInfo == null) {
            this.log.log(10000, " [DSITVTunerListener.updateSelectedService]:%1", (Object)"serviceInfo member is null--thus getting programID is impossible");
            return;
        }
        this.lastUpdatedProgramInfo = programInfo;
        if (programInfo.availableAudioChannels == null) {
            this.log.log(100000, " [DSITVTunerListener.updateSelectedService]:%1", (Object)"serviceInfo.availableAudioChannels is null");
            programInfo.availableAudioChannels = new AudioChannel[0];
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateSelectedService] %1 ", (Object)programInfo);
        ProgramInfo programInfo2 = this.correctInvalidService(programInfo);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateSelectedService(programInfo2);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateSelectedService]", (Throwable)exception);
        }
    }

    public void updateSelectedSource(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateSelectedSource] INVALID:%1", (long)n2);
            return;
        }
        if (this.log.isDebug()) {
            String string = n == 0 ? "TV" : "AV";
            this.log.log(10000000, "<- [DSITVTunerListener.updateSelectedSource] %1(%2)", (Object)string, (long)n);
        }
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateSelectedSource(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateSelectedSource]", (Throwable)exception);
        }
    }

    public void updateTVNormArea(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateTVNormArea] INVALID:%1", (long)n2);
            return;
        }
        if (this.log.isDebug()) {
            this.log.log(10000000, "<- [DSITVTunerListener.updateTVNormArea] 0x%1", (Object)Integer.toHexString(n));
        }
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateTVNormArea(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateTVNormArea]", (Throwable)exception);
        }
    }

    public void updateTerminalMode(int n, int n2, int n3) {
        if (n3 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateTerminalMode] INVALID:%1", (long)n3);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateTerminalMode] terminal:0x%1 screen:0x%2", (long)n, (long)n2);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateTerminalMode(n, n2);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateTerminalMode]", (Throwable)exception);
        }
    }

    public void updateMuteState(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateMuteState] INVALID:%1", (long)n2);
            return;
        }
        this.log.log(10000000, "<- [TVTunerDSIListener.updateMuteState] %1", (long)n);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateMuteState(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateMuteState]", (Throwable)exception);
        }
    }

    public void updateTVNormList(int[] nArray, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateTVNormList] INVALID:%1", (long)n);
            return;
        }
        if (nArray == null) {
            this.log.log(10000, "<- [TVTunerDSIListener.updateTVNormList] tvNormList:NULL");
            return;
        }
        if (this.log.isDebug()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append(" 0x").append(Integer.toHexString(nArray[i2]));
            }
            this.log.log(10000000, "<- [TVTunerDSIListener.updateTVNormList]%1", (Object)buffer);
        }
        try {
            for (int i3 = 0; i3 < this.listeners.length; ++i3) {
                this.listeners[i3].updateTVNormList(nArray);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateTVNormList]", (Throwable)exception);
        }
    }

    public void updateEWSInfoList(EWSInfo[] eWSInfoArray, int n) {
        int n2;
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateEWSInfoList] INVALID:%1", (long)n);
            return;
        }
        if (eWSInfoArray == null) {
            this.log.log(10000, "<- [TVTunerDSIListener.updateEWSInfoList] ewsInfoList:NULL");
            return;
        }
        this.log.log(10000000, "<- [TVTunerDSIListener.updateEWSInfoList] #%1", (long)eWSInfoArray.length);
        if (this.log.isDebug2()) {
            for (n2 = 0; n2 < eWSInfoArray.length; ++n2) {
                this.log.log(100000000, "<- [TVTunerDSIListener.updateEWSInfoList] [%2] %1", (Object)eWSInfoArray[n2], (long)n2);
            }
        }
        for (n2 = 0; n2 < eWSInfoArray.length; ++n2) {
            EWSInfo eWSInfo = eWSInfoArray[n2];
            if (!BCDTime.isValid(eWSInfo.warningTime)) {
                this.log.log(10000, "<- [TVTunerDSIListener.updateEWSInfoList] Invalid Time [%2] %1", (Object)eWSInfoArray[n2], (long)n2);
                eWSInfo.warningTime = new Time();
            }
            if (eWSInfo.areaCodeListNames != null) continue;
            this.log.log(10000, "<- [TVTunerDSIListener.updateEWSInfoList] areaCodeList is NULL [%2] %1", (Object)eWSInfoArray[n2], (long)n2);
            eWSInfo.areaCodeListNames = new String[0];
        }
        try {
            for (n2 = 0; n2 < this.listeners.length; ++n2) {
                this.listeners[n2].updateEWSInfoList(eWSInfoArray);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateEWSInfoList]", (Throwable)exception);
        }
    }

    public void updateAudioChannel(int n, int n2) {
    }

    public void updateServiceLinking(boolean bl, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateServiceLinking] INVALID:%1", (long)n);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateServiceLinking] linkingState:%1", bl);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateServiceLinking(bl);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateServiceLinking]", (Throwable)exception);
        }
    }

    public void updateAVNorm(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateAVNorm] INVALID:%1", (long)n2);
            return;
        }
        if (this.log.isDebug()) {
            this.log.log(10000000, "<- [DSITVTunerListener.updateAVNorm] %1(%2)", (Object)AVNorm.toString(n), (long)n);
        }
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateAVNorm(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateAVNorm]", (Throwable)exception);
        }
    }

    public void updateSubtitle(boolean bl, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateSubtitle] INVALID:%1", (long)n);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateSubtitle] state:%1", bl);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateSubtitle(bl);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateSubtitle]", (Throwable)exception);
        }
    }

    public void updateLogoList(LogoInfo[] logoInfoArray, int n) {
        int n2;
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateLogoList] INVALID:%1", (long)n);
            return;
        }
        if (logoInfoArray == null) {
            this.log.log(10000, "<- [DSITVTunerListener.updateLogoList] logoList:NULL");
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateLogoList] #%1", (long)logoInfoArray.length);
        if (this.log.isDebug2()) {
            for (n2 = 0; n2 < logoInfoArray.length; ++n2) {
                this.log.log(100000000, "<- [DSITVTunerListener.updateLogoList] [%2] %1", (Object)logoInfoArray[n2], (long)n2);
            }
        }
        try {
            for (n2 = 0; n2 < this.listeners.length; ++n2) {
                this.listeners[n2].updateLogoList(logoInfoArray);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateLogoList]", (Throwable)exception);
        }
    }

    public void updateCASInfo(boolean bl, String string, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateCASInfo] INVALID:%1", (long)n);
            return;
        }
        if (string == null) {
            this.log.log(10000, "<- [DSITVTunerListener.updateCASInfo] casIDText:NULL");
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateCASInfo] permanentID:%1 casID:%2", bl, (Object)string);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateCASInfo(bl, string);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateCASInfo]", (Throwable)exception);
        }
    }

    public void updateTMTVKeyPanel(short s, short s2, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateTMTVKeyPanel] INVALID:%1", (long)n);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateTMTVKeyPanel] id:0x%1 status:0x%2", (long)s, (long)s2);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateTMTVKeyPanel(s, s2);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateTMTVKeyPanel]", (Throwable)exception);
        }
    }

    public void updateMessageService(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateMessageService] INVALID:%1", (long)n2);
            return;
        }
        this.log.log(1000000, "<- [DSITVTunerListener.updateMessageService] id:%1 valid:%2", (long)n, (long)n2);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateMessageService(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateMessageService]", (Throwable)exception);
        }
    }

    public void selectNextService(int n) {
        int n2 = n == 1 ? 10000000 : 10000;
        this.log.log(n2, "<- [DSITVTunerListener.selectNextService] result:%1", (long)n);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].selectNextService(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.selectNextService]", (Throwable)exception);
        }
    }

    public void abortSeek(int n) {
        int n2 = n == 1 ? 10000000 : 10000;
        this.log.log(n2, "<- [DSITVTunerListener.abortSeek] result:%1", (long)n);
    }

    public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3, int n) {
        if (n != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateTuneStatus] INVALID:%1", (long)n);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateTuneStatus] tuneToStatus:%1 valid:%2", bl3, (long)n);
        this.log.log(10000000, "<- [DSITVTunerListener.updateTuneStatus] tuneUpStatus:%1 tuneDownStatus:%2", bl, bl2);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateTuneStatus(bl, bl2, bl3);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateTuneStatus]", (Throwable)exception);
        }
    }

    public void updateTVNormAreaSubList(int[] nArray, int n) {
        this.log.log(100000000, "<- [TVTunerDSIListener.updateTVNormAreaSubList] %1 valid:%2", (Object)nArray, (long)n);
    }

    public void updateInfoTextState(String string, int n) {
        this.log.log(10000000, "<- [DSITVTunerListener.updateInfoTextState] infoText:%1 valid:%2", (Object)string, (long)n);
    }

    public void selectService(int n) {
        int n2 = n == 1 ? 10000000 : 10000;
        this.log.log(n2, "<- [TVTunerDSIListener.selectService] result:%1", (long)n);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].selectService(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.selectService]", (Throwable)exception);
        }
    }

    public void switchSource(int n) {
        int n2 = n == 1 ? 10000000 : 10000;
        this.log.log(n2, "<- [DSITVTunerListener.switchSource] result:%1", (long)n);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].switchSource(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.switchSource]", (Throwable)exception);
        }
    }

    public void updateBrowserListSort(int n, int n2) {
        if (n2 != 1) {
            this.log.log(100000, "<- [DSITVTunerListener.updateBrowserListSort] INVALID:%1", (long)n2);
            return;
        }
        this.log.log(10000000, "<- [DSITVTunerListener.updateBrowserListSort] sort:%1 valid:%2", (long)n, (long)n2);
        try {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateBrowserListSort(n);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "<- [DSITVTunerListener.updateMessageService]", (Throwable)exception);
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "<- [DSITVTunerListener.asyncException] msg:%1 code:%2 type:%3", (Object)string, (long)n, (long)n2);
    }

    private ProgramInfo correctInvalidService(ProgramInfo programInfo) {
        int n;
        if (programInfo.serviceInfo.name == null || programInfo.serviceInfo.name.length() == 0) {
            programInfo.serviceInfo.name = programInfo.channelName;
        }
        if (programInfo.nowStartTime == null || programInfo.nowEndTime == null) {
            programInfo.nowStartTime = new Time();
            programInfo.nowEndTime = new Time();
        }
        if ((n = programInfo.serviceInfo.sType) != 15) {
            return programInfo;
        }
        ServiceInfo serviceInfo = null;
        if (this.favoritesList instanceof EmptyFavoritesList) {
            this.log.log(100000, "[DSITVTunerListenerImpl.correctInvalidService] unable to get fallback service, no memoryList is set!");
        } else {
            long l = this.favoritesList.getFavoriteID(programInfo.serviceInfo);
            serviceInfo = this.favoritesList.getServiceForUniqueID(l);
        }
        if (serviceInfo == null) {
            this.log.log(1000000, "[DSITVTunerListener.correctInvalidService] Use channel name %1 as %2 not found in memory list", (Object)programInfo.channelName, (Object)programInfo.serviceInfo);
            programInfo.serviceInfo.name = programInfo.channelName;
            return programInfo;
        }
        programInfo.serviceInfo.sType = serviceInfo.sType;
        programInfo.serviceInfo.name = serviceInfo.name;
        programInfo.nowStartTime = new Time();
        programInfo.nowEndTime = new Time();
        this.log.log(1000000, "[TVTunerContentListener.correctInvalidService] Corrected UNDEF|DUMMY service: %1", (Object)programInfo);
        return programInfo;
    }
}

