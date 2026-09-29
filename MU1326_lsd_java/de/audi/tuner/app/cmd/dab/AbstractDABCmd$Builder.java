/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.IDABTuner;

public class AbstractDABCmd$Builder {
    private final LogChannel lc;
    private final IDABTuner dabTuner;
    private final DABTunerListener defaultDABListener;
    private final IFrameworkAccess framework;

    public AbstractDABCmd$Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IDABTuner iDABTuner, DABTunerListener dABTunerListener) {
        this.framework = iFrameworkAccess;
        this.lc = logChannel;
        this.dabTuner = iDABTuner;
        this.defaultDABListener = dABTunerListener;
    }

    static /* synthetic */ IFrameworkAccess access$000(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        return abstractDABCmd$Builder.framework;
    }

    static /* synthetic */ LogChannel access$100(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        return abstractDABCmd$Builder.lc;
    }

    static /* synthetic */ DABTunerListener access$200(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        return abstractDABCmd$Builder.defaultDABListener;
    }

    static /* synthetic */ IDABTuner access$300(AbstractDABCmd$Builder abstractDABCmd$Builder) {
        return abstractDABCmd$Builder.dabTuner;
    }
}

