/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.services;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.TerminalMapper;
import de.audi.audio.AudioEnv;
import de.audi.audio.DumpAudioProvider;
import de.audi.audio.store.ConnectionStore;
import de.esolutions.fw.util.commons.Buffer;

public class BaseAudioService
implements HMIAudioService {
    private static final int DEFAULT_HMI_TERMINAL = 0;
    private static final int DEFAULT_GROUP_ID = 0;
    public static final String[] CONN_STATUS = new String[7];
    protected final AudioEnv env;
    public final String name;

    public BaseAudioService(AudioEnv audioEnv, String string) {
        this.env = audioEnv;
        this.name = string;
    }

    public void setService(Object object) {
    }

    public void fadeToConnection(int n) {
        this.fadeToConnection(n, 0);
    }

    public void fadeToConnection(int n, int n2) {
        int n3 = TerminalMapper.toAudioTerminal(n2);
        if (AudioConnection.contains(AudioConnection.SDIS_ENT_CONNECTIONS, n)) {
            this.env.lcMain.log(10000000, "[%1] [BaseAudioService.fadeToConnection] AC: %2 is not fadeable", (Object)this.name, (long)n);
            return;
        }
        if (this.env.lcMain.isDebug()) {
            Buffer buffer = this.toDebug(n, n3, n, n2);
            this.env.lcMain.log(10000000, "[%1] [BaseAudioService.fadeToConnection] %2", (Object)this.name, (Object)buffer);
        }
        try {
            int n4 = ConnectionStore.INSTANCE.getStatus(n, n3);
            switch (n4) {
                case 2: 
                case 3: {
                    this.env.lcDSI.log(10000000, "-> [%1] [DSIAudioManagement.fadeToConnection] AC:%2 AT:%3", (Object)this.name, (long)n, (long)n3);
                    ConnectionStore.INSTANCE.setStatus(n, 1, n3);
                    DumpAudioProvider.INSTANCE.putCall("fadeToConnection", n, n3);
                    this.env.getDSIAudio().fadeToConnection(n, n3);
                    break;
                }
                case 0: 
                case 1: {
                    if (this.env.lcMain.isDebug()) {
                        Buffer buffer = this.toDebug(n, n3, n, n2);
                        this.env.lcMain.log(10000000, "[%1] [DSIAudioManagement.fadeToConnection] IGNORED status:%3 %2", (Object)this.name, (Object)buffer, (Object)CONN_STATUS[n4]);
                    }
                    break;
                }
                default: {
                    Buffer buffer = this.toDebug(n, n3, n, n2);
                    this.env.lcMain.log(1000000, "[%1] [DSIAudioManagement.fadeToConnection] IGNORED status:%3 %2", (Object)this.name, (Object)buffer, (Object)CONN_STATUS[n4]);
                    break;
                }
            }
        }
        catch (Exception exception) {
            ConnectionStore.INSTANCE.setStatus(n, 5, n3);
            this.handleException("fadeToConnection", exception);
        }
    }

    public void releaseConnection(int n) {
        this.releaseConnection(n, 0);
    }

    public void releaseConnection(int n, int n2) {
        int n3 = TerminalMapper.toAudioTerminal(n2);
        if (this.env.lcMain.isDebug()) {
            Buffer buffer = this.toDebug(n, n3, n, n2);
            this.env.lcMain.log(10000000, "[%1] [BaseAudioService.releaseConnection] %2", (Object)this.name, (Object)buffer);
        }
        if (AudioConnection.contains(AudioConnection.MUTE_RELEASE_CONNECTIONS, n)) {
            this.callReleaseConnection(n, n3);
            return;
        }
        int n4 = ConnectionStore.INSTANCE.getStatus(n, n3);
        switch (n4) {
            case 5: 
            case 6: {
                if (!this.env.lcMain.isDebug()) break;
                Buffer buffer = this.toDebug(n, n3, n, n2);
                this.env.lcMain.log(10000000, "[%1] [DSIAudioManagement.releaseConnection] IGNORED status:%3 %2", (Object)this.name, (Object)buffer, (long)n4);
                break;
            }
            default: {
                this.callReleaseConnection(n, n3);
            }
        }
    }

    public void releaseA2LSConnection() {
        if (ConnectionStore.INSTANCE.isInUse(308, 0)) {
            this.env.lcMain.log(10000000, "[%1] [BaseAudioService.releaseA2LSConnection] A2LS connection: %2 released", (Object)this.name, 308L);
            int n = TerminalMapper.toAudioTerminal(0);
            this.callReleaseConnection(308, n);
        }
    }

    public void requestConnection(int n) {
        this.requestConnection(n, 0, 0);
    }

    public void requestConnection(int n, int n2) {
        this.requestConnection(n, n2, 0);
    }

    public void requestConnection(int n, int n2, int n3) {
        int n4 = TerminalMapper.toAudioTerminal(n2);
        if (this.env.lcMain.isDebug()) {
            Buffer buffer = this.toDebug(n, n4, n, n2);
            this.env.lcMain.log(10000000, "[%1] [BaseAudioService.requestConnection] %2", (Object)this.name, (Object)buffer);
        }
        int n5 = ConnectionStore.INSTANCE.getStatus(n, n4);
        switch (n5) {
            case 3: 
            case 5: 
            case 6: {
                this.callRequestConnection(n, n4, n3);
                break;
            }
            default: {
                if (!this.env.lcMain.isDebug()) break;
                Buffer buffer = this.toDebug(n, n4, n3);
                this.env.lcMain.log(1000000, "[%1] DSIAudioManagement.requestConnection() --> IGNORED status:%3 %2", (Object)this.name, (Object)buffer, (long)n5);
            }
        }
    }

    public void requestAndFadeToConnection(int n) {
        this.requestAndFadeToConnection(n, 0);
    }

    public void requestAndFadeToConnection(int n, int n2) {
        int n3;
        int n4 = TerminalMapper.toAudioTerminal(n2);
        if (this.env.lcMain.isDebug()) {
            Buffer buffer = this.toDebug(n, n4, n, n2);
            this.env.lcMain.log(10000000, "[%1] [BaseAudioService.requestAndFadeToConnection] %2", (Object)this.name, (Object)buffer);
        }
        if ((n3 = ConnectionStore.INSTANCE.getStatus(n, n4)) == 5 || n3 == 6) {
            ConnectionStore.INSTANCE.addAutoFadeToConnection(n, n4);
        }
        this.requestConnection(n, n2);
    }

    public int getActiveConnection(int n) {
        int n2 = TerminalMapper.toAudioTerminal(n);
        return ConnectionStore.INSTANCE.getActiveConnection(n2);
    }

    public int getActiveEntertainmentConnection(int n) {
        int n2 = TerminalMapper.toAudioTerminal(n);
        return ConnectionStore.INSTANCE.getActiveEntertainmentConnection(n2);
    }

    public int getStatus(int n) {
        return this.getStatus(n, 0);
    }

    public int getStatus(int n, int n2) {
        int n3 = TerminalMapper.toAudioTerminal(n2);
        return ConnectionStore.INSTANCE.getStatus(n, n3);
    }

    public boolean isActive(int n) {
        return this.isActive(n, 0);
    }

    public boolean isActive(int n, int n2) {
        int n3 = TerminalMapper.toAudioTerminal(n2);
        return ConnectionStore.INSTANCE.isActive(n, n3);
    }

    public void setVolumelock(int n, int n2, boolean bl, Object object) {
        int n3 = TerminalMapper.toAudioTerminal(n2);
        Buffer buffer = new Buffer();
        buffer.append("active:").append(bl);
        buffer.append(" AC:").append(n);
        buffer.append(" - ").append(object);
        this.env.lcDSI.log(10000000, "-> [%1] [DSIAudioManagement.setVolumelock] %2", (Object)this.name, (Object)buffer);
        this.env.getDSIAudio().setVolumelock(n, n3, bl);
    }

    public final void callRequestConnection(int n, int n2, int n3) {
        if (this.env.lcDSI.isDebug()) {
            Buffer buffer = this.toDebug(n, n2, n3);
            this.env.lcDSI.log(10000000, "-> [%1] [DSIAudioManagement.requestConnection] %2", (Object)this.name, (Object)buffer);
        }
        ConnectionStore.INSTANCE.setStatus(n, 3, n2);
        DumpAudioProvider.INSTANCE.putCall("requestConnection", n, n2);
        this.env.getDSIAudio().requestConnection(n, n2, n3);
    }

    public void callReleaseConnection(int n, int n2) {
        this.env.lcDSI.log(10000000, "-> [%1] [DSIAudioManagement.releaseConnection] AC:%2 AT:%3", (Object)this.name, (long)n, (long)n2);
        ConnectionStore.INSTANCE.setStatus(n, 6, n2);
        DumpAudioProvider.INSTANCE.putCall("releaseConnection", n, n2);
        this.env.getDSIAudio().releaseConnection(n, n2);
        ConnectionStore.INSTANCE.removeAutoFadeToConnection(n, n2);
    }

    final Buffer toDebug(int n, int n2, int n3) {
        Buffer buffer = new Buffer(50);
        buffer.append("AC:").append(n);
        buffer.append(" AT:").append(n2);
        buffer.append(" group:").append(n3);
        return buffer;
    }

    final Buffer toDebug(int n, int n2, int n3, int n4) {
        Buffer buffer = new Buffer(50);
        buffer.append("AC:").append(n);
        buffer.append(" AT:").append(n2);
        buffer.append(" HC:").append(n3);
        buffer.append(" HT:").append(n4);
        return buffer;
    }

    private void handleException(String string, Exception exception) {
        if (this.env.getDSIAudio() == null && exception instanceof NullPointerException) {
            this.env.lcDSI.log(10000, "[%1] HMIAudioServiceImpl.%2() No DSIAudioManagement registered!", (Object)this.name, (Object)string);
        } else {
            this.env.lcDSI.log(10000, "[%1] HMIAudioServiceImpl.%2() failed!", (Object)this.name, (Object)string);
            this.env.lcDSI.log(10000, "Exception: ", (Throwable)exception);
        }
    }

    static {
        BaseAudioService.CONN_STATUS[0] = "FADEDIN";
        BaseAudioService.CONN_STATUS[1] = "FADEIN_REQUESTED";
        BaseAudioService.CONN_STATUS[2] = "STARTED";
        BaseAudioService.CONN_STATUS[3] = "START_REQUESTED";
        BaseAudioService.CONN_STATUS[5] = "STOPPED";
        BaseAudioService.CONN_STATUS[6] = "STOP_REQUESTED";
        BaseAudioService.CONN_STATUS[4] = "PAUSED";
    }
}

