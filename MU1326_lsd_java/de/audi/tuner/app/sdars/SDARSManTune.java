/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IScanHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SDARSManTune {
    final SDARSDsiUpInfo dsiUpInfo = new DsiUpListener();
    final TunerActionProxyListener actionProxy = new TunerActionProxyListenerExt();
    private final TunerModels models;
    private final RangeModelApp range;
    private final LogChannel log;
    private StationInfoExt[] stationList = new StationInfoExt[0];
    private StationInfoExt activeStation = new StationInfoExt();
    private final Timer tuneTimer = new Timer("tuneTimer", 1500L, true, new TimerListener());
    private final IScanHandler scanHandler;
    private int index;
    private SDARSTuner tuner;
    public volatile boolean noSignal;

    SDARSManTune(TunerBasics tunerBasics, SDARSTuner sDARSTuner, IScanHandler iScanHandler, TunerStorage tunerStorage) {
        this.models = tunerBasics.getModels();
        this.tuner = sDARSTuner;
        this.scanHandler = iScanHandler;
        this.log = tunerBasics.getLogger().sdarsDSI;
        this.range = this.models.getRangeModel(100414);
        this.range.setRangeListener(new rangeListener());
        this.activeStation = tunerStorage.loadLastSDARSStation();
    }

    private void setRangeValue() {
        this.index = this.getIndex(this.activeStation.sID);
        if (this.index != -1) {
            this.range.setValue(this.index);
        } else {
            this.log.log(10000, "[SDARSManTune.setRangeValue] wrong index!");
        }
    }

    private int getIndex(int n) {
        for (int i2 = 0; i2 < this.stationList.length; ++i2) {
            if (this.stationList[i2].sID != n) continue;
            return i2;
        }
        return -1;
    }

    private void setLabels(int n) {
        if (n >= 0 && n < this.stationList.length) {
            StationInfoExt stationInfoExt = this.stationList[n];
            this.models.getLabelModel(100624).setText(stationInfoExt.fullLabel);
            this.models.getLabelModel(100623).setText(Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
            this.models.getLabelModel(100625).setText(this.noSignal ? "NoSignal" : stationInfoExt.getFullCategory());
        } else {
            this.log.log(10000, "[SDARSManTune.setLabels] wrong index %1!", (long)n);
        }
    }

    private void doTune() {
        if (this.index >= 0 && this.index < this.stationList.length) {
            StationInfoExt stationInfoExt = this.stationList[this.index];
            if (stationInfoExt.sID != this.activeStation.sID) {
                this.scanHandler.abortScan();
                this.tuner.selectStation(stationInfoExt, 0);
            }
        } else {
            this.log.log(10000, "[SDARSManTune.doTune] wrong index %1!", (long)this.index);
        }
    }

    public StationInfoExt channelUp(int n, boolean bl) {
        this.index += n;
        return this.startTuneTimer(bl);
    }

    public StationInfoExt channelDown(int n, boolean bl) {
        this.index -= n;
        return this.startTuneTimer(bl);
    }

    private StationInfoExt startTuneTimer(boolean bl) {
        this.index = this.checkBorder(this.index);
        this.range.setValue(this.index);
        this.setLabels(this.index);
        if (bl) {
            this.tuneTimer.restart();
        } else {
            this.doTune();
        }
        if (this.stationList != null && this.index < this.stationList.length && this.index >= 0) {
            return this.stationList[this.index];
        }
        return null;
    }

    private int checkBorder(int n) {
        if (this.stationList.length == 0) {
            return 0;
        }
        while (n < 0) {
            n += this.stationList.length;
        }
        if (n >= this.stationList.length) {
            return n % this.stationList.length;
        }
        return n;
    }

    static /* synthetic */ StationInfoExt[] access$902(SDARSManTune sDARSManTune, StationInfoExt[] stationInfoExtArray) {
        sDARSManTune.stationList = stationInfoExtArray;
        return stationInfoExtArray;
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            if (!SDARSManTune.this.tuneTimer.isRunning()) {
                SDARSManTune.this.activeStation = stationInfoExt;
                SDARSManTune.this.setRangeValue();
                SDARSManTune.this.setLabels(SDARSManTune.this.index);
            }
        }

        public void updateStationList(StationInfoExt[] stationInfoExtArray) {
            ArrayList arrayList = new ArrayList(stationInfoExtArray.length);
            for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
                if (stationInfoExtArray[i2].subscription != 2 || stationInfoExtArray[i2].stationNumber == 0) continue;
                arrayList.add(stationInfoExtArray[i2]);
            }
            Collections.sort(arrayList, new Comparator(){

                public int compare(Object object, Object object2) {
                    return ((StationInfoExt)object).stationNumber - ((StationInfoExt)object2).stationNumber;
                }
            });
            SDARSManTune.access$902(SDARSManTune.this, (StationInfoExt[])arrayList.toArray(new StationInfoExt[arrayList.size()]));
            SDARSManTune.this.range.setLimits(0, SDARSManTune.this.stationList.length - 1, 1);
            SDARSManTune.this.setRangeValue();
        }

        public void updateSignalStatus(boolean bl) {
            SDARSManTune.this.noSignal = bl;
            SDARSManTune.this.setLabels(SDARSManTune.this.index);
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        public void fireTimer(Timer timer) {
            SDARSManTune.this.doTune();
        }
    }

    private class rangeListener
    extends DefaultRangeListener {
        private rangeListener() {
        }

        public void increment(int n, int n2, int n3) {
            SDARSManTune.this.channelUp(n2, true);
        }

        public void decrement(int n, int n2, int n3) {
            SDARSManTune.this.channelDown(n2, true);
        }
    }

    private class TunerActionProxyListenerExt
    extends TunerActionProxyListener {
        private TunerActionProxyListenerExt() {
        }

        public void manualTuneLeft() {
            if (SDARSManTune.this.models.getActiveTuner() == 7) {
                SDARSManTune.this.doTune();
            }
        }
    }
}

