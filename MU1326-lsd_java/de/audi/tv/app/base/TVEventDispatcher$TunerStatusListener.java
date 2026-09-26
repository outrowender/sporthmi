/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.base.TVEventDispatcher$Properties
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.ITunerStatusListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;

class TVEventDispatcher$TunerStatusListener
implements ITunerStatusListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$TunerStatusListener(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void onTunerAvailable() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onTunerAvailable]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onTunerAvailable();
        }
    }

    @Override
    public void onTunerUnavailable() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onTunerUnavailable]");
        TVEventDispatcher.Properties.access$1200((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(true));
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onTunerUnavailable();
        }
    }

    @Override
    public void onEsmEntered() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onEsmEntered]");
        TVEventDispatcher.Properties.access$1200((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(true));
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onEsmEntered();
        }
    }

    @Override
    public void onEsmLeft() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onEsmLeft]");
        TVEventDispatcher.Properties.access$1200((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(false));
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onEsmLeft();
        }
    }

    @Override
    public void onDsiLockStateChanged(boolean bl) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.dsiLockStateChanged] is DSI locked: %1", bl);
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onDsiLockStateChanged(bl);
        }
    }

    @Override
    public void onHighTemperatureShutdown() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onHighTemperatureShutdown]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onHighTemperatureShutdown();
        }
    }

    /* synthetic */ TVEventDispatcher$TunerStatusListener(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

