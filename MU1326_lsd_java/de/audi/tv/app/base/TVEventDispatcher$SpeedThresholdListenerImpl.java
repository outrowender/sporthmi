/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.base.TVEventDispatcher$Properties
 */
package de.audi.tv.app.base;

import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;

class TVEventDispatcher$SpeedThresholdListenerImpl
implements SpeedThresholdListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$SpeedThresholdListenerImpl(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.exceedsUpperThreshold]");
        TVEventDispatcher.Properties.access$1500((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(true));
    }

    @Override
    public void belowLowerThreshold(int n) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.belowLowerThreshold]");
        TVEventDispatcher.Properties.access$1500((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(false));
    }

    /* synthetic */ TVEventDispatcher$SpeedThresholdListenerImpl(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

