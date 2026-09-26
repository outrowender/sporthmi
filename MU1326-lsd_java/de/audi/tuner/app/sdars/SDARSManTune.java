/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.SDARSManTune$DsiUpListener;
import de.audi.tuner.app.sdars.SDARSManTune$TimerListener;
import de.audi.tuner.app.sdars.SDARSManTune$TunerActionProxyListenerExt;
import de.audi.tuner.app.sdars.SDARSManTune$rangeListener;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IScanHandler;

public class SDARSManTune {
    final SDARSDsiUpInfo dsiUpInfo = new SDARSManTune$DsiUpListener(this, null);
    final TunerActionProxyListener actionProxy = new SDARSManTune$TunerActionProxyListenerExt(this, null);
    private final TunerModels models;
    private final RangeModelApp range;
    private final LogChannel log;
    private StationInfoExt[] stationList = new StationInfoExt[0];
    private StationInfoExt activeStation = new StationInfoExt();
    private final Timer tuneTimer = new Timer("tuneTimer", 0, true, new SDARSManTune$TimerListener(this, null));
    private final IScanHandler scanHandler;
    private int index;
    private SDARSTuner tuner;
    public volatile boolean noSignal;

    SDARSManTune(TunerBasics tunerBasics, SDARSTuner sDARSTuner, IScanHandler iScanHandler, TunerStorage tunerStorage) {
        this.models = tunerBasics.getModels();
        this.tuner = sDARSTuner;
        this.scanHandler = iScanHandler;
        this.log = tunerBasics.getLogger().sdarsDSI;
        this.range = this.models.getRangeModel(1049100544);
        this.range.setRangeListener(new SDARSManTune$rangeListener(this, null));
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
            this.models.getLabelModel(277414144).setText(stationInfoExt.fullLabel);
            this.models.getLabelModel(260636928).setText(Utilities.getFormatedStationNumber(stationInfoExt.stationNumber));
            this.models.getLabelModel(294191360).setText(this.noSignal ? "NoSignal" : stationInfoExt.getFullCategory());
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

    static /* synthetic */ Timer access$400(SDARSManTune sDARSManTune) {
        return sDARSManTune.tuneTimer;
    }

    static /* synthetic */ StationInfoExt access$502(SDARSManTune sDARSManTune, StationInfoExt stationInfoExt) {
        sDARSManTune.activeStation = stationInfoExt;
        return sDARSManTune.activeStation;
    }

    static /* synthetic */ void access$600(SDARSManTune sDARSManTune) {
        sDARSManTune.setRangeValue();
    }

    static /* synthetic */ int access$700(SDARSManTune sDARSManTune) {
        return sDARSManTune.index;
    }

    static /* synthetic */ void access$800(SDARSManTune sDARSManTune, int n) {
        sDARSManTune.setLabels(n);
    }

    static /* synthetic */ StationInfoExt[] access$902(SDARSManTune sDARSManTune, StationInfoExt[] stationInfoExtArray) {
        sDARSManTune.stationList = stationInfoExtArray;
        return stationInfoExtArray;
    }

    static /* synthetic */ StationInfoExt[] access$900(SDARSManTune sDARSManTune) {
        return sDARSManTune.stationList;
    }

    static /* synthetic */ RangeModelApp access$1000(SDARSManTune sDARSManTune) {
        return sDARSManTune.range;
    }

    static /* synthetic */ void access$1100(SDARSManTune sDARSManTune) {
        sDARSManTune.doTune();
    }

    static /* synthetic */ TunerModels access$1200(SDARSManTune sDARSManTune) {
        return sDARSManTune.models;
    }
}

