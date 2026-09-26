/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.ifc.UnifiedTunerListener;

public class AbstractUnifiedCmd$Builder {
    private final LogChannel lc;
    private final IUnifiedTuner unifiedTuner;
    private final UnifiedTunerListener defaultUnifiedListener;
    private final IFrameworkAccess framework;

    public AbstractUnifiedCmd$Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IUnifiedTuner iUnifiedTuner, UnifiedTunerListener unifiedTunerListener) {
        this.framework = iFrameworkAccess;
        this.lc = logChannel;
        this.unifiedTuner = iUnifiedTuner;
        this.defaultUnifiedListener = unifiedTunerListener;
    }

    static /* synthetic */ IFrameworkAccess access$000(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        return abstractUnifiedCmd$Builder.framework;
    }

    static /* synthetic */ LogChannel access$100(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        return abstractUnifiedCmd$Builder.lc;
    }

    static /* synthetic */ UnifiedTunerListener access$200(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        return abstractUnifiedCmd$Builder.defaultUnifiedListener;
    }

    static /* synthetic */ IUnifiedTuner access$300(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        return abstractUnifiedCmd$Builder.unifiedTuner;
    }
}

