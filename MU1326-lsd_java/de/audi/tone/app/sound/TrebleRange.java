/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;

public class TrebleRange
extends AbstractSoundRange {
    public static final int MODEL;

    TrebleRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1380060928, -1690169600, n, toneEnv.getSysConst(4519) == 1);
    }

    @Override
    void changeBy(int n) {
        this.dsiSound.changeTreble(this.hmiTerminal, n);
    }

    @Override
    protected void updateValue(int n) {
        super.updateValue(n);
        this.env.getChoiceModel(2000817920).setValue(n);
    }
}

