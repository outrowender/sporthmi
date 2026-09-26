/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.keys;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tuner.app.BandListRow;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.keys.BandSelectKeyHandler$ListListener;
import de.audi.tuner.keys.BandSelectKeyHandler$TunerActionProxyListenerExt;
import de.audi.tuner.keys.DefaultKeyHandler;
import de.audi.tuner.keys.KeyHandlerBasics;

public class BandSelectKeyHandler
extends DefaultKeyHandler {
    public final TunerActionProxyListener actionProxyListener = new BandSelectKeyHandler$TunerActionProxyListenerExt(this, null);
    private int focusedBand = -1;
    private boolean firstEnter = true;
    private final BaseListModelApp bandList;
    private final IScanHandler scanHandler;

    BandSelectKeyHandler(KeyHandlerBasics keyHandlerBasics, IScanHandler iScanHandler) {
        super(keyHandlerBasics);
        this.models.getChoiceModel(-410582784).setChoiceListener(this);
        this.models.getChoiceModel(-595132160).setChoiceListener(this);
        this.models.getChoiceModel(1703346432).setChoiceListener(this);
        this.bandList = this.models.getBaseListModel(-2004352768);
        this.bandList.setListener(new BandSelectKeyHandler$ListListener(this, null));
        this.scanHandler = iScanHandler;
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logger.hmi.log(-2137614336, "[BandSelectKeyHandler#itemFocused] %1 %2 %3", (long)n, (long)n2, (long)n3);
        int[] nArray = this.bandListHandler.getWavebands();
        if (n2 <= nArray.length) {
            this.focusedBand = nArray[n2];
        } else {
            this.logger.hmi.log(10000, "[BandSelectKeyHandler#itemFocused] Illegal index: %1 (list length: %2)", (long)n2, (long)nArray.length);
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logger.hmi.log(-2137614336, "[BandSelectKeyHandler#keyTyped] %1 %2 %3", (long)n);
        if (n == 1703346432) {
            this.bandSelected(this.focusedBand, n3);
            this.triggerLeaveTempBandChangeScreen(n3);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logger.hmi.log(-2137614336, "[BandSelectKeyHandler#itemSelected] %1 %2 %3", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 100316: 
            case 100327: {
                this.scanHandler.abortScan();
                this.bandSelected(n2, n4);
                this.models.getChoiceModel(-595132160).fireEvent(n4);
                break;
            }
            default: {
                this.logger.hmi.log(-1601830656, "Illegal modelid: %1 ", (long)n);
            }
        }
    }

    @Override
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
        this.logger.hmi.log(-2137614336, "[BandSelectKeyHandler#highlighBand], highlightIndex = %1 (firstEnter: %2)", (long)n, bl ? 1L : 0L);
        this.bandList.setSelectedIndex(n);
        if (n >= 0 && n < this.bandList.getLength()) {
            this.focusedBand = ((BandListRow)this.bandList.getRow(n)).getBand();
            this.models.getChoiceModel(1686569216).setValue(this.focusedBand);
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
        this.models.getChoiceModel(1703346432).fireEvent(n);
    }

    static /* synthetic */ boolean access$200(BandSelectKeyHandler bandSelectKeyHandler) {
        return bandSelectKeyHandler.firstEnter;
    }

    static /* synthetic */ void access$300(BandSelectKeyHandler bandSelectKeyHandler, boolean bl) {
        bandSelectKeyHandler.highlightBand(bl);
    }

    static /* synthetic */ boolean access$202(BandSelectKeyHandler bandSelectKeyHandler, boolean bl) {
        bandSelectKeyHandler.firstEnter = bl;
        return bandSelectKeyHandler.firstEnter;
    }

    static /* synthetic */ int access$402(BandSelectKeyHandler bandSelectKeyHandler, int n) {
        bandSelectKeyHandler.focusedBand = n;
        return bandSelectKeyHandler.focusedBand;
    }

    static /* synthetic */ void access$500(BandSelectKeyHandler bandSelectKeyHandler, int n) {
        bandSelectKeyHandler.triggerLeaveTempBandChangeScreen(n);
    }
}

