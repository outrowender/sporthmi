/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;

public class HMIAudioServiceLoggingDecorator
implements HMIAudioService {
    private final HMIAudioService wrappee;
    private final LogChannel lc;
    private final int level;

    public HMIAudioServiceLoggingDecorator(HMIAudioService hMIAudioService, LogChannel logChannel, int n) {
        this.wrappee = hMIAudioService;
        this.lc = logChannel;
        this.level = n;
    }

    @Override
    public void requestConnection(int n) {
        this.lc.log(this.level, "-> [HMIAudioService.requestConnection] %1", (long)n);
        this.wrappee.requestConnection(n);
    }

    @Override
    public void requestConnection(int n, int n2) {
        this.lc.log(this.level, "-> [HMIAudioService.requestConnection] %1, terminal %2", (long)n, (long)n2);
        this.wrappee.requestConnection(n, n2);
    }

    @Override
    public void requestConnection(int n, int n2, int n3) {
        this.lc.log(this.level, "-> [HMIAudioService.requestConnection] %1, terminal %2, group %3", (long)n, (long)n2, (long)n3);
        this.wrappee.requestConnection(n, n2, n3);
    }

    @Override
    public void requestAndFadeToConnection(int n) {
        this.lc.log(this.level, "-> deprecated! [HMIAudioService.requestAndFadeToConnection] %1", (long)n);
        this.wrappee.requestAndFadeToConnection(n);
    }

    @Override
    public void requestAndFadeToConnection(int n, int n2) {
        this.lc.log(this.level, "-> deprecated! [HMIAudioService.requestConnection] %1, terminal %2", (long)n, (long)n2);
        this.wrappee.requestAndFadeToConnection(n, n2);
    }

    @Override
    public void releaseConnection(int n) {
        this.lc.log(this.level, "-> [HMIAudioService.releaseConnection] %1", (long)n);
        this.wrappee.releaseConnection(n);
    }

    @Override
    public void releaseConnection(int n, int n2) {
        this.lc.log(this.level, "-> [HMIAudioService.releaseConnection] %1, terminal %2", (long)n, (long)n2);
        this.wrappee.releaseConnection(n, n2);
    }

    @Override
    public void releaseA2LSConnection() {
        this.lc.log(this.level, "-> [HMIAudioService.releaseA2LSConnection]");
        this.wrappee.releaseA2LSConnection();
    }

    @Override
    public void fadeToConnection(int n) {
        this.lc.log(this.level, "-> [HMIAudioService.fadeToConnection] %1", (long)n);
        this.wrappee.fadeToConnection(n);
    }

    @Override
    public void fadeToConnection(int n, int n2) {
        this.lc.log(this.level, "-> [HMIAudioService.fadeToConnection] %1, terminal %2", (long)n, (long)n2);
        this.wrappee.fadeToConnection(n, n2);
    }

    @Override
    public int getActiveConnection(int n) {
        int n2 = this.wrappee.getActiveConnection(n);
        this.lc.log(this.level, "<-> [HMIAudioService.getActiveConnection] hmiTerminal %1, returns %2", (long)n, (long)n2);
        return n2;
    }

    @Override
    public int getActiveEntertainmentConnection(int n) {
        int n2 = this.wrappee.getActiveEntertainmentConnection(n);
        this.lc.log(this.level, "<-> [HMIAudioService.getActiveEntertainmentConnection] hmiTerminal %1, returns %2", (long)n, (long)n2);
        return n2;
    }

    @Override
    public int getStatus(int n) {
        int n2 = this.wrappee.getStatus(n);
        this.lc.log(this.level, "<-> [HMIAudioService.getStatus] connection %1, returns %2", (long)n, (long)n2);
        return n2;
    }

    @Override
    public int getStatus(int n, int n2) {
        int n3 = this.wrappee.getStatus(n, n2);
        this.lc.log(this.level, "<-> [HMIAudioService.getStatus] connection %1, hmiTerminal %2, returns %3", (long)n, (long)n2, (long)n3);
        return n3;
    }

    @Override
    public boolean isActive(int n) {
        boolean bl = this.wrappee.isActive(n);
        this.lc.log(this.level, "<-> [HMIAudioService.isActive] connection %1, returns %2", (Object)new Integer(n), (Object)new Boolean(bl));
        return bl;
    }

    @Override
    public boolean isActive(int n, int n2) {
        boolean bl = this.wrappee.isActive(n, n2);
        this.lc.log(this.level, "<-> [HMIAudioService.isActive] connection %1, terminal %2, returns %3", (long)n, (long)n2, bl);
        return bl;
    }

    @Override
    public void setVolumelock(int n, int n2, boolean bl, Object object) {
        this.lc.log(this.level, "-> [HMIAudioService.setVolumelock] %1 for %2 on terminal %3 because %4", (Object)(bl ? "Active" : "Inactive"), (Object)new Integer(n), (Object)new Integer(n2), object);
        this.wrappee.setVolumelock(n, n2, bl, object);
    }
}

