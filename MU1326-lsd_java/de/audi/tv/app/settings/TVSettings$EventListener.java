/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.TVSettings$1;

class TVSettings$EventListener
extends TVEventDefaultListener {
    private volatile boolean isTvOnSdisActive = false;
    private volatile boolean isInStandby = true;
    private final /* synthetic */ TVSettings this$0;

    private TVSettings$EventListener(TVSettings tVSettings) {
        this.this$0 = tVSettings;
    }

    @Override
    public void onPowerStateStandby() {
        this.isInStandby = true;
        this.resetOnStandby();
    }

    @Override
    public void onPowerStateOn() {
        this.isInStandby = false;
    }

    @Override
    public void onDsiLockStateChanged(boolean bl) {
        TVSettings.access$1300(this.this$0).dsiLockStateChanged(bl);
    }

    @Override
    public void onSdisGotTvAudioFocus() {
        this.isTvOnSdisActive = true;
    }

    @Override
    public void onSdisLostTvAudioFocus() {
        this.isTvOnSdisActive = false;
        this.resetOnStandby();
    }

    private void resetOnStandby() {
        if (!this.isTvOnSdisActive && this.isInStandby) {
            TVSettings.access$600(this.this$0).onPowerStateStandby();
            TVSettings.access$500(this.this$0).onPowerStateStandby();
        }
    }

    /* synthetic */ TVSettings$EventListener(TVSettings tVSettings, TVSettings$1 tVSettings$1) {
        this(tVSettings);
    }
}

