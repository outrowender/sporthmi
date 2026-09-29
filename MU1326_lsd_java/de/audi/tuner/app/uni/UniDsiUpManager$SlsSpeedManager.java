/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.AbstractSlsSpeedManagerBase;
import de.audi.tuner.app.uni.UniDsiUpManager;

class UniDsiUpManager$SlsSpeedManager
extends AbstractSlsSpeedManagerBase {
    private final /* synthetic */ UniDsiUpManager this$0;

    public UniDsiUpManager$SlsSpeedManager(UniDsiUpManager uniDsiUpManager, LogChannel logChannel) {
        this.this$0 = uniDsiUpManager;
        super(logChannel);
    }

    @Override
    protected void update() {
        UniDsiUpManager.access$400(this.this$0);
    }
}

