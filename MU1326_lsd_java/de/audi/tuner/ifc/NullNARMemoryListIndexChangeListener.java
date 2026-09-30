/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.RadioPresetHandler;
import de.audi.tuner.app.TunerObjectContainer;

public class NullNARMemoryListIndexChangeListener
extends NullService
implements RadioPresetHandler.INARMemoryListIndexChangeListener {
    public NullNARMemoryListIndexChangeListener(LogChannel logChannel) {
        super(logChannel, "INARMemoryListIndexChangeListener");
    }

    public void memoryListPresetIndexChanged(int n, TunerObjectContainer tunerObjectContainer) {
        this.log("memoryListPresetIndexChanged");
    }
}

