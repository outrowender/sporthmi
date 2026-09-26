/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.tv.app.audio.IAudioListener;
import de.audi.tv.app.audio.TVAudioService;
import de.audi.tv.app.audio.TVAudioService$1;

class TVAudioService$AudioConnectionService
implements IAudioListener {
    private final /* synthetic */ TVAudioService this$0;

    private TVAudioService$AudioConnectionService(TVAudioService tVAudioService) {
        this.this$0 = tVAudioService;
    }

    @Override
    public void onMuGotTvAudioFocus(boolean bl) {
        TVAudioService.access$202(this.this$0, true);
        this.this$0.requestConnection(27, 0);
        if (!bl && TVAudioService.access$300(this.this$0)) {
            TVAudioService.access$400(this.this$0);
        }
        TVAudioService.access$302(this.this$0, false);
    }

    @Override
    public void onMuLostTvAudioFocus() {
        TVAudioService.access$202(this.this$0, false);
        TVAudioService.access$500(this.this$0, 27, 0);
        TVAudioService.access$302(this.this$0, false);
    }

    @Override
    public void onSdisGotTvAudioFocus() {
        TVAudioService.access$602(this.this$0, true);
        this.this$0.requestConnection(307, 3);
    }

    @Override
    public void onSdisLostTvAudioFocus() {
        TVAudioService.access$602(this.this$0, false);
        TVAudioService.access$500(this.this$0, 307, 3);
    }

    @Override
    public void onMuteChange(boolean bl) {
    }

    /* synthetic */ TVAudioService$AudioConnectionService(TVAudioService tVAudioService, TVAudioService$1 tVAudioService$1) {
        this(tVAudioService);
    }
}

