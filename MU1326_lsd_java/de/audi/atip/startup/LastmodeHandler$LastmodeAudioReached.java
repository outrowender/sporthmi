/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.LastmodeHandler;
import de.audi.atip.startup.LastmodeHandler$1;

class LastmodeHandler$LastmodeAudioReached
implements Runnable {
    private final int lmAudio;
    private final int terminalID;
    private final /* synthetic */ LastmodeHandler this$0;

    public final String toString() {
        return new StringBuffer().append("LastmodeAudioReached: lastmodeAudio: ").append(this.lmAudio).toString();
    }

    private LastmodeHandler$LastmodeAudioReached(LastmodeHandler lastmodeHandler, int n, int n2) {
        this.this$0 = lastmodeHandler;
        this.lmAudio = n;
        this.terminalID = n2;
    }

    @Override
    public final void run() {
        this.this$0.activateLastmodeAudio(this.lmAudio, this.terminalID);
    }

    /* synthetic */ LastmodeHandler$LastmodeAudioReached(LastmodeHandler lastmodeHandler, int n, int n2, LastmodeHandler$1 lastmodeHandler$1) {
        this(lastmodeHandler, n, n2);
    }
}

