/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tuner.app.BandListRow;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.keys.DefaultKeyHandler;
import de.audi.tuner.keys.KeyHandlerBasics;

public class BandSelectKeyHandler
extends DefaultKeyHandler {
    public final TunerActionProxyListener actionProxyListener = new TunerActionProxyListenerExt();
    private int focusedBand = -1;
    private boolean firstEnter = true;
    private final BaseListModelApp bandList;
    private final IScanHandler scanHandler;

    BandSelectKeyHandler(KeyHandlerBasics keyHandlerBasics, IScanHandler iScanHandler) {
        super(keyHandlerBasics);
        this.models.getChoiceModel(100327).setChoiceListener(this);
        this.models.getChoiceModel(100316).setChoiceListener(this);
        this.models.getChoiceModel(100197).setChoiceListener(this);
        this.bandList = this.models.getBaseListModel(100488);
        this.bandList.setListener(new ListListener());
        this.scanHandler = iScanHandler;
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logger.hmi.log(10000000, "[BandSelectKeyHandler#itemFocused] %1 %2 %3", (long)n, (long)n2, (long)n3);
        int[] nArray = this.bandListHandler.getWavebands();
        if (n2 <= nArray.length) {
            this.focusedBand = nArray[n2];
        } else {
            this.logger.hmi.log(10000, "[BandSelectKeyHandler#itemFocused] Illegal index: %1 (list length: %2)", (long)n2, (long)nArray.length);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logger.hmi.log(10000000, "[BandSelectKeyHandler#keyTyped] %1 %2 %3", (long)n);
        if (n == 100197) {
            this.bandSelected(this.focusedBand, n3);
            this.triggerLeaveTempBandChangeScreen(n3);
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi.log(10000000, "[BandSelectKeyHandler#itemSelected] %1 %2 %3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 100316: 
            case 100327: {
                this.scanHandler.abortScan();
                this.bandSelected(n2, n4);
                this.models.getChoiceModel(100316).fireEvent(n4);
                break;
            }
            default: {
                this.logger.hmi.log(100000, "Illegal modelid: %1 ", (long)n);
            }
        }
    }

    public void bandSelected(int n, int n2) {
        if (n != -1) {
            this.bandListHandler.switchBand(n);
        }
    }

    private void highlightBand(boolean bl) {
        int n = -1;
        if (bl) {
            n = this.getActiveListIndex();
            if (n == -1) {
                n = this.getActiveTunerIndex();
            }
            if (n == -1) {
                n = 0;
            }
        } else {
            SelectedItem selectedItem = this.bandList.getSelected();
            if (selectedItem != null) {
                n = selectedItem.getIndex();
            }
            if (++n >= this.bandList.getLength()) {
                n = 0;
            }
        }
        this.logger.hmi.log(10000000, "[BandSelectKeyHandler#highlighBand], highlightIndex = %1 (firstEnter: %2)", (long)n, bl ? 1L : 0L);
        this.bandList.setSelectedIndex(n);
        if (n >= 0 && n < this.bandList.getLength()) {
            this.focusedBand = ((BandListRow)this.bandList.getRow(n)).getBand();
            this.models.getChoiceModel(100196).setValue(this.focusedBand);
        }
    }

    private int getActiveListIndex() {
        int n = -1;
        int n2 = this.models.getActiveList();
        for (int i2 = 0; i2 < this.bandList.getLength(); ++i2) {
            if (((BandListRow)this.bandList.getRow(i2)).getBand() != n2) continue;
            n = i2;
            break;
        }
        return n;
    }

    private int getActiveTunerIndex() {
        int n = -1;
        int n2 = this.models.getActiveTuner();
        for (int i2 = 0; i2 < this.bandList.getLength(); ++i2) {
            if (((BandListRow)this.bandList.getRow(i2)).getBand() != n2) continue;
            n = i2;
            break;
        }
        return n;
    }

    private void triggerLeaveTempBandChangeScreen(int n) {
        this.models.getChoiceModel(100197).fireEvent(n);
    }

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            int[] nArray = BandSelectKeyHandler.this.bandListHandler.getWavebands();
            if (n2 <= nArray.length) {
                BandSelectKeyHandler.this.bandSelected(nArray[n2], n4);
            } else {
                BandSelectKeyHandler.this.logger.hmi.log(10000, "[BandSelectKeyHandler#itemSelected] Illegal index: %1 (list length: %2)", (long)n2, (long)nArray.length);
            }
            BandSelectKeyHandler.this.triggerLeaveTempBandChangeScreen(n4);
        }
    }

    private class TunerActionProxyListenerExt
    extends TunerActionProxyListener {
        private TunerActionProxyListenerExt() {
        }

        public void tunTmpBandChangeEntered() {
            BandSelectKeyHandler.this.logger.hmi.log(10000000, "[BandSelectKeyHandler#tunTmpBandChangeEntered], isBandChangeAllowed = %1, isTunerVisible = %2", BandSelectKeyHandler.this.status.isPowerStateON(), BandSelectKeyHandler.this.status.isTunerVisible());
            if (BandSelectKeyHandler.this.status.isPowerStateON() && BandSelectKeyHandler.this.status.isTunerVisible()) {
                BandSelectKeyHandler.this.status.setTmpScreenActive(true);
                BandSelectKeyHandler.this.highlightBand(BandSelectKeyHandler.this.firstEnter);
                BandSelectKeyHandler.this.firstEnter = false;
            } else {
                BandSelectKeyHandler.this.logger.hmi.log(10000000, "Standby active or tuner hidden -> Do nothing");
                BandSelectKeyHandler.this.models.getChoiceModel(100327).setStatus(1);
            }
        }

        public void tunTmpBandChangeLeft() {
            BandSelectKeyHandler.this.logger.hmi.log(10000000, "[BandSelectKeyHandler#tunTmpBandChangeLeft]");
            BandSelectKeyHandler.this.status.setTmpScreenActive(false);
            BandSelectKeyHandler.this.focusedBand = -1;
            BandSelectKeyHandler.this.firstEnter = true;
        }
    }
}

