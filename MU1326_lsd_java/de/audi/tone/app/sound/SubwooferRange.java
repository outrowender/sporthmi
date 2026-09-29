/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;

public class SubwooferRange
extends AbstractSoundRange {
    public static final int MODEL;

    SubwooferRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1329729280, -1706946816, n, toneEnv.getSysConst(4519) == 1);
    }

    @Override
    void changeBy(int n) {
        this.dsiSound.changeSubwoofer(this.hmiTerminal, n);
    }
}

