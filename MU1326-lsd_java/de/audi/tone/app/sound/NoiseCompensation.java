/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;
import de.audi.tone.app.sound.NoiseCompensation$CheckboxListener;

public class NoiseCompensation
extends AbstractSoundRange {
    public static final int MODEL;
    private final ToneEnv env;

    NoiseCompensation(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1732382464, -1723724032, n, false);
        this.env = toneEnv;
        toneEnv.getChoiceModel(1849822976).setChoiceListener(new NoiseCompensation$CheckboxListener(this, null));
    }

    @Override
    void changeBy(int n) {
        this.dsiSound.changeNoiseCompensation(n);
    }

    @Override
    protected void updateValue(int n) {
        super.updateValue(n);
        this.env.getChoiceModel(1849822976).setValue(n);
    }
}

