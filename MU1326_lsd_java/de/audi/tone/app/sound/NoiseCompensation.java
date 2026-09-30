/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;

public class NoiseCompensation
extends AbstractSoundRange {
    public static final int MODEL = 1000039;
    private final ToneEnv env;

    NoiseCompensation(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1000039, 1000089, n, false);
        this.env = toneEnv;
        toneEnv.getChoiceModel(1000046).setChoiceListener(new CheckboxListener());
    }

    void changeBy(int n) {
        this.dsiSound.changeNoiseCompensation(n);
    }

    protected void updateValue(int n) {
        super.updateValue(n);
        this.env.getChoiceModel(1000046).setValue(n);
    }

    private class CheckboxListener
    extends DefaultChoiceListener {
        private CheckboxListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            NoiseCompensation.this.dsiSound.setNoiseCompensation(n2);
        }
    }
}

