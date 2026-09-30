/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.AbstractNumberSpellerHandler;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IScanHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.radio.WavebandInfo;

public abstract class AbstractAmFmSpellerHandler
extends AbstractNumberSpellerHandler {
    protected static final long AUTO_CLEAR_DELAY = 20000L;
    protected static final long AUTO_SELECT_DELAY = 10000L;
    final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();
    public final TunerActionProxyListener proxyListener = new TunerActionProxyListenerExt();
    private final IScanHandler scanHandler;
    protected MatchspellerModelApp spellerModel;
    private ChoiceModelApp frequencyModel;
    private AMFMTuner tuner;
    protected AMFMStation station = null;
    int kommaPos = -1;
    int hdPos = -1;
    protected Map hdSubchannelSpellerMap = new HashMap();
    protected static final String HD_POSTFIX = " HD";
    Timer clearTimer;
    Timer selectTimer;
    final SpellerListener spellerListener = new SpellerListener();

    public AbstractAmFmSpellerHandler(MatchspellerModelApp matchspellerModelApp, ChoiceModelApp choiceModelApp, AMFMTuner aMFMTuner, IScanHandler iScanHandler) {
        this.tuner = aMFMTuner;
        this.scanHandler = iScanHandler;
        this.spellerModel = matchspellerModelApp;
        this.spellerModel.setSpellerListener(this.spellerListener);
        this.frequencyModel = choiceModelApp;
        this.frequencyModel.setValue(1);
        TimerListener timerListener = new TimerListener();
        this.clearTimer = new Timer("clearTimer", 20000L, true, timerListener);
        this.selectTimer = new Timer("selectTimer", 10000L, true, timerListener);
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

    protected abstract String appendComma(String var1);

    protected String appendHd(String string) {
        String string2;
        String string3 = string;
        if (this.station != null && (string2 = (String)this.hdSubchannelSpellerMap.get(this.station.getFrequencyString())) != null && string2.length() > 0) {
            if (this.hdPos == -1) {
                string3 = new StringBuffer().append(string).append(HD_POSTFIX).toString();
                this.hdPos = string.length();
            }
            if (this.hdPos + HD_POSTFIX.length() == string3.length() && string2.length() > 1) {
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

    protected abstract int getWaveband();

    protected abstract void processWavebandInfo(WavebandInfo var1);

    protected abstract int cutOffTrailingDigits(int var1);

    protected abstract void setStationFromFrequency(String var1);

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
            int n;
            if (wavebandInfoArray == null) {
                return;
            }
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            for (n = 0; n < wavebandInfoArray.length; ++n) {
                if (wavebandInfoArray[n].waveband != AbstractAmFmSpellerHandler.this.getWaveband()) continue;
                n2 = AbstractAmFmSpellerHandler.this.cutOffTrailingDigits((int)wavebandInfoArray[n].lowerLimit);
                n3 = AbstractAmFmSpellerHandler.this.cutOffTrailingDigits((int)wavebandInfoArray[n].upperLimit);
                n4 = AbstractAmFmSpellerHandler.this.cutOffTrailingDigits((int)wavebandInfoArray[n].stepWidth);
                AbstractAmFmSpellerHandler.this.processWavebandInfo(wavebandInfoArray[n]);
                break;
            }
            if (n3 > n2 && n4 > 0) {
                AbstractAmFmSpellerHandler.this.initMap();
                for (n = n2; n <= n3; n += n4) {
                    AbstractAmFmSpellerHandler.this.addNumber(n);
                }
            }
            AbstractAmFmSpellerHandler.this.prepare(AbstractAmFmSpellerHandler.this.spellerModel.getText());
        }
    }

    class TimerListener
    extends DefaultTimerListener {
        TimerListener() {
        }

        public void fireTimer(Timer timer) {
            if (timer.equals(AbstractAmFmSpellerHandler.this.clearTimer)) {
                AbstractAmFmSpellerHandler.this.resetSpeller();
            } else {
                AbstractAmFmSpellerHandler.this.tuneFrequency();
            }
        }
    }

    class SpellerListener
    extends DefaultSpellerListener {
        SpellerListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            AbstractAmFmSpellerHandler.this.tuneFrequency();
        }

        public void textChanged(int n, String string, char c2, int n2) {
            if (c2 == '\b') {
                string = this.chrBackspace(string);
                AbstractAmFmSpellerHandler.this.spellerModel.setText(string);
            }
            AbstractAmFmSpellerHandler.this.setStationFromFrequency(string);
            AbstractAmFmSpellerHandler.this.prepare(string);
            String string2 = AbstractAmFmSpellerHandler.this.appendComma(string);
            AbstractAmFmSpellerHandler.this.appendHd(string2);
            if (AbstractAmFmSpellerHandler.this.station != null) {
                AbstractAmFmSpellerHandler.this.selectTimer.restart();
                AbstractAmFmSpellerHandler.this.clearTimer.cancel();
            } else {
                AbstractAmFmSpellerHandler.this.clearTimer.restart();
                AbstractAmFmSpellerHandler.this.selectTimer.cancel();
            }
            AbstractAmFmSpellerHandler.this.spellerModel.setControlButtonStates(-1, AbstractAmFmSpellerHandler.this.station != null ? 1 : 0);
        }

        private String chrBackspace(String string) {
            String string2 = "";
            if (AbstractAmFmSpellerHandler.this.station != null) {
                string2 = (String)AbstractAmFmSpellerHandler.this.hdSubchannelSpellerMap.get(AbstractAmFmSpellerHandler.this.station.getFrequencyString());
            }
            if (AbstractAmFmSpellerHandler.this.kommaPos != -1 && string.length() == AbstractAmFmSpellerHandler.this.kommaPos) {
                AbstractAmFmSpellerHandler.this.kommaPos = -1;
                return string.substring(0, string.length() - 1);
            }
            if (AbstractAmFmSpellerHandler.this.hdPos != -1 && (string.length() == AbstractAmFmSpellerHandler.this.hdPos + AbstractAmFmSpellerHandler.HD_POSTFIX.length() - 1 || string2.length() == 1)) {
                String string3 = AbstractAmFmSpellerHandler.this.kommaPos != -1 ? string.substring(0, AbstractAmFmSpellerHandler.this.kommaPos + 1) : string.substring(0, AbstractAmFmSpellerHandler.this.hdPos - 1);
                AbstractAmFmSpellerHandler.this.hdPos = -1;
                return string3;
            }
            return string;
        }
    }

    private class TunerActionProxyListenerExt
    extends TunerActionProxyListener {
        private TunerActionProxyListenerExt() {
        }

        public void spellerLeft() {
            AbstractAmFmSpellerHandler.this.resetSpeller();
        }
    }
}

