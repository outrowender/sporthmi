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

    @Override
    public void requestConnection(int n) {
        this.log();
    }

    @Override
    public void requestConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void requestConnection(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void requestAndFadeToConnection(int n) {
        this.log();
    }

    @Override
    public void requestAndFadeToConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void releaseConnection(int n) {
        this.log();
    }

    @Override
    public void releaseConnection(int n, int n2) {
        this.log();
    }

    @Override
    public void releaseA2LSConnection() {
        this.log("releaseA2LSConnection");
    }

    @Override
    public void fadeToConnection(int n) {
        this.log();
    }

    @Override
    public void fadeToConnection(int n, int n2) {
        this.log();
    }

    @Override
    public int getActiveConnection(int n) {
        this.log();
        return -1;
    }

    @Override
    public int getActiveEntertainmentConnection(int n) {
        this.log();
        return -1;
    }

    @Override
    public int getStatus(int n) {
        this.log();
        return 5;
    }

    @Override
    public int getStatus(int n, int n2) {
        this.log();
        return 5;
    }

    @Override
    public boolean isActive(int n) {
        this.log();
        return false;
    }

    @Override
    public boolean isActive(int n, int n2) {
        this.log();
        return false;
    }

    @Override
    public void setVolumelock(int n, int n2, boolean bl, Object object) {
        this.log();
    }
}

