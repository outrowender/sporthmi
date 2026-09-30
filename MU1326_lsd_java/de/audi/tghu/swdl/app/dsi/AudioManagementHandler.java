/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;

public class AudioManagementHandler
implements HMIAudioServiceListener {
    private static final String CLASSNAME = "[AudioMgmtDSIHandler]";
    private HMIAudioService hmiAudioService;
    private final SwdlEnv swdlEnv;
    public boolean hasAudioConnection;
    public boolean isAudible;

    public AudioManagementHandler(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    public final HMIAudioService getHmiAudioService() {
        return this.hmiAudioService;
    }

    public final void setHmiAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
    }

    private final LogChannel getLogDSI() {
        return this.getSwdlEnv().getLogDSI();
    }

    public void pauseConnection(int n, int n2) {
    }

    public void fadedIn(int n, int n2) {
    }

    public void startConnection(int n, int n2) {
    }

    public void stopConnection(int n, int n2) {
    }

    void requestAudio(int n, int n2) {
        this.getLogDSI().log(10000000, "%1 requestAudio for connection: %2 %3", (Object)CLASSNAME, (long)n, (long)n2);
        if (this.hmiAudioService != null) {
            if (n2 == -1) {
                if (this.getSwdlEnv().isFrontMU()) {
                    this.hmiAudioService.requestConnection(n, 0);
                } else {
                    this.hmiAudioService.requestConnection(n, 3);
                    this.hmiAudioService.requestConnection(n, 4);
                }
            } else {
                this.hmiAudioService.requestConnection(n, n2);
            }
        } else {
            this.getLogDSI().log(100000, "%1 ignore requestRequestAudio for connection: %2. No audio DSI! ", (Object)CLASSNAME, (long)n);
        }
    }

    void returnAudio(int n, int n2) {
        this.getLogDSI().log(10000000, "%1 releaseAudio for connection: %2 ", (Object)CLASSNAME, (long)n);
        if (this.hmiAudioService != null) {
            if (n2 == -1) {
                if (this.getSwdlEnv().isFrontMU()) {
                    this.hmiAudioService.releaseConnection(n, 0);
                } else {
                    this.hmiAudioService.releaseConnection(n, 3);
                    this.hmiAudioService.releaseConnection(n, 4);
                }
            } else {
                this.hmiAudioService.releaseConnection(n, n2);
            }
        } else {
            this.getLogDSI().log(100000, "%1 ignore releaseAudio for connection: %2. No audio DSI! ", (Object)CLASSNAME, (long)n);
        }
    }

    public void errorConnection(int n, int n2, int n3) {
    }

    public void updateAMAvailable(boolean bl) {
        if (this.getSwdlEnv().isSwdlHMIActive() && bl && !this.getSwdlEnv().isRebootToDownload()) {
            this.muteAudio("AudioMgmtDSIHandler.updateAMAvailable", -1);
        }
    }

    public void muteAudio(String string, int n) {
        this.getLogDSI().log(10000000, "%1 %2: mute audio", (Object)CLASSNAME, (Object)string);
        try {
            this.requestAudio(7, n);
        }
        catch (Exception exception) {
            this.getLogDSI().log(100000, "%1 %2: mute audio failed! %3", (Object)CLASSNAME, (Object)string, (Object)exception);
        }
    }

    public final void unmuteAudio(String string, int n) {
        this.getLogDSI().log(10000000, "%1 %2: unmute audio", (Object)CLASSNAME, (Object)string);
        try {
            this.returnAudio(7, n);
        }
        catch (Exception exception) {
            this.getLogDSI().log(100000, "%1 %2: unmute audio failed! %3", (Object)CLASSNAME, (Object)string, (Object)exception);
        }
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

