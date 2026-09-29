/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.TMInterAppHandler;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.atip.utils.reactive.observables.Observables$Combinator;

class TMInterAppHandler$3
implements Observables$Combinator {
    private final /* synthetic */ TMInterAppHandler this$0;

    TMInterAppHandler$3(TMInterAppHandler tMInterAppHandler) {
        this.this$0 = tMInterAppHandler;
    }

    public Boolean combine(AudioConnectionState audioConnectionState, AudioConnectionState audioConnectionState2) {
        return new Boolean(audioConnectionState.isAudible() || audioConnectionState2.isAudible());
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2) {
        return this.combine((AudioConnectionState)object, (AudioConnectionState)object2);
    }
}

