/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;
import de.audi.tone.app.sound.BalanceFader;

public class BalanceRange
extends AbstractSoundRange {
    public static final int MODEL = 1000036;
    private final BalanceFader balanceFader;

    BalanceRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, BalanceFader balanceFader, int n) {
        super(iDSISoundHandler, toneEnv, 1000036, 1000083, n, true);
        this.balanceFader = balanceFader;
    }

    void changeBy(int n) {
        this.dsiSound.changeBalance(this.hmiTerminal, n);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[BalanceRange.keyPressed]");
        this.balanceFader.setActiveStatus(1);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[BalanceRange.keyReleased]");
        this.balanceFader.setActiveStatus(0);
    }
}

