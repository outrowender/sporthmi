/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.RadioTextHistory$ListListener;
import de.audi.tuner.app.RadioTextHistory$RadioTextRow;
import de.audi.tuner.app.RadioTextHistory$SpeedListener;
import de.audi.tuner.app.RadioTextHistory$TimerListener;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rthyperlinking.IPendingHyperlinkAction;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;

public class RadioTextHistory {
    private final BaseListModelApp listModel;
    protected final TunerModels models;
    private final Timer displayMinTimer;
    private final Timer noRadiotextTimer;
    private final int minDuration;
    private RadioTextHistory$RadioTextRow lastRow;
    private BaseListModelApp listCopy;
    private final Object mutex = new Object();
    private boolean speedIsHigh;
    private final RadiotextHyperlinkProcessor hyperlinkProcessor;
    private final int dataUpModel;
    private static final int RT_WAITING;
    private static final int RT_WAITING_TIMEOUT;
    private static final int RT_AVAILABLE;
    private static final int RT_NOT_SUPPORTED_BY_STATION;
    private final LogChannel lc;
    private final String logPrefix;
    private int uniqueID;

    public RadioTextHistory(TunerBasics tunerBasics, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, int n, int n2, int n3, String string, LogChannel logChannel) {
        this.models = tunerBasics.getModels();
        this.hyperlinkProcessor = radiotextHyperlinkProcessor;
        this.logPrefix = string;
        this.lc = logChannel;
        this.listModel = this.models.getBaseListModel(n);
        this.dataUpModel = n3;
        this.listModel.setListener(new RadioTextHistory$ListListener(this, null));
        RadioTextHistory$TimerListener radioTextHistory$TimerListener = new RadioTextHistory$TimerListener(this, null);
        this.minDuration = Utilities.getRadioTextDisplayTime() * 1000;
        this.displayMinTimer = new Timer("DisplayMinTimer", this.minDuration == 0 ? 1L : (long)this.minDuration, true, radioTextHistory$TimerListener);
        this.noRadiotextTimer = new Timer("noRadiotextTimer", 0, true, radioTextHistory$TimerListener);
        this.lastRow = new RadioTextHistory$RadioTextRow(this, ++this.uniqueID, "");
    }

