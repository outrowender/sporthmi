/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.tuner.app.amfm.AbstractAmFmSpellerHandler;

class AbstractAmFmSpellerHandler$SpellerListener
extends DefaultSpellerListener {
    private final /* synthetic */ AbstractAmFmSpellerHandler this$0;

    AbstractAmFmSpellerHandler$SpellerListener(AbstractAmFmSpellerHandler abstractAmFmSpellerHandler) {
        this.this$0 = abstractAmFmSpellerHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        AbstractAmFmSpellerHandler.access$200(this.this$0);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (c2 == '\b') {
            string = this.chrBackspace(string);
            this.this$0.spellerModel.setText(string);
        }
        this.this$0.setStationFromFrequency(string);
        AbstractAmFmSpellerHandler.access$300(this.this$0, string);
        String string2 = this.this$0.appendComma(string);
        this.this$0.appendHd(string2);
        if (this.this$0.station != null) {
            this.this$0.selectTimer.restart();
            this.this$0.clearTimer.cancel();
        } else {
            this.this$0.clearTimer.restart();
            this.this$0.selectTimer.cancel();
        }
        this.this$0.spellerModel.setControlButtonStates(-1, this.this$0.station != null ? 1 : 0);
    }

    private String chrBackspace(String string) {
        String string2 = "";
        if (this.this$0.station != null) {
            string2 = (String)this.this$0.hdSubchannelSpellerMap.get(this.this$0.station.getFrequencyString());
        }
        if (this.this$0.kommaPos != -1 && string.length() == this.this$0.kommaPos) {
            this.this$0.kommaPos = -1;
            return string.substring(0, string.length() - 1);
        }
        if (this.this$0.hdPos != -1 && (string.length() == this.this$0.hdPos + " HD".length() - 1 || string2.length() == 1)) {
            String string3 = this.this$0.kommaPos != -1 ? string.substring(0, this.this$0.kommaPos + 1) : string.substring(0, this.this$0.hdPos - 1);
            this.this$0.hdPos = -1;
            return string3;
        }
        return string;
    }
}

