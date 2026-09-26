/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.AudioFocusInfo;
import de.audi.tuner.app.ScanHandler;
import de.audi.tuner.app.ScanHandler$1;

class ScanHandler$AudioFocusInfoListener
extends AudioFocusInfo {
    private final /* synthetic */ ScanHandler this$0;

    private ScanHandler$AudioFocusInfoListener(ScanHandler scanHandler) {
        this.this$0 = scanHandler;
    }

    @Override
    public void audioFocusLost() {
        this.this$0.abortScan();
    }

    /* synthetic */ ScanHandler$AudioFocusInfoListener(ScanHandler scanHandler, ScanHandler$1 scanHandler$1) {
        this(scanHandler);
    }
}

