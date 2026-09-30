/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.dsi;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.TerminalMapper;
import de.audi.audio.AudioEnv;
import de.audi.audio.AudioListenerDistributor;
import de.audi.audio.DumpAudioProvider;
import de.audi.audio.InterAppHandler;
import de.audi.audio.dsi.DefaultDSIPowerManagementListener;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.store.ConnectionStore;
import de.audi.audio.store.VolumelockMap;
import de.audi.audio.volume.OnOffVolumeRange;
import de.audi.audio.volume.UserMuteRestorer;
import org.dsi.ifc.audio.DSIAudioManagementListener;

public class DSIAudioListenerImpl
extends DefaultDSIPowerManagementListener
implements DSIAudioManagementListener {
    private final AudioEnv env;
    private final UserMuteRestorer userMuteRestorer;
    private volatile IAudioListener[] internalAppListeners = new IAudioListener[0];
    private final InterAppHandler interAppHandler;
    private final AudioListenerDistributor distributor;
    private BaseAudioService autoFadeToClient;
    private OnOffVolumeRange.Controller controller;
    private volatile int amAvailable = 4;
    private boolean logFirstStartedEAC = true;
    private boolean logFirstFadedInEAC = true;
    private boolean logFirstPausedEAC = true;

    public DSIAudioListenerImpl(AudioEnv audioEnv, InterAppHandler interAppHandler, UserMuteRestorer userMuteRestorer) {
        this.env = audioEnv;
        this.interAppHandler = interAppHandler;
        this.userMuteRestorer = userMuteRestorer;
        this.distributor = new AudioListenerDistributor(audioEnv.lcMain);
    }

    public void registerAudioService(BaseAudioService baseAudioService) {
        this.autoFadeToClient = baseAudioService;
    }

    public void register(OnOffVolumeRange.Controller controller) {
        this.controller = controller;
    }

    public void setInternalListeners(IAudioListener[] iAudioListenerArray) {
        this.internalAppListeners = iAudioListenerArray;
    }

    public void register(HMIAudioServiceListener hMIAudioServiceListener, int n, String string) {
        this.env.lcMain.log(10000000, "[DSIAudioListenerImpl.register] listener:%1 client:%2", (Object)hMIAudioServiceListener, (Object)string);
        this.distributor.add(n, hMIAudioServiceListener);
        hMIAudioServiceListener.updateAMAvailable(this.amAvailable == 3);
    }

    public void deregisterHMIAudioServiceListener(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        this.env.lcMain.log(10000000, "[DSIAudioListenerImpl.deregisterHMIAudioServiceListener] client:%2, listener:%1", (Object)hMIAudioServiceListener, (long)n);
        this.distributor.remove(n, hMIAudioServiceListener);
    }

    public void fadedIn(int n, int n2) {
        if (this.logFirstFadedInEAC) {
            this.env.logStartupEvent("[AUDIO] faded-in EAC: " + n);
            this.logFirstFadedInEAC = false;
        }
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.fadedIn] AC:%1 AT:%2", (long)n, (long)n2);
        ConnectionStore.INSTANCE.setStatus(n, 0, n2);
        DumpAudioProvider.INSTANCE.putUpdate("fadedIn", n, n2);
        int n3 = this.toHmiTerminal(n2);
        this.distributor.callFadedIn(n, n3);
        this.informInternalAppListeners(n, 0, n3);
    }

    public void startConnection(int n, int n2) {
        if (this.logFirstStartedEAC && n != 3) {
            this.env.logStartupEvent("[AUDIO] started EAC: " + n);
            this.logFirstStartedEAC = false;
        }
        int n3 = this.toHmiTerminal(n2);
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.startConnection] AC:%1 AT:%2", (long)n, (long)n2);
        ConnectionStore.INSTANCE.setStatus(n, 2, n2);
        DumpAudioProvider.INSTANCE.putUpdate("startConnection", n, n2);
        this.distributor.callStartConnection(n, n3);
        if (ConnectionStore.INSTANCE.isAutoFadeToConnection(n, n2)) {
            this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.startConnection] automatic fadeIN AC:%1 ", (long)n);
            this.autoFadeToClient.fadeToConnection(n, n3);
        }
        this.informInternalAppListeners(n, 2, n3);
        if (this.isMmiOnTelActive(n, n2)) {
            this.env.lcDSI.log(100000, "[DSIAudioListenerImpl.startConnection] MMI_ON_TEL active -> fake active connection %1", (long)n);
            this.updateActiveConnection(n, n2, 1);
        }
    }

    public void pauseConnection(int n, int n2) {
        if (this.logFirstStartedEAC && this.logFirstPausedEAC) {
            this.env.logStartupEvent("[AUDIO] paused EAC: " + n);
            this.logFirstPausedEAC = false;
        }
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.pauseConnection] AC:%1 AT:%2", (long)n, (long)n2);
        ConnectionStore.INSTANCE.setStatus(n, 4, n2);
        DumpAudioProvider.INSTANCE.putUpdate("pauseConnection", n, n2);
        int n3 = this.toHmiTerminal(n2);
        this.distributor.callPauseConnection(n, n3);
        this.informInternalAppListeners(n, 4, n3);
    }

    public void stopConnection(int n, int n2) {
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.stopConnection] AC:%1 AT:%2", (long)n, (long)n2);
        if (ConnectionStore.INSTANCE.getStatus(n, n2) != 3) {
            ConnectionStore.INSTANCE.removeAutoFadeToConnection(n, n2);
        }
        ConnectionStore.INSTANCE.setStatus(n, 5, n2);
        DumpAudioProvider.INSTANCE.putUpdate("stopConnection", n, n2);
        int n3 = this.toHmiTerminal(n2);
        this.distributor.callStopConnection(n, n3);
        this.informInternalAppListeners(n, 5, n3);
    }

    public void errorConnection(int n, int n2, int n3) {
        this.env.lcDSI.log(10000, "<- [DSIAudioListenerImpl.errorConnection] AC:%1 AT:%2 error:%3", (long)n, (long)n2, (long)n3);
        ConnectionStore.INSTANCE.setStatus(n, 5, n2);
        DumpAudioProvider.INSTANCE.putUpdate("errorConnection", n, n2);
        int n4 = this.toHmiTerminal(n2);
        this.distributor.callErrorConnection(n, n4, n3);
        ConnectionStore.INSTANCE.removeAutoFadeToConnection(n, n2);
        this.informInternalAppListeners(n, 5, n4);
    }

    public void updateActiveConnection(int n, int n2, int n3) {
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.updateActiveConnection] AC:%1 AT:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (n3 != 1) {
            return;
        }
        ConnectionStore.INSTANCE.setActiveConnection(n, n2);
        DumpAudioProvider.INSTANCE.putUpdate("updateActiveConnection", n, n2);
        int n4 = TerminalMapper.toHmiTerminal(n2);
        this.env.getChoiceModel(n4, 9).setValue(n);
        this.controller.getRange(n4).audioStateChanged(n2);
        for (int i2 = 0; i2 < this.internalAppListeners.length; ++i2) {
            this.internalAppListeners[i2].updateActiveConnection(n, n4);
        }
        this.interAppHandler.updateActiveConnection(n, n4);
        if (this.env.isHigh() && n == 9) {
            this.env.lcDSI.log(1000000, "[DSIAudioListenerImpl.updateActiveConnection] Set ENT_SUPPRESSION as AEC (workaround for Harman)");
            this.updateActiveEntertainmentConnection(n, n2, n3);
        }
        this.env.lcMain.log(10000000, "<- [DSIAudioListenerImpl.updateActiveConnection] active connections on HT:%2 %1", (Object)ConnectionStore.INSTANCE.getConnectionsInUse(n2));
        int[] nArray = ConnectionStore.INSTANCE.getConnectionsInUse(n2);
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            int n5 = nArray[i3];
            this.env.lcMain.log(100000000, "<- [DSIAudioListenerImpl.updateActiveConnection] AC:%1, status:%2", (long)nArray[i3], (long)ConnectionStore.INSTANCE.getStatus(n5, n2));
        }
    }

    public void updateActiveEntertainmentConnection(int n, int n2, int n3) {
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.updateActiveEntertainmentConnection] AC:%1 AT:%2 (valid:%3)", (long)n, (long)n2, (long)n3);
        if (n3 != 1) {
            return;
        }
        switch (n) {
            case 0: {
                this.env.lcDSI.log(100000, "<- [DSIAudioListenerImpl.updateActiveEntertainmentConnection] Ignore invalid AEC:%1", (long)n);
                return;
            }
            case 82: 
            case 87: 
            case 91: 
            case 95: {
                this.env.lcDSI.log(1000000, "<- [DSIAudioListenerImpl.updateActiveEntertainmentConnection] AC:%1 IGNORED (HQ ringing)", (long)n);
                return;
            }
        }
        ConnectionStore.INSTANCE.setActiveEntertainmentConnection(n, n2);
        DumpAudioProvider.INSTANCE.putUpdate("updateActiveEntertainmentConnection", n, n2);
        int n4 = TerminalMapper.toHmiTerminal(n2);
        this.env.getChoiceModel(n4, 12).setValue(n);
        this.controller.getRange(n4).audioStateChanged(n2);
        for (int i2 = 0; i2 < this.internalAppListeners.length; ++i2) {
            this.internalAppListeners[i2].updateActiveEntertainmentConnection(n, n4);
        }
        this.interAppHandler.updateActiveEntertainmentConnection(n, n4);
    }

    public void responseVolumelock(int n, int n2, boolean bl) {
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.responseVolumelock] active:%3 AC:%1 AT:%2", (long)n, (long)n2, bl);
        VolumelockMap.INSTANCE.setStatus(n, n2, bl);
        this.distributor.callUpdateVolumeLock(n, n2, bl);
        int n3 = TerminalMapper.toHmiTerminal(n2);
        this.controller.getRange(n3).audioStateChanged(n2);
    }

    public void updateAMAvailable(int n, int n2, int n3) {
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.updateAMAvailable] available:%1 sink:%2 valid:%3", (long)n, (long)n2, (long)n3);
        if (n3 != 1) {
            return;
        }
        this.amAvailable = n;
        boolean bl = n == 3;
        this.env.logStartupEvent("[AUDIO] aMAvailable:" + bl);
        DumpAudioProvider.INSTANCE.putAMAvailable(n);
        this.env.getChoiceModel(0, 30).setValue(bl ? 1 : 0);
        this.userMuteRestorer.updateAMAvailable(bl);
        if (!bl) {
            ConnectionStore.INSTANCE.clear();
        }
        for (int i2 = 0; i2 < this.internalAppListeners.length; ++i2) {
            this.internalAppListeners[i2].updateAMAvailable(bl);
        }
        this.distributor.callUpdateAMAvailable(6, bl);
        this.distributor.callUpdateAMAvailable(2, bl);
        this.distributor.callUpdateAMAvailable(4, bl);
        int[] nArray = this.distributor.getClientIDs();
        block4: for (int i3 = 0; i3 < nArray.length; ++i3) {
            int n4 = nArray[i3];
            this.env.lcDSI.log(10000000, "[DSIAudioListenerImpl.updateAMAvailable] clientIdIndex: %1, clientId: %2", (long)i3, (long)n4);
            switch (n4) {
                case 0: 
                case 1: 
                case 2: 
                case 4: 
                case 6: 
                case 25: {
                    continue block4;
                }
                default: {
                    this.distributor.callUpdateAMAvailable(n4, bl);
                }
            }
        }
        this.distributor.callUpdateAMAvailable(0, bl);
        this.distributor.callUpdateAMAvailable(1, bl);
        this.distributor.callUpdateAMAvailable(25, bl);
    }

    public void asyncException(int n, String string, int n2) {
        this.env.lcDSI.log(10000, "<- [DSIAudioListenerImpl.asyncException] msg:%1 code:%2 type:%3", (Object)string, (long)n, (long)n2);
    }

    private int toHmiTerminal(int n) {
        return TerminalMapper.toHmiTerminal(n);
    }

    private boolean isMmiOnTelActive(int n, int n2) {
        if (ConnectionStore.INSTANCE.getStatus(3, n2) != 5) {
            if (n == 102) {
                return false;
            }
            if (AudioConnection.contains(AudioConnection.PHONE_RINGING, n)) {
                return true;
            }
            if (n == 100) {
                return false;
            }
            if (AudioConnection.contains(AudioConnection.PHONE_CALL, n)) {
                return true;
            }
            if (AudioConnection.contains(AudioConnection.CONNECTED_GATEWAY_CONNS, n)) {
                return true;
            }
        }
        return false;
    }

    private void informInternalAppListeners(int n, int n2, int n3) {
        for (int i2 = 0; i2 < this.internalAppListeners.length; ++i2) {
            this.internalAppListeners[i2].updateConnStatus(n, n2, n3);
        }
    }

    public void updateTStandbyPopup(boolean bl, int n) {
        this.env.lcDSI.log(10000000, "<- [DSIAudioListenerImpl.updateTStandbyPopup] showPopup: %1, valid: %2", bl, (long)n);
        if (bl && n == 1) {
            this.controller.getRange(0).standbyPopupActive(bl);
        }
    }
}

