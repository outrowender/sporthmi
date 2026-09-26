/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd$Builder;
import de.audi.tuner.ifc.IRadioAudioService;

public abstract class AbstractAudioCmd
extends AbstractRadioCmd
implements HMIAudioServiceListener {
    private final HMIAudioServiceListener defaultListener;
    protected final IRadioAudioService audio;
    public final int connection;
    final int terminalID;

    protected AbstractAudioCmd(int n, int n2, AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        super(AbstractAudioCmd$Builder.access$000(abstractAudioCmd$Builder), AbstractAudioCmd$Builder.access$100(abstractAudioCmd$Builder), 0);
        this.connection = n;
        this.terminalID = n2;
        this.defaultListener = AbstractAudioCmd$Builder.access$200(abstractAudioCmd$Builder);
        this.audio = AbstractAudioCmd$Builder.access$300(abstractAudioCmd$Builder);
    }

    protected AbstractAudioCmd(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        this(0, -2, abstractAudioCmd$Builder);
    }

    protected AbstractAudioCmd(int n, AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        this(0, n, abstractAudioCmd$Builder);
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.defaultListener.stopConnection(n, n2);
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.defaultListener.pauseConnection(n, n2);
    }

    @Override
    public void startConnection(int n, int n2) {
        this.defaultListener.startConnection(n, n2);
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.defaultListener.errorConnection(n, n2, n3);
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.defaultListener.fadedIn(n, n2);
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.defaultListener.updateAMAvailable(bl);
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

