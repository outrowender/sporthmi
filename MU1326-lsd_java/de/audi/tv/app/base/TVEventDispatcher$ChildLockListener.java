/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;
import de.audi.tv.app.settings.parental.IChildLockListener;

class TVEventDispatcher$ChildLockListener
implements IChildLockListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$ChildLockListener(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void onChildLockEnabled() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onChildLockEnabled]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onChildLockEnabled();
        }
    }

    @Override
    public void onChildLockDisabled() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onChildLockDisabled]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onChildLockDisabled();
        }
    }

    @Override
    public void parentalLevelSettingChanged(int n) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.parentalLevelSettingChanged]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).parentalLevelSettingChanged(n);
        }
    }

    /* synthetic */ TVEventDispatcher$ChildLockListener(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

