/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.ifc.IRadioAudioService;

public abstract class AbstractAudioCmd
extends AbstractRadioCmd
implements HMIAudioServiceListener {
    private final HMIAudioServiceListener defaultListener;
    protected final IRadioAudioService audio;
    public final int connection;
    final int terminalID;

    protected AbstractAudioCmd(int n, int n2, Builder builder) {
        super(builder.framework, builder.lc, 0);
        this.connection = n;
        this.terminalID = n2;
        this.defaultListener = builder.defaultListener;
        this.audio = builder.audioService;
    }

    protected AbstractAudioCmd(Builder builder) {
        this(0, -2, builder);
    }

    protected AbstractAudioCmd(int n, Builder builder) {
        this(0, n, builder);
    }

    public void stopConnection(int n, int n2) {
        this.defaultListener.stopConnection(n, n2);
    }

    public void pauseConnection(int n, int n2) {
        this.defaultListener.pauseConnection(n, n2);
    }

    public void startConnection(int n, int n2) {
        this.defaultListener.startConnection(n, n2);
    }

    public void errorConnection(int n, int n2, int n3) {
        this.defaultListener.errorConnection(n, n2, n3);
    }

    public void fadedIn(int n, int n2) {
        this.defaultListener.fadedIn(n, n2);
    }

    public void updateAMAvailable(boolean bl) {
        this.defaultListener.updateAMAvailable(bl);
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    public static class Builder {
        private final LogChannel lc;
        private final IRadioAudioService audioService;
        private final HMIAudioServiceListener defaultListener;
        private final IFrameworkAccess framework;

        public Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IRadioAudioService iRadioAudioService, HMIAudioServiceListener hMIAudioServiceListener) {
            this.framework = iFrameworkAccess;
            this.lc = logChannel;
            this.audioService = iRadioAudioService;
            this.defaultListener = hMIAudioServiceListener;
        }
    }
}

