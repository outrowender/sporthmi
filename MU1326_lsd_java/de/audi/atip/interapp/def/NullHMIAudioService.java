/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullHMIAudioService
extends NullService
implements HMIAudioService {
    public NullHMIAudioService(LogChannel logChannel) {
        super(logChannel, "HMIAudioService");
    }

    public NullHMIAudioService(LogChannel logChannel, int n) {
        super(logChannel, n, "HMIAudioService");
    }

    public void requestConnection(int n) {
        this.log();
    }

    public void requestConnection(int n, int n2) {
        this.log();
    }

    public void requestConnection(int n, int n2, int n3) {
        this.log();
    }

    public void requestAndFadeToConnection(int n) {
        this.log();
    }

    public void requestAndFadeToConnection(int n, int n2) {
        this.log();
    }

    public void releaseConnection(int n) {
        this.log();
    }

    public void releaseConnection(int n, int n2) {
        this.log();
    }

    public void releaseA2LSConnection() {
        this.log("releaseA2LSConnection");
    }

    public void fadeToConnection(int n) {
        this.log();
    }

    public void fadeToConnection(int n, int n2) {
        this.log();
    }

    public int getActiveConnection(int n) {
        this.log();
        return -1;
    }

    public int getActiveEntertainmentConnection(int n) {
        this.log();
        return -1;
    }

    public int getStatus(int n) {
        this.log();
        return 5;
    }

    public int getStatus(int n, int n2) {
        this.log();
        return 5;
    }

    public boolean isActive(int n) {
        this.log();
        return false;
    }

    public boolean isActive(int n, int n2) {
        this.log();
        return false;
    }

    public void setVolumelock(int n, int n2, boolean bl, Object object) {
        this.log();
    }
}

