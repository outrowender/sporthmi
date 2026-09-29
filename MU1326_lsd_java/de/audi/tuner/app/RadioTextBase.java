/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.RadioTextBase$TimerListener;
import de.audi.tuner.app.TunerBasics;

public class RadioTextBase {
    private final LabelModelApp radiotext;
    private final LabelModelApp rtPlusLine1;
    private final LabelModelApp rtPlusLine2;
    private final LabelModelApp rtPlusLine3;
    private final ModelGroup modelGroup = new ModelGroup();
    private boolean modeUnknown = true;
    private final Timer timer;
    private String bufferedTxt = "";

    public RadioTextBase(TunerBasics tunerBasics, int n, int n2, int n3, int n4) {
        this.radiotext = tunerBasics.getModels().getLabelModel(n);
        this.rtPlusLine1 = tunerBasics.getModels().getLabelModel(n2);
        this.rtPlusLine2 = tunerBasics.getModels().getLabelModel(n3);
        this.rtPlusLine3 = tunerBasics.getModels().getLabelModel(n4);
        this.modelGroup.add(this.radiotext);
        this.modelGroup.add(this.rtPlusLine1);
        this.modelGroup.add(this.rtPlusLine2);
        this.modelGroup.add(this.rtPlusLine3);
        this.timer = new Timer("unknown", 0, true, new RadioTextBase$TimerListener(this, null));
    }

    protected void reset() {
        this.modeUnknown = true;
        this.radiotext.setText("");
        this.rtPlusLine1.setText("");
        this.rtPlusLine2.setText("");
        this.rtPlusLine3.setText("");
        this.bufferedTxt = "";
        this.radiotext.setStatus(1);
        this.rtPlusLine1.setStatus(0);
        this.rtPlusLine2.setStatus(0);
        this.modelGroup.flush();
    }

    protected void updateRadiotext(String string) {
        if (this.modeUnknown && !this.timer.isRunning()) {
            this.bufferedTxt = string;
            this.timer.restart();
        } else {
            this.radiotext.setText(string);
            this.modelGroup.flush();
        }
    }

    protected void updateRadiotextPlus(String string, String string2, String string3) {
        this.rtPlusLine1.setText(string);
        this.rtPlusLine2.setText(string2);
        this.rtPlusLine3.setText(string3);
        if (string.length() != 0 || string2.length() != 0 || string3.length() != 0) {
            this.radiotext.setStatus(0);
            this.rtPlusLine1.setStatus(1);
            this.rtPlusLine2.setStatus(1);
        }
        this.modelGroup.flush();
    }

    static /* synthetic */ String access$100(RadioTextBase radioTextBase) {
        return radioTextBase.bufferedTxt;
    }

    static /* synthetic */ LabelModelApp access$200(RadioTextBase radioTextBase) {
        return radioTextBase.radiotext;
    }

    static /* synthetic */ ModelGroup access$300(RadioTextBase radioTextBase) {
        return radioTextBase.modelGroup;
    }

    static /* synthetic */ boolean access$402(RadioTextBase radioTextBase, boolean bl) {
        radioTextBase.modeUnknown = bl;
        return radioTextBase.modeUnknown;
    }
}

