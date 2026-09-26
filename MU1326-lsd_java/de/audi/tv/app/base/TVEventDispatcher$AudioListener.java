/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;

class TVEventDispatcher$AudioListener
implements IAudioListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$AudioListener(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void onMuGotTvAudioFocus(boolean bl) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onMuGotTvAudioFocus]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onMuGotTvAudioFocus();
        }
    }

    @Override
    public void onMuLostTvAudioFocus() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onMuLostTvAudioFocus]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onMuLostTvAudioFocus();
        }
    }

    @Override
    public void onSdisGotTvAudioFocus() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onSdisGotTvAudioFocus]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onSdisGotTvAudioFocus();
        }
    }

    @Override
    public void onSdisLostTvAudioFocus() {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onSdisLostTvAudioFocus]");
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onSdisLostTvAudioFocus();
        }
    }

    @Override
    public void onMuteChange(boolean bl) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onMuteChange] muted: %1", bl);
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onMuteChange(bl);
        }
    }

    /* synthetic */ TVEventDispatcher$AudioListener(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

