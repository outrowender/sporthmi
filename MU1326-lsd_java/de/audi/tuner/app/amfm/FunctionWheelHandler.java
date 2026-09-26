/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.FunctionWheelHandler$DsiDownListener;
import de.audi.tuner.app.amfm.FunctionWheelHandler$DsiUpListener;
import de.audi.tuner.app.amfm.FunctionWheelHandler$MyRangeListener;
import de.audi.tuner.app.amfm.FunctionWheelHandler$TimerListener;
import de.audi.tuner.app.amfm.FunctionWheelHandler$TunerActionProxyListenerExt;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IScanHandler;
import org.dsi.ifc.radio.WavebandInfo;

class FunctionWheelHandler {
    public final AMFMDsiUpInfo dsiUpListener = new FunctionWheelHandler$DsiUpListener(this, null);
    public final AMFMDsiDownInfo dsiDownListener = new FunctionWheelHandler$DsiDownListener(this, null);
    public final TunerActionProxyListener actionProxyListener = new FunctionWheelHandler$TunerActionProxyListenerExt(this, null);
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
        FunctionWheelHandler$TimerListener functionWheelHandler$TimerListener = new FunctionWheelHandler$TimerListener(this, null);
        this.tuneTimer = new Timer(new StringBuffer().append("tuneTimer").append(this.bandInfo.waveband).toString(), 5, this.logger.timer, functionWheelHandler$TimerListener, 0, true);
        this.afBlockTimer = new Timer("AF-block", 0, true, functionWheelHandler$TimerListener);
        this.updateBlockTimer = new Timer(new StringBuffer().append("updateBlockTimer").append(this.bandInfo.waveband).toString(), 5, this.logger.timer, functionWheelHandler$TimerListener, 0, true);
        this.range = rangeModelApp;
        this.range.setStatus(1);
        this.freqLabel = labelModelApp;
        this.range.setRangeListener(new FunctionWheelHandler$MyRangeListener(this, null));
    }

    public long getPosition() {
        return this.position;
    }

    private void setResultName() {
        this.freqLabel.setText(FunctionWheelHandler.constructFrequencyString(this.bandInfo.waveband, this.position));
        this.models.getChoiceModel(1233649920).setValue(0);
        this.models.getLabelModel(1166672128).setText("");
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
            this.logger.amfmDeepDebug.log(-2137614336, "[FWH.update] %1", (Object)aMFMStation);
            Object object = this.mutex;
            synchronized (object) {
                if (this.updateBlockTimer.isRunning()) {
                    this.logger.amfmDeepDebug.log(14808325, "[FWH.update] store blocked");
                    this.blockedStation = aMFMStation;
                    this.activeStation = aMFMStation;
                } else {
                    if (this.checkAfJump(aMFMStation) && this.afBlockTimer.isRunning()) {
                        this.afJumpStation = aMFMStation;
                        this.logger.amfmDeepDebug.log(14808325, "[FWH.update] store AF-jump");
                        return;
                    }
                    this.logger.amfmDeepDebug.log(14808325, "[FWH.update] delete AF-jump");
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

    static /* synthetic */ Logger access$500(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.logger;
    }

    static /* synthetic */ IScanHandler access$600(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.scanHandler;
    }

    static /* synthetic */ Timer access$700(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.updateBlockTimer;
    }

    static /* synthetic */ Timer access$800(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.afBlockTimer;
    }

    static /* synthetic */ long access$902(FunctionWheelHandler functionWheelHandler, long l) {
        functionWheelHandler.result = l;
        return functionWheelHandler.result;
    }

    static /* synthetic */ long access$1000(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.position;
    }

    static /* synthetic */ long access$900(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.result;
    }

    static /* synthetic */ WavebandInfo access$1100(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.bandInfo;
    }

    static /* synthetic */ long access$1002(FunctionWheelHandler functionWheelHandler, long l) {
        functionWheelHandler.position = l;
        return functionWheelHandler.position;
    }

    static /* synthetic */ void access$1200(FunctionWheelHandler functionWheelHandler) {
        functionWheelHandler.setResultName();
    }

    static /* synthetic */ Timer access$1300(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.tuneTimer;
    }

    static /* synthetic */ void access$1400(FunctionWheelHandler functionWheelHandler, AMFMStation aMFMStation) {
        functionWheelHandler.update(aMFMStation);
    }

    static /* synthetic */ void access$1500(FunctionWheelHandler functionWheelHandler, WavebandInfo[] wavebandInfoArray) {
        functionWheelHandler.updateWavebandInfoList(wavebandInfoArray);
    }

    static /* synthetic */ AMFMTuner access$1600(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.amFmTuner;
    }

    static /* synthetic */ Object access$1700(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.mutex;
    }

    static /* synthetic */ AMFMStation access$1800(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.blockedStation;
    }

    static /* synthetic */ AMFMStation access$1802(FunctionWheelHandler functionWheelHandler, AMFMStation aMFMStation) {
        functionWheelHandler.blockedStation = aMFMStation;
        return functionWheelHandler.blockedStation;
    }

    static /* synthetic */ AMFMStation access$1900(FunctionWheelHandler functionWheelHandler) {
        return functionWheelHandler.afJumpStation;
    }

    static /* synthetic */ AMFMStation access$1902(FunctionWheelHandler functionWheelHandler, AMFMStation aMFMStation) {
        functionWheelHandler.afJumpStation = aMFMStation;
        return functionWheelHandler.afJumpStation;
    }
}

