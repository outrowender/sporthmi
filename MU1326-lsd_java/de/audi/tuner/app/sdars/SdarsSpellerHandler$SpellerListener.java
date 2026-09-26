/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.SdarsSpellerHandler;
import de.audi.tuner.app.sdars.SdarsSpellerHandler$1;
import de.audi.tuner.app.sdars.StationInfoExt;

class SdarsSpellerHandler$SpellerListener
extends DefaultSpellerListener {
    StationInfoExt station = null;
    private final /* synthetic */ SdarsSpellerHandler this$0;

    private SdarsSpellerHandler$SpellerListener(SdarsSpellerHandler sdarsSpellerHandler) {
        this.this$0 = sdarsSpellerHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (this.station != null) {
            SdarsSpellerHandler.access$400(this.this$0).abortScan();
            SdarsSpellerHandler.access$500(this.this$0).selectStation(this.station, n3);
            this.station = null;
        } else {
            ChoiceModelApp choiceModelApp;
            choiceModelApp.setValue((choiceModelApp = SdarsSpellerHandler.access$600(this.this$0).getChoiceModel(1820918016)).getValue() == 0 ? 1 : 0);
        }
        SdarsSpellerHandler.access$700(this.this$0).clear();
        SdarsSpellerHandler.access$700(this.this$0).setControlButtonStates(-1, 0);
        SdarsSpellerHandler.access$800(this.this$0, "");
        SdarsSpellerHandler.access$900(this.this$0).cancel();
        SdarsSpellerHandler.access$1000(this.this$0).cancel();
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        SdarsSpellerHandler.access$800(this.this$0, string);
        int n3 = string.length() > 0 ? Integer.parseInt(string) : -1;
        this.station = SdarsSpellerHandler.access$1100(this.this$0).getStationByChannelNumber(n3);
        boolean bl = this.station != null || n3 == 0;
        String string2 = "";
        if (this.station != null && Utilities.isEmpty(string2 = this.station.fullLabel)) {
            string2 = this.station.shortLabel;
        }
        SdarsSpellerHandler.access$1200(this.this$0).setText(string2);
        if (bl) {
            SdarsSpellerHandler.access$1000(this.this$0).restart();
            SdarsSpellerHandler.access$900(this.this$0).cancel();
        } else {
            SdarsSpellerHandler.access$900(this.this$0).restart();
            SdarsSpellerHandler.access$1000(this.this$0).cancel();
        }
        SdarsSpellerHandler.access$700(this.this$0).setControlButtonStates(-1, bl ? 1 : 0);
    }

    /* synthetic */ SdarsSpellerHandler$SpellerListener(SdarsSpellerHandler sdarsSpellerHandler, SdarsSpellerHandler$1 sdarsSpellerHandler$1) {
        this(sdarsSpellerHandler);
    }
}

