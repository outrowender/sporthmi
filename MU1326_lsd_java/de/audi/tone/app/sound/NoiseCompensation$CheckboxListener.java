/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tone.app.sound.NoiseCompensation;
import de.audi.tone.app.sound.NoiseCompensation$1;

class NoiseCompensation$CheckboxListener
extends DefaultChoiceListener {
    private final /* synthetic */ NoiseCompensation this$0;

    private NoiseCompensation$CheckboxListener(NoiseCompensation noiseCompensation) {
        this.this$0 = noiseCompensation;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.this$0.dsiSound.setNoiseCompensation(n2);
    }

    /* synthetic */ NoiseCompensation$CheckboxListener(NoiseCompensation noiseCompensation, NoiseCompensation$1 noiseCompensation$1) {
        this(noiseCompensation);
    }
}

