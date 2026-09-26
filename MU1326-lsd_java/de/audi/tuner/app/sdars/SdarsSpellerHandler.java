/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.GUIHandlerSDARS;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$DsiUpListener;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$SpellerListener;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$TimerListener;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$TunerActionProxyListenerExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.IScanHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SdarsSpellerHandler {
    private static final long AUTO_CLEAR_DELAY;
    private static final long AUTO_SELECT_DELAY;
    private static final int SUBS_SCREEN_TRIGGER_TICK;
    private static final int SUBS_SCREEN_TRIGGER_TOCK;
    public final SDARSDsiUpInfo dsiUpInfo = new SdarsSpellerHandler$DsiUpListener(this, null);
    public final TunerActionProxyListener proxyListener = new SdarsSpellerHandler$TunerActionProxyListenerExt(this, null);
    private final TunerModels models;
    private final SDARSTuner tuner;
    private final GUIHandlerSDARS guiHandler;
    private final IScanHandler scanHandler;
    private final MatchspellerModelApp speller;
    private final LabelModelApp tempStationName;
    private final Timer clearTimer;
    private final Timer selectTimer;
    private final SdarsSpellerHandler$SpellerListener spellerListener = new SdarsSpellerHandler$SpellerListener(this, null);
    private final HashMap validKeys = new HashMap(100);

    public SdarsSpellerHandler(TunerBasics tunerBasics, GUIHandlerSDARS gUIHandlerSDARS, SDARSTuner sDARSTuner, IScanHandler iScanHandler) {
        this.models = tunerBasics.getModels();
        this.guiHandler = gUIHandlerSDARS;
        this.tuner = sDARSTuner;
        this.scanHandler = iScanHandler;
        SdarsSpellerHandler$TimerListener sdarsSpellerHandler$TimerListener = new SdarsSpellerHandler$TimerListener(this, null);
        this.clearTimer = new Timer("clearTimer", 0, true, sdarsSpellerHandler$TimerListener);
        this.selectTimer = new Timer("selectTimer", 0, true, sdarsSpellerHandler$TimerListener);
        this.speller = this.models.getMatchspellerModel(-360185600);
        this.tempStationName = this.models.getLabelModel(-947322624);
        this.speller.setSpellerListener(this.spellerListener);
        this.models.getChoiceModel(-209190656).setValue(1);
    }

    private void prepare(String string) {
        if (string.length() == 0) {
            this.models.getChoiceModel(-209190656).setValue(1);
        } else {
            this.models.getChoiceModel(-209190656).setValue(0);
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

    static /* synthetic */ IScanHandler access$400(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.scanHandler;
    }

    static /* synthetic */ SDARSTuner access$500(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.tuner;
    }

    static /* synthetic */ TunerModels access$600(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.models;
    }

    static /* synthetic */ MatchspellerModelApp access$700(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.speller;
    }

    static /* synthetic */ void access$800(SdarsSpellerHandler sdarsSpellerHandler, String string) {
        sdarsSpellerHandler.prepare(string);
    }

    static /* synthetic */ Timer access$900(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.clearTimer;
    }

    static /* synthetic */ Timer access$1000(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.selectTimer;
    }

    static /* synthetic */ GUIHandlerSDARS access$1100(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.guiHandler;
    }

    static /* synthetic */ LabelModelApp access$1200(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.tempStationName;
    }

    static /* synthetic */ HashMap access$1300(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.validKeys;
    }

    static /* synthetic */ void access$1400(SdarsSpellerHandler sdarsSpellerHandler, String string, String string2) {
        sdarsSpellerHandler.mapNumber(string, string2);
    }

    static /* synthetic */ SdarsSpellerHandler$SpellerListener access$1500(SdarsSpellerHandler sdarsSpellerHandler) {
        return sdarsSpellerHandler.spellerListener;
    }
}

