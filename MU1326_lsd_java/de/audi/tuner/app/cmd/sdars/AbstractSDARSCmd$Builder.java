/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.SDARSTunerListener;

public class AbstractSDARSCmd$Builder {
    private final LogChannel lc;
    private final ISDARSTuner sdarsTuner;
    private final SDARSTunerListener defaultSDARSListener;
    private final IFrameworkAccess framework;

    public AbstractSDARSCmd$Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, ISDARSTuner iSDARSTuner, SDARSTunerListener sDARSTunerListener) {
        this.framework = iFrameworkAccess;
        this.lc = logChannel;
        this.sdarsTuner = iSDARSTuner;
        this.defaultSDARSListener = sDARSTunerListener;
    }

    static /* synthetic */ IFrameworkAccess access$000(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        return abstractSDARSCmd$Builder.framework;
    }

    static /* synthetic */ LogChannel access$100(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        return abstractSDARSCmd$Builder.lc;
    }

    static /* synthetic */ SDARSTunerListener access$200(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        return abstractSDARSCmd$Builder.defaultSDARSListener;
    }

    static /* synthetic */ ISDARSTuner access$300(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        return abstractSDARSCmd$Builder.sdarsTuner;
    }
}

