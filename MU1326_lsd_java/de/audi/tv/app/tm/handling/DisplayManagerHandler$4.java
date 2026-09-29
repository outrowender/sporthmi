/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.tv.app.tm.handling.DisplayManagerHandler;

class DisplayManagerHandler$4
implements Runnable {
    private final /* synthetic */ int val$displayId;
    private final /* synthetic */ DisplayManagerHandler this$0;

    DisplayManagerHandler$4(DisplayManagerHandler displayManagerHandler, int n) {
        this.this$0 = displayManagerHandler;
        this.val$displayId = n;
    }

    @Override
    public void run() {
        DisplayManagerHandler.access$300((DisplayManagerHandler)this.this$0).framework.getMsgDistrib().sendMessage(202);
        DisplayManagerHandler.access$400(this.this$0).startComponent(this.val$displayId);
        DisplayManagerHandler.access$300((DisplayManagerHandler)this.this$0).lcDSI.log(-2137614336, "[DisplayManagerHandler.onRelevantDataChanged] -> TV_TUNER_ACTIVATED!!");
    }
}

