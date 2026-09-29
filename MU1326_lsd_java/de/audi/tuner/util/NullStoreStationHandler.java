/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.ifc.IStoreStationHandler;

public class NullStoreStationHandler
extends NullService
implements IStoreStationHandler {
    public NullStoreStationHandler(LogChannel logChannel) {
        super(logChannel, "IStoreStationHandler");
    }

    @Override
    public boolean prepareStore(int n, TunerObjectContainer tunerObjectContainer) {
        this.log("prepareStore");
        return false;
    }

    @Override
    public int toggleStore(TunerObjectContainer tunerObjectContainer) {
        this.log("toggleStore");
        return 0;
    }

    @Override
    public boolean isStored(TunerObjectContainer tunerObjectContainer) {
        this.log("isStored");
        return false;
    }
}

