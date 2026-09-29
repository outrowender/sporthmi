/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.base.TVEventDispatcher$Properties
 */
package de.audi.tv.app.base;

import de.audi.atip.power.PowerEventListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;

class TVEventDispatcher$PowerEventDispatcher
implements PowerEventListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$PowerEventDispatcher(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.notifyPowerListenerOnEnterState]");
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.notifyPowerListenerOnExitState]");
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.notifyPowerTriggerAction] trigger: %1", (long)n);
        if (n2 != 0) {
            return;
        }
        switch (n) {
            case 2: {
                for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
                    TVEventDispatcher.Properties.access$1300((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(false));
                    ITVEventListener iTVEventListener = (ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2);
                    iTVEventListener.onPowerStateStandby();
                }
                break;
            }
            case 1: {
                for (int i3 = 0; i3 < TVEventDispatcher.access$1000(this.this$0).size(); ++i3) {
                    TVEventDispatcher.Properties.access$1300((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(true));
                    ITVEventListener iTVEventListener = (ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i3);
                    iTVEventListener.onPowerStateOn();
                }
                break;
            }
        }
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.updateClampState] clampS %1, clamp15 %2", bl, bl2);
        TVEventDispatcher.Properties.access$1400((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(bl2));
    }

    /* synthetic */ TVEventDispatcher$PowerEventDispatcher(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

