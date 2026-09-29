/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.AbstractSlsSpeedManagerBase;
import de.audi.tuner.app.dab.DABDSIUpManager;

class DABDSIUpManager$SlsSpeedManager
extends AbstractSlsSpeedManagerBase {
    private final /* synthetic */ DABDSIUpManager this$0;

    public DABDSIUpManager$SlsSpeedManager(DABDSIUpManager dABDSIUpManager, LogChannel logChannel) {
        this.this$0 = dABDSIUpManager;
        super(logChannel);
    }

    @Override
    protected void update() {
        DABDSIUpManager.access$900(this.this$0);
    }
}

