/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.base.TvTunerStateTracker$1;

class TvTunerStateTracker$AudioFocusListener
implements IAudioListener {
    private final /* synthetic */ TvTunerStateTracker this$0;

    private TvTunerStateTracker$AudioFocusListener(TvTunerStateTracker tvTunerStateTracker) {
        this.this$0 = tvTunerStateTracker;
    }

    @Override
    public void onMuGotTvAudioFocus(boolean bl) {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(2, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override
    public void onMuLostTvAudioFocus() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(3);
    }

    @Override
    public void onSdisGotTvAudioFocus() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(4);
    }

    @Override
    public void onSdisLostTvAudioFocus() {
        TvTunerStateTracker.access$600(this.this$0).sendMessage(5);
    }

    @Override
    public void onMuteChange(boolean bl) {
    }

    /* synthetic */ TvTunerStateTracker$AudioFocusListener(TvTunerStateTracker tvTunerStateTracker, TvTunerStateTracker$1 tvTunerStateTracker$1) {
        this(tvTunerStateTracker);
    }
}

