/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.LastmodeHandler;

class LastmodeHandler$LastmodeData {
    private int lastMode;
    private int lastModeAudio;
    private final /* synthetic */ LastmodeHandler this$0;

    public LastmodeHandler$LastmodeData(LastmodeHandler lastmodeHandler, int n, int n2) {
        this.this$0 = lastmodeHandler;
        this.lastMode = n;
        this.lastModeAudio = n2;
    }

    public int getLastMode() {
        return this.lastMode;
    }

    public int getLastModeAudio() {
        return this.lastModeAudio;
    }
}

