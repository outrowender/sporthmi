/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;

public class BassRange
extends AbstractSoundRange {
    public static final int MODEL = 1000038;

    BassRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1000038, 1000087, n, toneEnv.getSysConst(4519) == 1);
    }

    void changeBy(int n) {
        this.dsiSound.changeBass(this.hmiTerminal, n);
    }

    protected void updateValue(int n) {
        super.updateValue(n);
        this.env.getChoiceModel(1000048).setValue(n);
    }
}

