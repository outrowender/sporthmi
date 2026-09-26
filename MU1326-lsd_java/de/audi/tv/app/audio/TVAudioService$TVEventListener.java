/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.tv.app.audio.TVAudioService;
import de.audi.tv.app.audio.TVAudioService$1;
import de.audi.tv.app.base.TVEventDefaultListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

class TVAudioService$TVEventListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVAudioService this$0;

    private TVAudioService$TVEventListener(TVAudioService tVAudioService) {
        this.this$0 = tVAudioService;
    }

    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
        TVAudioService.access$700(this.this$0).log(-2137614336, "[TVAudioService.onSelectedServiceDebounced]");
        TVAudioService.access$802(this.this$0, true);
        if (TVAudioService.access$900(this.this$0) == 2) {
            TVAudioService.access$1000(this.this$0, 27, 0);
        }
        if (TVAudioService.access$1100(this.this$0) == 2) {
            TVAudioService.access$1000(this.this$0, 307, 3);
        }
    }

    @Override
    public void onMuGotTvAudioFocus() {
        if (!TVAudioService.access$200(this.this$0) && !TVAudioService.access$600(this.this$0)) {
            this.this$0.requestConnection(9, 0);
        }
    }

    @Override
    public void onSdisGotTvAudioFocus() {
    }

    @Override
    public void onChildLockEnabled() {
        TVAudioService.access$700(this.this$0).log(-2137614336, "[TVAudioService.onChildLockEnabled] requesting child lock mute connection");
        TVAudioService.access$1200(this.this$0).requestConnection(141, 0);
    }

    @Override
    public void onChildLockDisabled() {
        TVAudioService.access$700(this.this$0).log(-2137614336, "[TVAudioService.onChildLockDisabled] releasing child lock mute connection");
        TVAudioService.access$1200(this.this$0).releaseConnection(141, 0);
    }

    /* synthetic */ TVAudioService$TVEventListener(TVAudioService tVAudioService, TVAudioService$1 tVAudioService$1) {
        this(tVAudioService);
    }
}

