/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;
import de.audi.tone.app.sound.BalanceFader;

public class FaderRange
extends AbstractSoundRange {
    public static final int MODEL;
    private final BalanceFader balanceFader;

    FaderRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, BalanceFader balanceFader, int n) {
        super(iDSISoundHandler, toneEnv, 1799491328, n, true);
        this.balanceFader = balanceFader;
    }

    @Override
    void changeBy(int n) {
        this.dsiSound.changeFader(this.hmiTerminal, n);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "[FaderRange.keyPressed]");
        this.balanceFader.setActiveStatus(2);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.env.lcHMI.log(-2137614336, "[FaderRange.keyReleased]");
        this.balanceFader.setActiveStatus(0);
    }
}

