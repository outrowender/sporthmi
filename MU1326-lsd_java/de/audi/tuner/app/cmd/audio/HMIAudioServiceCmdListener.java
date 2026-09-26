/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.IRadioCmdManager;

public class HMIAudioServiceCmdListener
implements HMIAudioServiceListener {
    private final IRadioCmdManager cmdListManager;
    private final LogChannel lc;

    public HMIAudioServiceCmdListener(LogChannel logChannel, IRadioCmdManager iRadioCmdManager) {
        this.lc = logChannel;
        this.cmdListManager = iRadioCmdManager;
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.lc.log(-2137614336, "[HMIAudioServiceCmdListener.updateAMAvailable] available:%1", bl);
        try {
            this.cmdListManager.getActiveAudioCmd().updateAMAvailable(bl);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[HMIAudioServiceCmdListener.updateAMAvailable]", (Throwable)exception);
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.lc.log(-2137614336, "[HMIAudioServiceCmdListener.stopConnection] AC:%1 HT:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveAudioCmd().stopConnection(n, n2);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[HMIAudioServiceCmdListener.stopConnection]", (Throwable)exception);
        }
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.lc.log(-2137614336, "[HMIAudioServiceCmdListener.pauseConnection] AC:%1 HT:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveAudioCmd().pauseConnection(n, n2);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[HMIAudioServiceCmdListener.pauseConnection]", (Throwable)exception);
        }
    }

    @Override
    public void startConnection(int n, int n2) {
        this.lc.log(-2137614336, "[HMIAudioServiceCmdListener.startConnection] AC:%1 HT:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveAudioCmd().startConnection(n, n2);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[HMIAudioServiceCmdListener.startConnection]", (Throwable)exception);
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.lc.log(10000, "[HMIAudioServiceCmdListener.errorConnection] AC:%1 HT:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveAudioCmd().errorConnection(n, n2, n3);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[HMIAudioServiceCmdListener.errorConnection]", (Throwable)exception);
        }
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.lc.log(-2137614336, "[HMIAudioServiceCmdListener.fadedIn] AC:%1 HT:%2", (long)n, (long)n2);
        try {
            this.cmdListManager.getActiveAudioCmd().fadedIn(n, n2);
        }
        catch (Exception exception) {
            this.lc.log(10000, "[HMIAudioServiceCmdListener.fadedIn]", (Throwable)exception);
        }
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.lc.log(-2137614336, "[HMIAudioServiceCmdListener.updateVolumeLock] AC:%1 HT:%2 VL:%3", (long)n, (long)n2, bl);
    }
}

