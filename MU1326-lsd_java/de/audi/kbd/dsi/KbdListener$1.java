/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.kbd.dsi.KbdListener;

class KbdListener$1
implements Runnable {
    private final /* synthetic */ int val$keyState;
    private final /* synthetic */ long val$timeStamp;
    private final /* synthetic */ KbdListener this$0;

    KbdListener$1(KbdListener kbdListener, int n, long l) {
        this.this$0 = kbdListener;
        this.val$keyState = n;
        this.val$timeStamp = l;
    }

    @Override
    public void run() {
        KbdListener.access$100(this.this$0).mfwArrowKeyPressed(this.val$keyState, this.val$timeStamp);
    }
}

