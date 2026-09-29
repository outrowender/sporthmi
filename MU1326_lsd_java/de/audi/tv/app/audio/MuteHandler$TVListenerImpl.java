/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.tv.app.audio.MuteHandler;
import de.audi.tv.app.audio.MuteHandler$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.ProgramInfo;

class MuteHandler$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ MuteHandler this$0;

    private MuteHandler$TVListenerImpl(MuteHandler muteHandler) {
        this.this$0 = muteHandler;
    }

    @Override
    public void updateSelectedSource(int n) {
        MuteHandler.access$202(this.this$0, n);
        MuteHandler.access$300(this.this$0);
    }

    @Override
    public void updateSelectedService(ProgramInfo programInfo) {
        MuteHandler.access$402(this.this$0, programInfo.casStatus);
        MuteHandler.access$300(this.this$0);
    }

    @Override
    public void updateMuteState(int n) {
        MuteHandler.access$500(this.this$0, n);
    }

    /* synthetic */ MuteHandler$TVListenerImpl(MuteHandler muteHandler, MuteHandler$1 muteHandler$1) {
        this(muteHandler);
    }
}

