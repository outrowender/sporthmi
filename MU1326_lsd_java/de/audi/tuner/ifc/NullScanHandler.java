/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IScanHandler;

public class NullScanHandler
extends NullService
implements IScanHandler {
    public NullScanHandler(LogChannel logChannel) {
        super(logChannel, "NullScanHandler");
    }

    public void abortScan() {
        this.log();
    }

    public boolean handleHkPrevHkNext(boolean bl) {
        this.log();
        return false;
    }

    public boolean isScanActive() {
        this.log();
        return false;
    }
}

