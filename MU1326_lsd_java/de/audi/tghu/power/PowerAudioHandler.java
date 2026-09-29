/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.power;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.power.PowerManager;

final class PowerAudioHandler
implements HMIAudioServiceListener {
    private final PowerManager powerManager;
    private final LogChannel lc;
    private static final String LOGCLASS;
    private boolean muteTillFirstScreen = true;
    private volatile HMIAudioService dsiAudio;

    PowerAudioHandler(PowerManager powerManager) {
        this.powerManager = powerManager;
        this.lc = powerManager.getFramework().getLogChannel("Fw.Power.Audio");
    }

    public void enableAudioHandling() {
        this.lc.log(-2137614336, "[%1.enableAudioHandling]", (Object)"PowerAudioHandler");
        this.muteTillFirstScreen = false;
    }

    public void setAudioDeviceService(HMIAudioService hMIAudioService) {
        this.lc.log(-2137614336, "[%1.setAudioDeviceService] audioService:%2", (Object)"PowerAudioHandler", (Object)hMIAudioService);
        this.dsiAudio = hMIAudioService;
    }

    private int getMuteConnectionByTerminal(int n) {
        int n2 = 3;
        switch (n) {
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        return n2;
    }

    public void mute(int n) {
        this.lc.log(-2137614336, "[%1.mute] HT:%2", (Object)"PowerAudioHandler", (long)n);
        if (this.dsiAudio != null) {
            this.lc.log(-2137614336, "[%1.requestConnection] AC:%2, HT:%3", (Object)"PowerAudioHandler", (long)this.getMuteConnectionByTerminal(n), (long)n);
            this.dsiAudio.requestConnection(this.getMuteConnectionByTerminal(n), n);
        }
    }

    public void demute(int n) {
        this.lc.log(-2137614336, "[%1.demute] HT:%2", (Object)"PowerAudioHandler", (long)n);
        if (this.muteTillFirstScreen) {
            this.lc.log(-2137614336, "[%1.demute] Request mute connection if the first screen is not yet available.", (Object)"PowerAudioHandler");
            return;
        }
        if (this.dsiAudio != null) {
            this.lc.log(-2137614336, "[%1.releaseConnection] AC:%2, HT:%3", (Object)"PowerAudioHandler", (long)this.getMuteConnectionByTerminal(n), (long)n);
            this.dsiAudio.releaseConnection(this.getMuteConnectionByTerminal(n), n);
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        String string = new StringBuffer().append("AC:").append(n).append(", HT:").append(n2).append(", errorCode:").append(n3).toString();
        this.lc.log(10000, "[%1.errorConnection] %2", (Object)"PowerAudioHandler", (Object)string);
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.lc.log(-2137614336, "[%1.fadeIn] AC:%2, HT:%3", (Object)"PowerAudioHandler", (long)n, (long)n2);
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.lc.log(-2137614336, "[%1.pauseConnection] AC:%2, HT:%3", (Object)"PowerAudioHandler", (long)n, (long)n2);
    }

    @Override
    public void startConnection(int n, int n2) {
        this.lc.log(-2137614336, "[%1.startConnection] AC:%2, HT:%3", (Object)"PowerAudioHandler", (long)n, (long)n2);
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.lc.log(-2137614336, "[%1.stopConnection] AC:%2, HT:%3", (Object)"PowerAudioHandler", (long)n, (long)n2);
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.lc.log(-2137614336, "[%1.updateAMAvailable] available:%2", (Object)"PowerAudioHandler", (Object)(bl ? "true" : "false"));
        if (bl) {
            this.powerManager.getPwrCmdFactory().setAMAvailableCmd();
        }
    }

    public void updateAMAvailableFromFSMStandby() {
        this.lc.log(-2137614336, "[%1.updateAMAvailableFromFSMStandby] request MUTE_STANDBY", (Object)"PowerAudioHandler");
        if (this.dsiAudio == null) {
            this.lc.log(10000, "[%1.updateAMAvailableFromFSMStandby] dsiAudio == null", (Object)"PowerAudioHandler");
            return;
        }
        if (this.powerManager.IS_FRONT_MU) {
            this.dsiAudio.requestConnection(3, 0);
        } else {
            this.dsiAudio.requestConnection(3, 3);
            this.dsiAudio.requestConnection(3, 4);
        }
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.lc.log(-2137614336, "[%1.updateVolumeLock] VL:%3", (Object)"PowerAudioHandler", (Object)(bl ? "true" : "false"));
    }
}

