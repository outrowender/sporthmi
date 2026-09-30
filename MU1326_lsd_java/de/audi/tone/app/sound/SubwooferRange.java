/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;

public class SubwooferRange
extends AbstractSoundRange {
    public static final int MODEL = 1000015;

    SubwooferRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1000015, 1000090, n, toneEnv.getSysConst(4519) == 1);
    }

    void changeBy(int n) {
        this.dsiSound.changeSubwoofer(this.hmiTerminal, n);
    }
}

