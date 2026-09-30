/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IScanHandler;
import org.dsi.ifc.radio.WavebandInfo;

class FunctionWheelHandler {
    public final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();
    public final AMFMDsiDownInfo dsiDownListener = new DsiDownListener();
    public final TunerActionProxyListener actionProxyListener = new TunerActionProxyListenerExt();
    private final Timer tuneTimer;
    private final Timer afBlockTimer;
    private final Timer updateBlockTimer;
    private final Object mutex = new Object();
    private long position;
    private long result;
    private WavebandInfo bandInfo;
    private final Logger logger;
    private final TunerModels models;
    private final AMFMTuner amFmTuner;
    private final RangeModelApp range;
    private final LabelModelApp freqLabel;
    private AMFMStation blockedStation;
    private AMFMStation activeStation = new AMFMStation();
    private final IScanHandler scanHandler;
    private AMFMStation afJumpStation;

    FunctionWheelHandler(TunerBasics tunerBasics, AMFMTuner aMFMTuner, RangeModelApp rangeModelApp, int n, IScanHandler iScanHandler, LabelModelApp labelModelApp) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.amFmTuner = aMFMTuner;
        this.bandInfo = new WavebandInfo(n, 0L, 0L, 0L, 0L);
        this.scanHandler = iScanHandler;
        TimerListener timerListener = new TimerListener();
        this.tuneTimer = new Timer(new StringBuffer().append("tuneTimer").append(this.bandInfo.waveband).toString(), 5, this.logger.timer, timerListener, 100L, true);
        this.afBlockTimer = new Timer("AF-block", 30000L, true, timerListener);
        this.updateBlockTimer = new Timer(new StringBuffer().append("updateBlockTimer").append(this.bandInfo.waveband).toString(), 5, this.logger.timer, timerListener, 2000L, true);
        this.range = rangeModelApp;
        this.range.setStatus(1);
        this.freqLabel = labelModelApp;
        this.range.setRangeListener(new MyRangeListener());
    }

    public long getPosition() {
        return this.position;
    }

    private void setResultName() {
        this.freqLabel.setText(FunctionWheelHandler.constructFrequencyString(this.bandInfo.waveband, this.position));
        this.models.getChoiceModel(100425).setValue(0);
        this.models.getLabelModel(100933).setText("");
        this.range.setValue((int)this.position);
    }

    private void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            if (wavebandInfoArray[i2].waveband != this.bandInfo.waveband) continue;
            this.bandInfo = wavebandInfoArray[i2];
            this.range.setLimits((int)this.bandInfo.lowerLimit, (int)this.bandInfo.upperLimit, (int)this.bandInfo.stepWidth);
            this.range.setValue((int)this.position);
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void update(AMFMStation aMFMStation) {
        if (this.bandInfo.waveband == aMFMStation.waveband) {
            this.logger.amfmDeepDebug.log(10000000, "[FWH.update] %1", (Object)aMFMStation);
            Object object = this.mutex;
            synchronized (object) {
                if (this.updateBlockTimer.isRunning()) {
                    this.logger.amfmDeepDebug.log(100000000, "[FWH.update] store blocked");
                    this.blockedStation = aMFMStation;
                    this.activeStation = aMFMStation;
                } else {
                    if (this.checkAfJump(aMFMStation) && this.afBlockTimer.isRunning()) {
                        this.afJumpStation = aMFMStation;
                        this.logger.amfmDeepDebug.log(100000000, "[FWH.update] store AF-jump");
                        return;
                    }
                    this.logger.amfmDeepDebug.log(100000000, "[FWH.update] delete AF-jump");
                    this.afJumpStation = null;
                    this.activeStation = aMFMStation;
                    this.position = aMFMStation.frequency;
                    this.range.setValue((int)this.position);
                    this.freqLabel.setText(FunctionWheelHandler.constructFrequencyString(this.bandInfo.waveband, this.position));
                }
            }
        }
    }

    private boolean checkAfJump(AMFMStation aMFMStation) {
        return this.activeStation.pi > 0 && aMFMStation.pi == this.activeStation.pi && aMFMStation.frequency != this.activeStation.frequency;
    }

    private static String constructFrequencyString(int n, long l) {
        return n == 1 ? Utilities.kHzToMHz(l) : String.valueOf(l);
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(AMFMStation aMFMStation) {
            FunctionWheelHandler.this.update(aMFMStation);
        }

        public void updateSeekStation(AMFMStation aMFMStation) {
            FunctionWheelHandler.this.update(aMFMStation);
        }

        public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
            FunctionWheelHandler.this.updateWavebandInfoList(wavebandInfoArray);
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            ((FunctionWheelHandler)FunctionWheelHandler.this).logger.amfmDeepDebug.log(10000000, "[FWH.fireTimer] %1", (Object)timer.getName());
            if (timer.equals(FunctionWheelHandler.this.tuneTimer)) {
                AMFMStation aMFMStation = new AMFMStation();
                aMFMStation.frequency = FunctionWheelHandler.this.result;
                aMFMStation.pi = -1;
                aMFMStation.waveband = ((FunctionWheelHandler)FunctionWheelHandler.this).bandInfo.waveband;
                aMFMStation.serviceId = 1;
                FunctionWheelHandler.this.amFmTuner.tuneStation(aMFMStation, true, false, 0);
                ((FunctionWheelHandler)FunctionWheelHandler.this).amFmTuner.audio.demute();
            } else {
                if (timer.equals(FunctionWheelHandler.this.updateBlockTimer)) {
                    Object object = FunctionWheelHandler.this.mutex;
                    synchronized (object) {
                        if (FunctionWheelHandler.this.blockedStation != null) {
                            FunctionWheelHandler.this.update(FunctionWheelHandler.this.blockedStation);
                            FunctionWheelHandler.this.blockedStation = null;
                        }
                    }
                }
                if (timer.equals(FunctionWheelHandler.this.afBlockTimer)) {
                    Object object = FunctionWheelHandler.this.mutex;
                    synchronized (object) {
                        if (FunctionWheelHandler.this.afJumpStation != null) {
                            FunctionWheelHandler.this.update(new AMFMStation(FunctionWheelHandler.this.afJumpStation));
                            FunctionWheelHandler.this.afJumpStation = null;
                        }
                    }
                }
            }
        }
    }

    private class DsiDownListener
    extends AMFMDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
            FunctionWheelHandler.this.update(aMFMStation);
        }
    }

    private class MyRangeListener
    extends DefaultRangeListener {
        private MyRangeListener() {
        }

        public void decrement(int n, int n2, int n3) {
            ((FunctionWheelHandler)FunctionWheelHandler.this).logger.benchmark.log(10000000, "decrement %1", (long)n2);
            if (n2 != 0) {
                FunctionWheelHandler.this.scanHandler.abortScan();
                FunctionWheelHandler.this.updateBlockTimer.restart();
                FunctionWheelHandler.this.afBlockTimer.restart();
                FunctionWheelHandler.this.result = FunctionWheelHandler.this.position - (long)n2;
                if (FunctionWheelHandler.this.result < ((FunctionWheelHandler)FunctionWheelHandler.this).bandInfo.lowerLimit) {
                    FunctionWheelHandler.this.result = ((FunctionWheelHandler)FunctionWheelHandler.this).bandInfo.upperLimit;
                }
                FunctionWheelHandler.this.position = FunctionWheelHandler.this.result;
                FunctionWheelHandler.this.setResultName();
                FunctionWheelHandler.this.tuneTimer.restart();
            }
            ((FunctionWheelHandler)FunctionWheelHandler.this).logger.benchmark.log(10000000, "decrement left");
        }

        public void increment(int n, int n2, int n3) {
            ((FunctionWheelHandler)FunctionWheelHandler.this).logger.benchmark.log(10000000, "increment %1", (long)n2);
            if (n2 != 0) {
                FunctionWheelHandler.this.scanHandler.abortScan();
                FunctionWheelHandler.this.updateBlockTimer.restart();
                FunctionWheelHandler.this.afBlockTimer.restart();
                FunctionWheelHandler.this.result = FunctionWheelHandler.this.position + (long)n2;
                if (FunctionWheelHandler.this.result > ((FunctionWheelHandler)FunctionWheelHandler.this).bandInfo.upperLimit) {
                    FunctionWheelHandler.this.result = ((FunctionWheelHandler)FunctionWheelHandler.this).bandInfo.lowerLimit;
                }
                FunctionWheelHandler.this.position = FunctionWheelHandler.this.result;
                FunctionWheelHandler.this.setResultName();
                FunctionWheelHandler.this.tuneTimer.restart();
            }
            ((FunctionWheelHandler)FunctionWheelHandler.this).logger.benchmark.log(10000000, "increment left");
        }
    }

    private class TunerActionProxyListenerExt
    extends TunerActionProxyListener {
        private TunerActionProxyListenerExt() {
        }

        public void manualTuneLeft() {
            FunctionWheelHandler.this.afBlockTimer.cancel();
            if (FunctionWheelHandler.this.afJumpStation != null) {
                FunctionWheelHandler.this.update(new AMFMStation(FunctionWheelHandler.this.afJumpStation));
                FunctionWheelHandler.this.afJumpStation = null;
            }
        }
    }
}

