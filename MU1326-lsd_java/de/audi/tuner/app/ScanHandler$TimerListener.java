/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.ScanHandler;
import de.audi.tuner.app.ScanProgressTimer;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;

class ScanHandler$TimerListener
extends DefaultTimerListener {
    private int index = -1;
    private TunerObjectContainer[] stations;
    private final ScanProgressTimer scanTimer;
    private final /* synthetic */ ScanHandler this$0;

    public ScanHandler$TimerListener(ScanHandler scanHandler) {
        this.this$0 = scanHandler;
        this.scanTimer = new ScanProgressTimer(ScanHandler.access$300(scanHandler), this);
    }

    public void speedUp() {
        if (this.scanTimer.cancel()) {
            this.tuneNext();
        }
    }

    public void startScan(TunerObjectContainer[] tunerObjectContainerArray) {
        this.stations = tunerObjectContainerArray;
        this.index = 0;
        TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainerArray[0], 0);
        this.scanTimer.restart();
        ScanHandler.access$400(this.this$0).updateVeto(0, true);
        this.this$0.propagateupdatedScanStatus(true);
    }

    public void stopScan() {
        this.scanTimer.cancel();
        this.index = -1;
        this.stations = null;
        ScanHandler.access$500(this.this$0);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.tuneNext();
    }

    private void tuneNext() {
        ++this.index;
        TunerProxyManager.getInstance().prepareAndTune(this.stations[this.index], 0);
        if (this.index < this.stations.length - 1) {
            this.scanTimer.restart();
        } else {
            this.index = -1;
            this.stations = null;
            ScanHandler.access$500(this.this$0);
        }
    }
}

