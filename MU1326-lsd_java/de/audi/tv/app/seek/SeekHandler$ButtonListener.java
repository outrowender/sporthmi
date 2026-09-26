/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.seek.SeekHandler;
import de.audi.tv.app.seek.SeekHandler$1;

class SeekHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ SeekHandler this$0;

    private SeekHandler$ButtonListener(SeekHandler seekHandler) {
        this.this$0 = seekHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 2600110: {
                SeekHandler.access$100(this.this$0).log(-2137614336, "[SeekHandler.ButtonListener.keyPressed] seek upwards (frequenzy wise)");
                SeekHandler.access$200(this.this$0).selectNextService(1);
                break;
            }
            case 2600111: {
                SeekHandler.access$100(this.this$0).log(-2137614336, "[SeekHandler.ButtonListener.keyPressed] seek downwards (frequenzy wise)");
                SeekHandler.access$200(this.this$0).selectNextService(2);
                break;
            }
        }
    }

    /* synthetic */ SeekHandler$ButtonListener(SeekHandler seekHandler, SeekHandler$1 seekHandler$1) {
        this(seekHandler);
    }
}

