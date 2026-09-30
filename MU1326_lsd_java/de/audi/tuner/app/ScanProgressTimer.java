/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.esolutions.fw.util.commons.Buffer;

class ScanProgressTimer {
    private final TimerListener receiver;
    private final MyTimerListener timer;

    ScanProgressTimer(TunerModels tunerModels, TimerListener timerListener) {
        this.timer = new MyTimerListener(tunerModels.getRangeModel(100511), tunerModels.getLabelModel(100919), tunerModels.getLabelModel(100918));
        this.receiver = timerListener;
    }

    void restart() {
        this.timer.start();
    }

    public boolean cancel() {
        return this.timer.cancel();
    }

    private class MyTimerListener
    extends DefaultTimerListener {
        private final int periods = Utilities.isPGen1OrBentley() ? 40 : 1;
        private static final int PLAY_TIME = 9600;
        private final Timer timer = new Timer("tickTimer", 9600 / this.periods, false, this);
        private int count = 0;
        private final RangeModelApp progress;
        private final String timePrefix;
        private final LabelModelApp currentScanTime;
        private final LabelModelApp endScanTime;

        public MyTimerListener(RangeModelApp rangeModelApp, LabelModelApp labelModelApp, LabelModelApp labelModelApp2) {
            this.timePrefix = "00:";
            this.progress = rangeModelApp;
            this.currentScanTime = labelModelApp;
            this.endScanTime = labelModelApp2;
            this.endScanTime.setText(this.getTimeTextForSeconds((int)Math.round(9.6)));
            rangeModelApp.setLimits(0, this.periods, 1);
        }

        public void start() {
            this.count = 0;
            this.progress.setValue(0);
            this.currentScanTime.setText(this.getTimeTextForSeconds(0L));
            this.timer.restart();
        }

        public boolean cancel() {
            this.currentScanTime.setText(this.getTimeTextForSeconds(0L));
            return this.timer.cancel();
        }

        public void fireTimer(Timer timer) {
            this.progress.setValue(++this.count);
            long l = (long)((double)this.count * (9600.0 / (double)this.periods / 1000.0));
            String string = this.getTimeTextForSeconds(l);
            this.currentScanTime.setText(string);
            if (this.count >= this.periods) {
                timer.cancel();
                ScanProgressTimer.this.receiver.fireTimer(null);
            }
        }

        private String getTimeTextForSeconds(long l) {
            String string = l < 10L ? "0" : "";
            return new Buffer("00:").append(string).append(l).toString();
        }
    }
}

