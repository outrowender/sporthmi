/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.atip.utils.generics.Function;

class TMInterAppHandler$5
implements Function {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$5(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public Boolean apply(AudioConnectionState audioConnectionState) {
        return new Boolean(audioConnectionState.isAudible());
    }

    @Override
    public /* synthetic */ Object apply(Object object) {
        return this.apply((AudioConnectionState)object);
    }
}

