/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.GUIHandlerSDARS;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.IScanHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SdarsSpellerHandler {
    private static final long AUTO_CLEAR_DELAY = 20000L;
    private static final long AUTO_SELECT_DELAY = 5000L;
    private static final int SUBS_SCREEN_TRIGGER_TICK = 0;
    private static final int SUBS_SCREEN_TRIGGER_TOCK = 1;
    public final SDARSDsiUpInfo dsiUpInfo = new DsiUpListener();
    public final TunerActionProxyListener proxyListener = new TunerActionProxyListenerExt();
    private final TunerModels models;
    private final SDARSTuner tuner;
    private final GUIHandlerSDARS guiHandler;
    private final IScanHandler scanHandler;
    private final MatchspellerModelApp speller;
    private final LabelModelApp tempStationName;
    private final Timer clearTimer;
    private final Timer selectTimer;
    private final SpellerListener spellerListener = new SpellerListener();
    private final HashMap validKeys = new HashMap(100);

    public SdarsSpellerHandler(TunerBasics tunerBasics, GUIHandlerSDARS gUIHandlerSDARS, SDARSTuner sDARSTuner, IScanHandler iScanHandler) {
        this.models = tunerBasics.getModels();
        this.guiHandler = gUIHandlerSDARS;
        this.tuner = sDARSTuner;
        this.scanHandler = iScanHandler;
        TimerListener timerListener = new TimerListener();
        this.clearTimer = new Timer("clearTimer", 20000L, true, timerListener);
        this.selectTimer = new Timer("selectTimer", 5000L, true, timerListener);
        this.speller = this.models.getMatchspellerModel(100586);
        this.tempStationName = this.models.getLabelModel(100807);
        this.speller.setSpellerListener(this.spellerListener);
        this.models.getChoiceModel(100595).setValue(1);
    }

    private void prepare(String string) {
        if (string.length() == 0) {
            this.models.getChoiceModel(100595).setValue(1);
        } else {
            this.models.getChoiceModel(100595).setValue(0);
        }
        if (string.length() > 2) {
            this.speller.setValidChars("");
        } else {
            String string2 = this.getChars((List)this.validKeys.get(string));
            this.speller.setValidChars(string2);
        }
    }

    private String getChars(List list) {
        if (list != null) {
            Buffer buffer = new Buffer(10);
            for (int i2 = 0; i2 < list.size(); ++i2) {
                buffer.append(list.get(i2));
            }
            return buffer.toString();
        }
        return "";
    }

    private void mapNumber(String string, String string2) {
        String string3 = string2.substring(0, 1);
        this.addToMap(string, string3);
        if (("0".equals(string) || "".equals(string)) && "0".equals(string3) && string2.length() > 1) {
            this.mapNumber(string, string2.substring(1));
        }
        if (string2.length() > 1) {
            this.mapNumber(new StringBuffer().append(string).append(string3).toString(), string2.substring(1));
        }
    }

    private void addToMap(String string, String string2) {
        List list = (List)this.validKeys.get(string);
        if (list == null) {
            list = new ArrayList();
            list.add(string2);
        } else if (!list.contains(string2)) {
            list.add(string2);
        }
        this.validKeys.put(string, list);
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateStationList(StationInfoExt[] stationInfoExtArray) {
            SdarsSpellerHandler.this.validKeys.clear();
            SdarsSpellerHandler.this.mapNumber("", "000");
            for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
                short s;
                if (stationInfoExtArray[i2].subscription != 2 || (s = stationInfoExtArray[i2].stationNumber) >= 1000) continue;
                String string = String.valueOf(s);
                Buffer buffer = new Buffer();
                for (int i3 = 0; i3 < 3 - string.length(); ++i3) {
                    buffer.append("0");
                }
                buffer.append(string);
                SdarsSpellerHandler.this.mapNumber("", buffer.toString());
            }
            SdarsSpellerHandler.this.prepare(SdarsSpellerHandler.this.speller.getText());
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        public void fireTimer(Timer timer) {
            if (timer.equals(SdarsSpellerHandler.this.clearTimer)) {
                SdarsSpellerHandler.this.speller.clear();
                SdarsSpellerHandler.this.prepare("");
            } else {
                SdarsSpellerHandler.this.spellerListener.keyTyped(0, 0, 0);
            }
        }
    }

    private class SpellerListener
    extends DefaultSpellerListener {
        StationInfoExt station = null;

        private SpellerListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (this.station != null) {
                SdarsSpellerHandler.this.scanHandler.abortScan();
                SdarsSpellerHandler.this.tuner.selectStation(this.station, n3);
                this.station = null;
            } else {
                ChoiceModelApp choiceModelApp;
                choiceModelApp.setValue((choiceModelApp = SdarsSpellerHandler.this.models.getChoiceModel(100716)).getValue() == 0 ? 1 : 0);
            }
            SdarsSpellerHandler.this.speller.clear();
            SdarsSpellerHandler.this.speller.setControlButtonStates(-1, 0);
            SdarsSpellerHandler.this.prepare("");
            SdarsSpellerHandler.this.clearTimer.cancel();
            SdarsSpellerHandler.this.selectTimer.cancel();
        }

        public void textChanged(int n, String string, char c2, int n2) {
            SdarsSpellerHandler.this.prepare(string);
            int n3 = string.length() > 0 ? Integer.parseInt(string) : -1;
            this.station = SdarsSpellerHandler.this.guiHandler.getStationByChannelNumber(n3);
            boolean bl = this.station != null || n3 == 0;
            String string2 = "";
            if (this.station != null && Utilities.isEmpty(string2 = this.station.fullLabel)) {
                string2 = this.station.shortLabel;
            }
            SdarsSpellerHandler.this.tempStationName.setText(string2);
            if (bl) {
                SdarsSpellerHandler.this.selectTimer.restart();
                SdarsSpellerHandler.this.clearTimer.cancel();
            } else {
                SdarsSpellerHandler.this.clearTimer.restart();
                SdarsSpellerHandler.this.selectTimer.cancel();
            }
            SdarsSpellerHandler.this.speller.setControlButtonStates(-1, bl ? 1 : 0);
        }
    }

    private class TunerActionProxyListenerExt
    extends TunerActionProxyListener {
        private TunerActionProxyListenerExt() {
        }

        public void spellerLeft() {
            SdarsSpellerHandler.this.clearTimer.cancel();
            SdarsSpellerHandler.this.selectTimer.cancel();
            SdarsSpellerHandler.this.speller.clear();
            SdarsSpellerHandler.this.prepare("");
        }
    }
}

