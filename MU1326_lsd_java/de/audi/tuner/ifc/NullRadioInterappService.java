/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IRadioInterappService;

public class NullRadioInterappService
extends NullService
implements IRadioInterappService {
    public NullRadioInterappService(LogChannel logChannel) {
        super(logChannel, "IRadioInterappService");
    }

    public void tuneStation(long l) {
        this.log();
    }

    public void selectBand(int n) {
        this.log();
    }
}

