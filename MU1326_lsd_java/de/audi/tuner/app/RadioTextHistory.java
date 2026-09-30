/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
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
    private RadioTextRow lastRow;
    private BaseListModelApp listCopy;
    private final Object mutex = new Object();
    private boolean speedIsHigh;
    private final RadiotextHyperlinkProcessor hyperlinkProcessor;
    private final int dataUpModel;
    private static final int RT_WAITING = 3;
    private static final int RT_WAITING_TIMEOUT = 2;
    private static final int RT_AVAILABLE = 1;
    private static final int RT_NOT_SUPPORTED_BY_STATION = 4;
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
        this.listModel.setListener(new ListListener());
        TimerListener timerListener = new TimerListener();
        this.minDuration = Utilities.getRadioTextDisplayTime() * 1000;
        this.displayMinTimer = new Timer("DisplayMinTimer", this.minDuration == 0 ? 1L : (long)this.minDuration, true, timerListener);
        this.noRadiotextTimer = new Timer("noRadiotextTimer", 30000L, true, timerListener);
        this.lastRow = new RadioTextRow(++this.uniqueID, "");
    }

    public void init() {
        SpeedListener speedListener = new SpeedListener();
        Utilities.getFramework().getSysApp().registerSpeedThresholdListener(speedListener, 9);
        Utilities.getFramework().getSysApp().registerSpeedThresholdListener(speedListener, 11);
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
            this.lastRow = new RadioTextRow(++this.uniqueID, "");
        }
        int n = 4;
        String string = "RT_NOT_SUPPORTED_BY_STATION";
        this.noRadiotextTimer.cancel();
        if (bl) {
            this.noRadiotextTimer.restart();
            n = 3;
            string = "RT_WAITING";
        }
        this.lc.log(100000000, "[%1RadioTextHistory.reset] radioTextSupportedByNewStation %2, newChoiceValue %3", (Object)this.logPrefix, (Object)String.valueOf(bl), (Object)string);
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
            RadioTextRow radioTextRow;
            if (this.listCopy == null) {
                this.listCopy = this.listModel.getCopy();
            }
            int n = this.listCopy.getLength();
            int n2 = ++this.uniqueID;
            this.lastRow = radioTextRow = new RadioTextRow(n2, string);
            if (n > 0) {
                radioTextRow.addSeparator(2);
                RadioTextRow radioTextRow2 = (RadioTextRow)this.listCopy.getRow(n - 1);
                radioTextRow2.addSeparator(1);
                this.listCopy.setRow(n - 1, radioTextRow2);
            }
            this.listCopy.append(radioTextRow);
            if (this.listCopy.getLength() > 10) {
                long l = this.listCopy.getRow(0).getUniqueID();
                this.listCopy.remove(l);
                RadioTextRow radioTextRow3 = (RadioTextRow)this.listCopy.getRow(0);
                radioTextRow3.removeSeparator(2);
                this.listCopy.setRow(0, radioTextRow3);
            }
            this.listCopy.setSelectedUniqueID(n2);
            this.modelUpdate();
            this.restartDurationTimer();
        }
        this.lc.log(100000000, "[%1RadioTextHistory.updateRadioText] text %2, newChoiceValue %3", (Object)this.logPrefix, (Object)string, (Object)"RT_AVAILABLE");
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
            RadioTextRow radioTextRow = (RadioTextRow)baseListModelApp.getRow(baseListModelApp.getLength() - 1);
            IPendingHyperlinkAction iPendingHyperlinkAction = this.hyperlinkProcessor.determinePendingHyperlinkActionFor(radioTextRow.getRadiotext(), radioTextPlusStorage);
            if (iPendingHyperlinkAction != null) {
                radioTextRow.setPendingHyperlinkAction(iPendingHyperlinkAction);
                baseListModelApp.setRow(baseListModelApp.getLength() - 1, radioTextRow);
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

    private class ListListener
    extends DefaultBaseListModelListener {
        private ListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            IPendingHyperlinkAction iPendingHyperlinkAction = ((RadioTextRow)evoListRow).getPendingHyperlinkAction();
            if (iPendingHyperlinkAction != null && iPendingHyperlinkAction.isExecutable(RadioTextHistory.this.lc)) {
                iPendingHyperlinkAction.prepare();
                RadioTextHistory.this.listModel.fireEvent(n4);
            }
        }
    }

    private class RadioTextRow
    extends EvoListRow {
        private static final int SELECTABLE_NO = 0;
        private static final int SELECTABLE_YES = 1;
        private static final int INDEX_TXT = 0;
        private static final int INDEX_SELECTABLE = 1;
        private static final int INDEX_LINE = 2;
        private static final int NUM_COLS = 3;
        private IPendingHyperlinkAction pendingHyperlinkAction;

        public RadioTextRow(long l, String string) {
            super(l, 3);
            this.setText(0, string);
            this.setInteger(1, 0);
            this.setInteger(2, 0);
        }

        private RadioTextRow(RadioTextRow radioTextRow) {
            super(radioTextRow);
            this.pendingHyperlinkAction = radioTextRow.pendingHyperlinkAction;
        }

        public EvoListRow copy() {
            return new RadioTextRow(this);
        }

        public void addSeparator(int n) {
            int n2 = this.getInteger(2);
            if (n == 1 && n2 == 2 || n == 2 && n2 == 1) {
                this.setInteger(2, 3);
            } else {
                this.setInteger(2, n);
            }
        }

        public void removeSeparator(int n) {
            int n2 = this.getInteger(2);
            if (n2 == 3) {
                if (n == 2) {
                    this.setInteger(2, 1);
                } else {
                    this.setInteger(2, 2);
                }
            }
        }

        public String getRadiotext() {
            return this.getText(0);
        }

        public IPendingHyperlinkAction getPendingHyperlinkAction() {
            return this.pendingHyperlinkAction;
        }

        public void setPendingHyperlinkAction(IPendingHyperlinkAction iPendingHyperlinkAction) {
            this.pendingHyperlinkAction = iPendingHyperlinkAction;
            boolean bl = iPendingHyperlinkAction.isExecutable(RadioTextHistory.this.lc);
            int n = bl ? 1 : 0;
            this.setInteger(1, n);
        }
    }

    private class SpeedListener
    implements SpeedThresholdListener {
        private SpeedListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void exceedsUpperThreshold(int n) {
            if (n == 11) {
                RadioTextHistory.this.models.getChoiceModel(100727).setValue(1);
            } else if (RadioTextHistory.this.minDuration != 0) {
                Object object = RadioTextHistory.this.mutex;
                synchronized (object) {
                    RadioTextHistory.this.speedIsHigh = true;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void belowLowerThreshold(int n) {
            if (n == 11) {
                RadioTextHistory.this.models.getChoiceModel(100727).setValue(0);
            } else {
                Object object = RadioTextHistory.this.mutex;
                synchronized (object) {
                    RadioTextHistory.this.displayMinTimer.cancel();
                    RadioTextHistory.this.modelUpdate();
                    RadioTextHistory.this.speedIsHigh = false;
                }
            }
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
            if (timer.equals(RadioTextHistory.this.displayMinTimer)) {
                Object object = RadioTextHistory.this.mutex;
                synchronized (object) {
                    boolean bl = RadioTextHistory.this.modelUpdate();
                    if (bl) {
                        RadioTextHistory.this.restartDurationTimer();
                    }
                }
            } else if (timer.equals(RadioTextHistory.this.noRadiotextTimer)) {
                RadioTextHistory.this.lc.log(100000000, "[%1RadioTextHistory.TimerListener.fireTimer] newChoiceValue %2", (Object)RadioTextHistory.this.logPrefix, (Object)"RT_WAITING_TIMEOUT");
                RadioTextHistory.this.models.setChoiceDataUpdateMediator(RadioTextHistory.this.dataUpModel, 2);
            }
        }
    }
}

