/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
import de.audi.atip.interapp.radio.IHistoryVetoService;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.ScanHandler$ActionProxy;
import de.audi.tuner.app.ScanHandler$AudioFocusInfoListener;
import de.audi.tuner.app.ScanHandler$RangeListener;
import de.audi.tuner.app.ScanHandler$TimerListener;
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
    final TunerActionProxyListener actionProxyListener = new ScanHandler$ActionProxy(this, null);
    final ScanHandler$AudioFocusInfoListener audioFocusListener = new ScanHandler$AudioFocusInfoListener(this, null);
    private final TunerModels models;
    private MemoryListHandler memory;
    private HistoryTuner history;
    private IHistoryVetoService historyVetoService;
    private final Logger logger;
    private boolean scanActive;
    private final ScanHandler$TimerListener scanTimer;
    private int scanOnList;
    private final ITunerVariantExt varExt;

    ScanHandler(TunerBasics tunerBasics, ITunerVariantExt iTunerVariantExt) {
        this.models = tunerBasics.getModels();
        this.scanTimer = new ScanHandler$TimerListener(this);
        this.varExt = iTunerVariantExt;
        this.historyVetoService = IHistoryVetoService.NULL_INSTANCE;
        this.logger = tunerBasics.getLogger();
        ScanHandler$RangeListener scanHandler$RangeListener = new ScanHandler$RangeListener(this, null);
        this.models.getRangeModel(-1618476800).setRangeListener(scanHandler$RangeListener);
        this.models.getButtonModel(-326631168).setButtonListener(scanHandler$RangeListener);
        this.models.getButtonModel(310968576).setButtonListener(scanHandler$RangeListener);
    }

    void register(MemoryListHandler memoryListHandler, HistoryTuner historyTuner) {
        this.memory = memoryListHandler;
        this.history = historyTuner;
        this.historyVetoService = historyTuner != null ? historyTuner.historyVetoService : IHistoryVetoService.NULL_INSTANCE;
    }

    @Override
    public void abortScan() {
        if (this.scanActive) {
            this.scanTimer.stopScan();
        }
    }

    @Override
    public boolean isScanActive() {
        return this.scanActive;
    }

    @Override
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
                this.models.getChoiceModel(-1652031232).setValue(1);
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
        this.models.getChoiceModel(-1652031232).setValue(0);
        this.varExt.hidePartialPopup(25);
        this.historyVetoService.updateVeto(0, false);
        this.propagateupdatedScanStatus(false);
    }

    @Override
    public void updateTelState(int n, ITelState iTelState) {
        boolean bl;
        if (n == 2 && (bl = iTelState.isIncomingCallPresent())) {
            this.abortScan();
            this.logger.main.log(-2137614336, "[ScanHandler.updateTelState] Call Active => Abort Scan");
        }
    }

    static /* synthetic */ TunerModels access$300(ScanHandler scanHandler) {
        return scanHandler.models;
    }

    static /* synthetic */ IHistoryVetoService access$400(ScanHandler scanHandler) {
        return scanHandler.historyVetoService;
    }

    static /* synthetic */ void access$500(ScanHandler scanHandler) {
        scanHandler.scanDone();
    }
}

