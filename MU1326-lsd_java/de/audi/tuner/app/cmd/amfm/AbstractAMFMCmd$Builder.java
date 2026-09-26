/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.IAMFMTuner;

public class AbstractAMFMCmd$Builder {
    private final LogChannel lc;
    private final IAMFMTuner tuner;
    private final AMFMTunerListener defaultListener;
    private final IFrameworkAccess framework;

    public AbstractAMFMCmd$Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IAMFMTuner iAMFMTuner, AMFMTunerListener aMFMTunerListener) {
        this.framework = iFrameworkAccess;
        this.lc = logChannel;
        this.tuner = iAMFMTuner;
        this.defaultListener = aMFMTunerListener;
    }

    static /* synthetic */ IFrameworkAccess access$000(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        return abstractAMFMCmd$Builder.framework;
    }

    static /* synthetic */ LogChannel access$100(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        return abstractAMFMCmd$Builder.lc;
    }

    static /* synthetic */ AMFMTunerListener access$200(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        return abstractAMFMCmd$Builder.defaultListener;
    }

    static /* synthetic */ IAMFMTuner access$300(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        return abstractAMFMCmd$Builder.tuner;
    }
}

