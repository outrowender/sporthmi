/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.atip.power.PowerEventListener;
import de.audi.audio.earlysound.ReadinessSound;
import de.audi.audio.earlysound.ReadinessSound$1;

class ReadinessSound$RSClampStateListener
implements PowerEventListener {
    private boolean clamp15 = true;
    private final /* synthetic */ ReadinessSound this$0;

    private ReadinessSound$RSClampStateListener(ReadinessSound readinessSound) {
        this.this$0 = readinessSound;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        ReadinessSound.access$200(this.this$0).log(-2137614336, "[ReadinessSound.updateClampState] clamp15: %1 -> %2", this.clamp15, bl2);
        if (!ReadinessSound.access$700(this.this$0)) {
            ReadinessSound.access$200(this.this$0).log(-2137614336, "[ReadinessSound.updateClampState] ReadinessSound not coded -> do nothing");
            return;
        }
        if (this.clamp15 == bl2) {
            return;
        }
        this.clamp15 = bl2;
        if (!this.clamp15) {
            ReadinessSound.access$800(this.this$0).releaseConnection(48);
            return;
        }
        if (ReadinessSound.access$1300(this.this$0)) {
            ReadinessSound.access$1400(this.this$0);
        }
    }

    /* synthetic */ ReadinessSound$RSClampStateListener(ReadinessSound readinessSound, ReadinessSound$1 readinessSound$1) {
        this(readinessSound);
    }
}

