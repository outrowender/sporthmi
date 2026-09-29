/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IRadioAudioService;

public class AbstractAudioCmd$Builder {
    private final LogChannel lc;
    private final IRadioAudioService audioService;
    private final HMIAudioServiceListener defaultListener;
    private final IFrameworkAccess framework;

    public AbstractAudioCmd$Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IRadioAudioService iRadioAudioService, HMIAudioServiceListener hMIAudioServiceListener) {
        this.framework = iFrameworkAccess;
        this.lc = logChannel;
        this.audioService = iRadioAudioService;
        this.defaultListener = hMIAudioServiceListener;
    }

    static /* synthetic */ IFrameworkAccess access$000(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        return abstractAudioCmd$Builder.framework;
    }

    static /* synthetic */ LogChannel access$100(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        return abstractAudioCmd$Builder.lc;
    }

    static /* synthetic */ HMIAudioServiceListener access$200(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        return abstractAudioCmd$Builder.defaultListener;
    }

    static /* synthetic */ IRadioAudioService access$300(AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        return abstractAudioCmd$Builder.audioService;
    }
}

