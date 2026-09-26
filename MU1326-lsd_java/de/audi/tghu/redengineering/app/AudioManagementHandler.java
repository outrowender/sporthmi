/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.redengineering.app.EngineeringEnv;

public class AudioManagementHandler
implements HMIAudioServiceListener {
    private HMIAudioService hmiAudioService;
    private final EngineeringEnv engineeringEnv;
    public boolean hasAudioConnection;
    public boolean isAudible;

    public AudioManagementHandler(EngineeringEnv engineeringEnv) {
        this.engineeringEnv = engineeringEnv;
    }

    private final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    public final HMIAudioService getHmiAudioService() {
        return this.hmiAudioService;
    }

    public final void setHmiAudioService(HMIAudioService hMIAudioService) {
        this.hmiAudioService = hMIAudioService;
    }

    private final LogChannel getLogDSI() {
        return this.getEngineeringEnv().getLogDSI();
    }

    @Override
    public void pauseConnection(int n, int n2) {
    }

    @Override
    public void fadedIn(int n, int n2) {
    }

    @Override
    public void startConnection(int n, int n2) {
    }

    @Override
    public void stopConnection(int n, int n2) {
    }

    void requestAudio(int n, int n2) {
        this.getLogDSI().log(-2137614336, "[AudioMgmtDSIHandler] requestAudio for connection: %1 %2", (long)n, (long)n2);
        if (this.hmiAudioService != null) {
            if (n2 == -1) {
                if (this.getEngineeringEnv().isFrontMU()) {
                    this.hmiAudioService.requestConnection(n, 0);
                } else {
                    this.hmiAudioService.requestConnection(n, 3);
                    this.hmiAudioService.requestConnection(n, 4);
                }
            } else {
                this.hmiAudioService.requestConnection(n, n2);
            }
        } else {
            this.getLogDSI().log(-1601830656, "[AudioMgmtDSIHandler] ignore requestRequestAudio for connection: %1. No audio DSI! ", (long)n);
        }
    }

    void returnAudio(int n, int n2) {
        this.getLogDSI().log(-2137614336, "[AudioMgmtDSIHandler] releaseAudio for connection: %1", (long)n);
        if (this.hmiAudioService != null) {
            if (n2 == -1) {
                if (this.getEngineeringEnv().isFrontMU()) {
                    this.hmiAudioService.releaseConnection(n, 0);
                } else {
                    this.hmiAudioService.releaseConnection(n, 3);
                    this.hmiAudioService.releaseConnection(n, 4);
                }
            } else {
                this.hmiAudioService.releaseConnection(n, n2);
            }
        } else {
            this.getLogDSI().log(-1601830656, "[AudioMgmtDSIHandler] ignore releaseAudio for connection: %1. No audio DSI! ", (long)n);
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        if (this.getEngineeringEnv().isREMHMIactive() && bl && !this.getEngineeringEnv().isRebootToDownload()) {
            this.muteAudio("AudioMgmtDSIHandler.updateAMAvailable", -1);
        }
    }

    public void muteAudio(String string, int n) {
        this.getLogDSI().log(-2137614336, "[AudioMgmtDSIHandler] %1: mute audio", (Object)string);
        try {
            this.requestAudio(7, n);
        }
        catch (Exception exception) {
            this.getLogDSI().log(-1601830656, "[AudioMgmtDSIHandler] %1: mute audio failed!", (Object)string, (Throwable)exception);
        }
    }

    public final void unmuteAudio(String string, int n) {
        this.getLogDSI().log(-2137614336, "[AudioMgmtDSIHandler] %1: unmute audio", (Object)string);
        try {
            this.returnAudio(7, n);
        }
        catch (Exception exception) {
            this.getLogDSI().log(-1601830656, "[AudioMgmtDSIHandler] %1: unmute audio failed!", (Object)string, (Throwable)exception);
        }
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

