/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import de.audi.atip.interapp.radio.IHistoryVetoService;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.AudioFocusInfo;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.ScanProgressTimer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.sds.UpdateListenerHandler;

public class ScanHandler
extends UpdateListenerHandler
implements IScanHandler,
ITelStateListener {
    final TunerActionProxyListener actionProxyListener = new ActionProxy();
    final AudioFocusInfoListener audioFocusListener = new AudioFocusInfoListener();
    private final TunerModels models;
    private MemoryListHandler memory;
    private HistoryTuner history;
    private IHistoryVetoService historyVetoService;
    private final Logger logger;
    private boolean scanActive;
    private final TimerListener scanTimer;
    private int scanOnList;
    private final ITunerVariantExt varExt;

    ScanHandler(TunerBasics tunerBasics, ITunerVariantExt iTunerVariantExt) {
        this.models = tunerBasics.getModels();
        this.scanTimer = new TimerListener();
        this.varExt = iTunerVariantExt;
        this.historyVetoService = IHistoryVetoService.NULL_INSTANCE;
        this.logger = tunerBasics.getLogger();
        RangeListener rangeListener2 = new RangeListener();
        this.models.getRangeModel(100511).setRangeListener(rangeListener2);
        this.models.getButtonModel(100588).setButtonListener(rangeListener2);
        this.models.getButtonModel(100626).setButtonListener(rangeListener2);
    }

    void register(MemoryListHandler memoryListHandler, HistoryTuner historyTuner) {
        this.memory = memoryListHandler;
        this.history = historyTuner;
        this.historyVetoService = historyTuner != null ? historyTuner.historyVetoService : IHistoryVetoService.NULL_INSTANCE;
    }

    public void abortScan() {
        if (this.scanActive) {
            this.scanTimer.stopScan();
        }
    }

    public boolean isScanActive() {
        return this.scanActive;
    }

    public boolean handleHkPrevHkNext(boolean bl) {
        if (this.scanActive) {
            if (Utilities.isPGen1OrBentley() || !bl) {
                this.abortScan();
                return false;
            }
            this.scanTimer.speedUp();
            return true;
        }
        return false;
    }

    public void scanButtonPressed() {
        if (!this.scanActive) {
            TunerObjectContainer[] tunerObjectContainerArray;
            this.scanOnList = this.models.getActiveList();
            switch (this.scanOnList) {
                case 12: {
                    tunerObjectContainerArray = this.memory.startScan();
                    break;
                }
                case 13: {
                    tunerObjectContainerArray = this.history.startScan();
                    break;
                }
                default: {
                    ISimpleTuner iSimpleTuner = TunerProxyManager.getInstance().getActiveTuner();
                    tunerObjectContainerArray = iSimpleTuner.startScan();
                }
            }
            if (tunerObjectContainerArray != null && tunerObjectContainerArray.length > 1) {
                this.scanActive = true;
                this.scanTimer.startScan(tunerObjectContainerArray);
                this.models.getChoiceModel(100509).setValue(1);
                this.varExt.showPartialPopup(25);
            } else {
                this.scanTimer.stopScan();
            }
        } else {
            this.scanTimer.stopScan();
        }
    }

    private void scanDone() {
        this.scanActive = false;
        if (this.scanOnList != 12 && this.scanOnList != 13) {
            TunerProxyManager.getInstance().getActiveTuner().stopScan();
        }
        this.models.getChoiceModel(100509).setValue(0);
        this.varExt.hidePartialPopup(25);
        this.historyVetoService.updateVeto(0, false);
        this.propagateupdatedScanStatus(false);
    }

    public void updateTelState(int n, ITelState iTelState) {
        boolean bl;
        if (n == 2 && (bl = iTelState.isIncomingCallPresent())) {
            this.abortScan();
            this.logger.main.log(10000000, "[ScanHandler.updateTelState] Call Active => Abort Scan");
        }
    }

    private class ActionProxy
    extends TunerActionProxyListener {
        private ActionProxy() {
        }

        public void tunTmpBandChangeEntered() {
            ScanHandler.this.abortScan();
        }

        public void tunerAbortScan() {
            ScanHandler.this.abortScan();
        }

        public void hmiDeactivatedTuner() {
            ScanHandler.this.abortScan();
        }
    }

    private class RangeListener
    extends DefaultRangeListener {
        private RangeListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            if (n != 100588) {
                ScanHandler.this.abortScan();
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            if (n == 100588) {
                ScanHandler.this.abortScan();
            }
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 100626: {
                    ScanHandler.this.scanButtonPressed();
                    ScanHandler.this.models.getButtonModel(n).fireEvent(n3);
                    break;
                }
            }
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private int index = -1;
        private TunerObjectContainer[] stations;
        private final ScanProgressTimer scanTimer;

        public TimerListener() {
            this.scanTimer = new ScanProgressTimer(ScanHandler.this.models, this);
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
            ScanHandler.this.historyVetoService.updateVeto(0, true);
            ScanHandler.this.propagateupdatedScanStatus(true);
        }

        public void stopScan() {
            this.scanTimer.cancel();
            this.index = -1;
            this.stations = null;
            ScanHandler.this.scanDone();
        }

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
                ScanHandler.this.scanDone();
            }
        }
    }

    private class AudioFocusInfoListener
    extends AudioFocusInfo {
        private AudioFocusInfoListener() {
        }

        public void audioFocusLost() {
            ScanHandler.this.abortScan();
        }
    }
}