    public void init() {
        RadioTextHistory$SpeedListener radioTextHistory$SpeedListener = new RadioTextHistory$SpeedListener(this, null);
        Utilities.getFramework().getSysApp().registerSpeedThresholdListener(radioTextHistory$SpeedListener, 9);
        Utilities.getFramework().getSysApp().registerSpeedThresholdListener(radioTextHistory$SpeedListener, 11);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void reset(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.listModel.removeAll();
            this.listCopy = null;
            this.displayMinTimer.cancel();
            this.lastRow = new RadioTextHistory$RadioTextRow(this, ++this.uniqueID, "");
        }
        int n = 4;
        String string = "RT_NOT_SUPPORTED_BY_STATION";
        this.noRadiotextTimer.cancel();
        if (bl) {
            this.noRadiotextTimer.restart();
            n = 3;
            string = "RT_WAITING";
        }
        this.lc.log(14808325, "[%1RadioTextHistory.reset] radioTextSupportedByNewStation %2, newChoiceValue %3", (Object)this.logPrefix, (Object)String.valueOf(bl), (Object)string);
        this.models.setChoiceDataUpdateMediator(this.dataUpModel, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateRadioText(String string) {
        if (string.equals(this.lastRow.getText(0))) {
            return;
        }
        if (Utilities.isEmpty(string)) {
            return;
        }
        this.noRadiotextTimer.cancel();
        Object object = this.mutex;
        synchronized (object) {
            RadioTextHistory$RadioTextRow radioTextHistory$RadioTextRow;
            if (this.listCopy == null) {
                this.listCopy = this.listModel.getCopy();
            }
            int n = this.listCopy.getLength();
            int n2 = ++this.uniqueID;
            this.lastRow = radioTextHistory$RadioTextRow = new RadioTextHistory$RadioTextRow(this, n2, string);
            if (n > 0) {
                radioTextHistory$RadioTextRow.addSeparator(2);
                RadioTextHistory$RadioTextRow radioTextHistory$RadioTextRow2 = (RadioTextHistory$RadioTextRow)this.listCopy.getRow(n - 1);
                radioTextHistory$RadioTextRow2.addSeparator(1);
                this.listCopy.setRow(n - 1, radioTextHistory$RadioTextRow2);
            }
            this.listCopy.append(radioTextHistory$RadioTextRow);
            if (this.listCopy.getLength() > 10) {
                long l = this.listCopy.getRow(0).getUniqueID();
                this.listCopy.remove(l);
                RadioTextHistory$RadioTextRow radioTextHistory$RadioTextRow3 = (RadioTextHistory$RadioTextRow)this.listCopy.getRow(0);
                radioTextHistory$RadioTextRow3.removeSeparator(2);
                this.listCopy.setRow(0, radioTextHistory$RadioTextRow3);
            }
            this.listCopy.setSelectedUniqueID(n2);
            this.modelUpdate();
            this.restartDurationTimer();
        }
        this.lc.log(14808325, "[%1RadioTextHistory.updateRadioText] text %2, newChoiceValue %3", (Object)this.logPrefix, (Object)string, (Object)"RT_AVAILABLE");
        this.models.setChoiceDataUpdateMediator(this.dataUpModel, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateRadiotextPlus(RadioTextPlusStorage radioTextPlusStorage) {
        Object object = this.mutex;
        synchronized (object) {
            BaseListModelApp baseListModelApp;
            BaseListModelApp baseListModelApp2 = baseListModelApp = this.listCopy != null ? this.listCopy : this.listModel;
            if (baseListModelApp.getLength() == 0) {
                return;
            }
            RadioTextHistory$RadioTextRow radioTextHistory$RadioTextRow = (RadioTextHistory$RadioTextRow)baseListModelApp.getRow(baseListModelApp.getLength() - 1);
            IPendingHyperlinkAction iPendingHyperlinkAction = this.hyperlinkProcessor.determinePendingHyperlinkActionFor(radioTextHistory$RadioTextRow.getRadiotext(), radioTextPlusStorage);
            if (iPendingHyperlinkAction != null) {
                radioTextHistory$RadioTextRow.setPendingHyperlinkAction(iPendingHyperlinkAction);
                baseListModelApp.setRow(baseListModelApp.getLength() - 1, radioTextHistory$RadioTextRow);
            }
        }
    }

    private void restartDurationTimer() {
        if (this.minDuration != 0 && this.speedIsHigh && !this.displayMinTimer.isRunning()) {
            this.displayMinTimer.restart();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean modelUpdate() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.listCopy != null && !this.displayMinTimer.isRunning()) {
                this.listModel.update(this.listCopy);
                this.listCopy = null;
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ LogChannel access$300(RadioTextHistory radioTextHistory) {
        return radioTextHistory.lc;
    }

    static /* synthetic */ Timer access$400(RadioTextHistory radioTextHistory) {
        return radioTextHistory.displayMinTimer;
    }

    static /* synthetic */ Object access$500(RadioTextHistory radioTextHistory) {
        return radioTextHistory.mutex;
    }

    static /* synthetic */ boolean access$600(RadioTextHistory radioTextHistory) {
        return radioTextHistory.modelUpdate();
    }

    static /* synthetic */ void access$700(RadioTextHistory radioTextHistory) {
        radioTextHistory.restartDurationTimer();
    }

    static /* synthetic */ Timer access$800(RadioTextHistory radioTextHistory) {
        return radioTextHistory.noRadiotextTimer;
    }

    static /* synthetic */ String access$900(RadioTextHistory radioTextHistory) {
        return radioTextHistory.logPrefix;
    }

    static /* synthetic */ int access$1000(RadioTextHistory radioTextHistory) {
        return radioTextHistory.dataUpModel;
    }

    static /* synthetic */ int access$1100(RadioTextHistory radioTextHistory) {
        return radioTextHistory.minDuration;
    }

    static /* synthetic */ boolean access$1202(RadioTextHistory radioTextHistory, boolean bl) {
        radioTextHistory.speedIsHigh = bl;
        return radioTextHistory.speedIsHigh;
    }

    static /* synthetic */ BaseListModelApp access$1300(RadioTextHistory radioTextHistory) {
        return radioTextHistory.listModel;
    }
}

