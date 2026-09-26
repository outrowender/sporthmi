/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSettingsEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker;

class ExlapExlapRestrictionModeWorker$1
extends ExlapSettingsEmptyListener {
    private final /* synthetic */ ExlapExlapRestrictionModeWorker this$0;

    ExlapExlapRestrictionModeWorker$1(ExlapExlapRestrictionModeWorker exlapExlapRestrictionModeWorker) {
        this.this$0 = exlapExlapRestrictionModeWorker;
    }

    @Override
    public void updateExlapRestrictionMode(ExlapRestrictionModeContainer exlapRestrictionModeContainer) {
        ExlapExlapRestrictionModeWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSettingsEmptyListener#updateExlapRestrictionMode] received new container: %1", (Object)exlapRestrictionModeContainer);
        ExlapExlapRestrictionModeWorker.access$102(this.this$0, exlapRestrictionModeContainer);
        if (ExlapExlapRestrictionModeWorker.access$200(this.this$0) != -1) {
            ExlapExlapRestrictionModeWorker.access$300(this.this$0);
        }
    }
}

