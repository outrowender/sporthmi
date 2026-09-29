/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.AbstractNumberSpellerHandler;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler$DsiUpListener;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler$SpellerListener;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler$TimerListener;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler$TunerActionProxyListenerExt;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IScanHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.radio.WavebandInfo;

public abstract class AbstractAmFmSpellerHandler
extends AbstractNumberSpellerHandler {
    protected static final long AUTO_CLEAR_DELAY;
    protected static final long AUTO_SELECT_DELAY;
    final AMFMDsiUpInfo dsiUpListener = new AbstractAmFmSpellerHandler$DsiUpListener(this, null);
    public final TunerActionProxyListener proxyListener = new AbstractAmFmSpellerHandler$TunerActionProxyListenerExt(this, null);
    private final IScanHandler scanHandler;
    protected MatchspellerModelApp spellerModel;
    private ChoiceModelApp frequencyModel;
    private AMFMTuner tuner;
    protected AMFMStation station = null;
    int kommaPos = -1;
    int hdPos = -1;
    protected Map hdSubchannelSpellerMap = new HashMap();
    protected static final String HD_POSTFIX;
    Timer clearTimer;
    Timer selectTimer;
    final AbstractAmFmSpellerHandler$SpellerListener spellerListener = new AbstractAmFmSpellerHandler$SpellerListener(this);

    public AbstractAmFmSpellerHandler(MatchspellerModelApp matchspellerModelApp, ChoiceModelApp choiceModelApp, AMFMTuner aMFMTuner, IScanHandler iScanHandler) {
        this.tuner = aMFMTuner;
        this.scanHandler = iScanHandler;
        this.spellerModel = matchspellerModelApp;
        this.spellerModel.setSpellerListener(this.spellerListener);
        this.frequencyModel = choiceModelApp;
        this.frequencyModel.setValue(1);
        AbstractAmFmSpellerHandler$TimerListener abstractAmFmSpellerHandler$TimerListener = new AbstractAmFmSpellerHandler$TimerListener(this);
        this.clearTimer = new Timer("clearTimer", 0, true, abstractAmFmSpellerHandler$TimerListener);
        this.selectTimer = new Timer("selectTimer", 0, true, abstractAmFmSpellerHandler$TimerListener);
    }

    private void prepare(String string) {
        if (string.length() == 0) {
            this.frequencyModel.setValue(1);
        } else {
            this.frequencyModel.setValue(0);
        }
        if (this.kommaPos != -1 && string.length() > this.kommaPos + 1) {
            this.spellerModel.setValidChars("");
        } else {
            int n = this.kommaPos == -1 ? (this.hdPos == -1 ? (string.length() > 0 ? Integer.parseInt(string) : 0) : Integer.parseInt(string.substring(0, this.hdPos))) : Integer.parseInt(string.substring(0, this.kommaPos));
            String string2 = this.getValidNextDigitsForPrefixAsString(n);
            this.spellerModel.setValidChars(string2);
        }
    }

    protected abstract String appendComma(String string) {
    }

    protected String appendHd(String string) {
        String string2;
        String string3 = string;
        if (this.station != null && (string2 = (String)this.hdSubchannelSpellerMap.get(this.station.getFrequencyString())) != null && string2.length() > 0) {
            if (this.hdPos == -1) {
                string3 = new StringBuffer().append(string).append(" HD").toString();
                this.hdPos = string.length();
            }
            if (this.hdPos + " HD".length() == string3.length() && string2.length() > 1) {
                this.spellerModel.setValidChars(string2);
            }
        }
        this.spellerModel.setText(string3);
        return string3;
    }

    private void resetSpeller() {
        this.clearTimer.cancel();
        this.selectTimer.cancel();
        this.spellerModel.clear();
        this.kommaPos = -1;
        this.hdPos = -1;
        this.prepare("");
    }

    private void tuneFrequency() {
        if (this.station != null) {
            this.scanHandler.abortScan();
            this.tuner.tuneStation(this.station, false, false, 0);
            this.station = null;
        }
        this.resetSpeller();
        this.spellerModel.setControlButtonStates(-1, 0);
    }

    protected void buildHdPostfixMap(AMFMStation[] aMFMStationArray) {
        for (int i2 = 0; i2 < aMFMStationArray.length; ++i2) {
            Buffer buffer = new Buffer();
            AMFMStation aMFMStation = aMFMStationArray[i2];
            int n = aMFMStation.getHdStructure();
            if (n != 0) {
                this.checkAndAppendHDNumber(buffer, n, 1, 1);
                this.checkAndAppendHDNumber(buffer, n, 2, 2);
                this.checkAndAppendHDNumber(buffer, n, 4, 3);
                this.checkAndAppendHDNumber(buffer, n, 8, 4);
                this.checkAndAppendHDNumber(buffer, n, 16, 5);
                this.checkAndAppendHDNumber(buffer, n, 32, 6);
                this.checkAndAppendHDNumber(buffer, n, 64, 7);
            }
            this.hdSubchannelSpellerMap.put(aMFMStation.getFrequencyString(), buffer.toString());
        }
    }

    private void checkAndAppendHDNumber(Buffer buffer, int n, int n2, int n3) {
        if ((n & n2) == n2) {
            buffer.append(String.valueOf(n3));
        }
    }

    protected abstract int getWaveband() {
    }

    protected abstract void processWavebandInfo(WavebandInfo wavebandInfo) {
    }

    protected abstract int cutOffTrailingDigits(int n) {
    }

    protected abstract void setStationFromFrequency(String string) {
    }

    static /* synthetic */ void access$200(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        abstractAmFmSpellerHandler.tuneFrequency();
    }

    static /* synthetic */ void access$300(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler, String string) {
        abstractAmFmSpellerHandler.prepare(string);
    }

    static /* synthetic */ void access$400(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        abstractAmFmSpellerHandler.resetSpeller();
    }

    static /* synthetic */ void access$500(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        abstractAmFmSpellerHandler.initMap();
    }

    static /* synthetic */ void access$600(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler, int n) {
        abstractAmFmSpellerHandler.addNumber(n);
    }
}

