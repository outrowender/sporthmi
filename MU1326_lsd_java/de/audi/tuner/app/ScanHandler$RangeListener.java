/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.tuner.app.ScanHandler;
import de.audi.tuner.app.ScanHandler$1;

class ScanHandler$RangeListener
extends DefaultRangeListener {
    private final /* synthetic */ ScanHandler this$0;

    private ScanHandler$RangeListener(ScanHandler scanHandler) {
        this.this$0 = scanHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        if (n != -326631168) {
            this.this$0.abortScan();
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        if (n == -326631168) {
            this.this$0.abortScan();
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100626: {
                this.this$0.scanButtonPressed();
                ScanHandler.access$300(this.this$0).getButtonModel(n).fireEvent(n3);
                break;
            }
        }
    }

    /* synthetic */ ScanHandler$RangeListener(ScanHandler scanHandler, ScanHandler$1 scanHandler$1) {
        this(scanHandler);
    }
}

