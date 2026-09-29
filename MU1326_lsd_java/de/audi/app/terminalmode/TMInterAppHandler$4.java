/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.utils.generics.Consumer;

class TMInterAppHandler$4
implements Consumer {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$4(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public void accept(Boolean bl) {
        this.this$0.notifyAudioUsage(TMInterAppHandler.access$200(this.this$0), new TerminalModeAudioUsage(1, bl));
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

